package com.deniskorbovsky.controller;

import com.deniskorbovsky.model.Sale;
import com.deniskorbovsky.service.interfaces.CartService;
import com.deniskorbovsky.service.interfaces.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.deniskorbovsky.service")
public class CartController {

    private final CartService cartService;
    private final TeaService teaService;

    @Autowired
    public CartController(CartService cartService, TeaService teaService) {
        this.cartService = cartService;
        this.teaService = teaService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("cartSize", cartService.getAmountOfSales());
        model.addAttribute("user", getPrincipal());
    }

    @RequestMapping(value="cart/add", method = RequestMethod.POST)
    public ModelAndView addSaleToCart(@RequestParam("id") final int idOfTea, @RequestParam("url") final String url) {
        Sale sale = new Sale(teaService.getTeaById(idOfTea), 1);
        cartService.addSale(sale);
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping(value="cart/addAmount", method = RequestMethod.POST)
    public ModelAndView addAmountOfSaleToCart(@RequestParam("amount") final int amount, @RequestParam("id") final int id, @RequestParam("url") final String url) {
        cartService.addSale(new Sale(teaService.getTeaById(id), amount));
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping(value="cart/view", method = RequestMethod.GET)
    public ModelAndView viewCart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("sales", cartService.getSales());
        modelAndView.addObject("finalPrice", cartService.getFinalPrice());
        return modelAndView;
    }

    @RequestMapping(value="cart/remove/{idOfTea}", method = RequestMethod.GET)
    public ModelAndView removeSale(@PathVariable("idOfTea") final int idOfTea) {
        cartService.removeSale(new Sale(teaService.getTeaById(idOfTea)));
        return new ModelAndView("redirect:/cart/view");
    }

    @RequestMapping(value="cart/plus/{idOfTea}", method = RequestMethod.GET)
    public ModelAndView plusSale(@PathVariable("idOfTea") final int idOfTea) {
        cartService.addSale(new Sale(teaService.getTeaById(idOfTea), 1));
        return new ModelAndView("redirect:/cart/view");
    }

    @RequestMapping(value="cart/minus/{idOfTea}", method = RequestMethod.GET)
    public ModelAndView minusSale(@PathVariable("idOfTea") final int idOfTea) {
        cartService.addSale(new Sale(teaService.getTeaById(idOfTea), -1));
        return new ModelAndView("redirect:/cart/view");
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
