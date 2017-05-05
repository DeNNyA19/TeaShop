package com.deniskorbovsky.controller;

import com.deniskorbovsky.service.interfaces.OrderService;
import com.deniskorbovsky.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
@ComponentScan(basePackages = "com.deniskorbovsky.service")
public class OrderController {

    @Autowired
    private StatusService statusService;

    @Autowired
    private OrderService orderService;

    @ModelAttribute
    public void viewAllOrders(Model model) {
        model.addAttribute("statuses", statusService.getStatuses());
        model.addAttribute("orders", orderService.getAllOrders());
    }

    @RequestMapping("/orders")
    public ModelAndView viewAllOrders() {
        return new ModelAndView("orders");
    }

    @RequestMapping(value = "orders/changeStatus", method = RequestMethod.POST)
    public ModelAndView changeStatus(@RequestParam("id") final int id, @RequestParam("changedStatus") final String status) throws UnsupportedEncodingException {
        orderService.updateStatus(id, status);
        return new ModelAndView("redirect:/orders");
    }
}
