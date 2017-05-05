package com.deniskorbovsky.controller;

import com.deniskorbovsky.service.interfaces.CartService;
import com.deniskorbovsky.service.interfaces.CountryService;
import com.deniskorbovsky.service.interfaces.TeaService;
import com.deniskorbovsky.service.interfaces.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan(basePackages = "com.deniskorbovsky.service")
public class TeaPageController {

    private final CountryService countryService;

    private final TeaService teaService;

    private final TypeService typeService;

    private final CartService cartService;

    @Autowired
    public TeaPageController(final CountryService countryService, final TeaService teaService, final TypeService typeService, final CartService cartService) {
        this.countryService = countryService;
        this.teaService = teaService;
        this.typeService = typeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("user", getPrincipal());
    }

    @ModelAttribute
    public void leftMenu(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
    }

    @RequestMapping(value="/tea-details/{id}", method = RequestMethod.GET)
    public ModelAndView viewTeaInfo(@PathVariable("id") final int idOfTea) {
        ModelAndView modelAndView = new ModelAndView("product-details");
        modelAndView.addObject("tea", teaService.getTeaById(idOfTea));
        modelAndView.addObject("recommendedTeas1", teaService.getAllTea(1, 3));
        modelAndView.addObject("recommendedTeas2", teaService.getAllTea(2, 3));
        return modelAndView;
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