package com.deniskorbovsky.controller;

import com.deniskorbovsky.model.Order;
import com.deniskorbovsky.model.Sale;
import com.deniskorbovsky.model.Status;
import com.deniskorbovsky.model.User;
import com.deniskorbovsky.service.interfaces.*;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

@Controller
@ComponentScan(basePackages = "com.deniskorbovsky.service")
public class CheckoutController {

    private final CartService cartService;
    private final UserService userService;
    private final SaleService saleService;
    private final OrderService orderService;

    @Autowired
    @Qualifier("orderValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @Autowired
    public CheckoutController(CartService cartService, UserService userService, SaleService saleService, OrderService orderService) {
        this.cartService = cartService;
        this.userService = userService;
        this.saleService = saleService;
        this.orderService = orderService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("cartSize", cartService.getAmountOfSales());
        model.addAttribute("user", getPrincipal());
        model.addAttribute("sales", cartService.getSales());
        model.addAttribute("loggedUser", userService.findByUsername(getPrincipal()));
        model.addAttribute("finalPrice", cartService.getFinalPrice());
    }

    @ModelAttribute("order")
    public Order createOrderModel() {
        return new Order();
    }

    @RequestMapping(value="checkout/view", method = RequestMethod.GET)
    public ModelAndView viewCheckout() {
        return new ModelAndView("checkout");
    }

    @RequestMapping(value="checkout/loggedOrder", method = RequestMethod.POST)
    public ModelAndView makeOrderLogged(@RequestParam("finalPrice") final int finalPrice) {
        ModelAndView modelAndView = new ModelAndView("redirect:/checkout/success");
        Order order = new Order();
        order.setDate(new LocalDate());
        order.setFinalPrice(finalPrice);
        order.setStatus(Status.NEW.getStatus());
        order.setUser(userService.findByUsername(getPrincipal()));
        order.setName(order.getUser().getName());
        order.setSurname(order.getUser().getSurname());
        order.setPhone(order.getUser().getPhone());
        order.setEmail(order.getUser().getEmail());
        int idOfOrder = orderService.saveOrder(order);
        for (Sale saleFromCart : cartService.getSales()) {
            Sale sale = new Sale();
            sale.setOrder(orderService.getOrderById(idOfOrder));
            sale.setTea(saleFromCart.getTea());
            sale.setAmount(saleFromCart.getAmount());
            saleService.saveSale(sale);
        }
        cartService.removeAllSales();
        return modelAndView;
    }

    @RequestMapping(value = "checkout/guestOrder", method = RequestMethod.POST)
    public ModelAndView makeOrderGuest(@ModelAttribute("order") @Validated Order order, BindingResult bindingResult, @RequestParam("finalPrice") final int finalPrice) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("redirect:/checkout/success");
        if(bindingResult.hasErrors()) {
            return new ModelAndView("checkout");
        }
        order.setName(new String (order.getName().getBytes("iso-8859-1"), "UTF-8"));
        if (!order.getSurname().equals(""))
            order.setSurname(new String (order.getSurname().getBytes("iso-8859-1"), "UTF-8"));
        else
            order.setSurname(null);
        if (order.getEmail().equals(""))
            order.setEmail(null);
        order.setDate(new LocalDate());
        order.setFinalPrice(finalPrice);
        order.setStatus(Status.NEW.getStatus());
        int idOfOrder = orderService.saveOrder(order);
        for (Sale saleFromCart : cartService.getSales()) {
            Sale sale = new Sale();
            sale.setOrder(orderService.getOrderById(idOfOrder));
            sale.setTea(saleFromCart.getTea());
            sale.setAmount(saleFromCart.getAmount());
            saleService.saveSale(sale);
        }
        cartService.removeAllSales();
        return modelAndView;

    }

    @RequestMapping(value="checkout/success", method = RequestMethod.GET)
    public ModelAndView orderSuccess() {
        return new ModelAndView("success");
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
