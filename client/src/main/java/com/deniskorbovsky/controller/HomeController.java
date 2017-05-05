package com.deniskorbovsky.controller;

import com.deniskorbovsky.model.Tea;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@ComponentScan(basePackages = "com.deniskorbovsky.service")
public class HomeController {

    private final CountryService countryService;

    private final TeaService teaService;

    private final TypeService typeService;

    private final CartService cartService;

    @Autowired
    public HomeController(final CountryService countryService, final TeaService teaService, final TypeService typeService, final CartService cartService) {
        this.countryService = countryService;
        this.teaService = teaService;
        this.typeService = typeService;
        this.cartService = cartService;
    }

    @ModelAttribute
    public void addCommonElements(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("cartSize", cartService.getAmountOfSales());
        model.addAttribute("user", getPrincipal());
    }

    @RequestMapping(value = {"", "/", "/index", "/home"}, method = RequestMethod.GET)
    public ModelAndView viewAllTeasOnFirstPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getAllTea(1, 3);
        int amountOfTea = teaService.getAllTea().size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3 + 1));
        modelAndView.addObject("url", "/home/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/home/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewAllTeasOnSpecificPage(@PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getAllTea(numberOfPage, 3);
        int amountOfTea = teaService.getAllTea().size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3 + 1));
        modelAndView.addObject("url", "/home/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public void showImage(@PathVariable("id") final int id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(teaService.getTeaById(id).getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
    public ModelAndView viewSpecificTypeTeasOnFirstPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getTeasByType(id, 1, 3);
        int amountOfTea = teaService.getTeasByType(id).size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3 + 1));
        modelAndView.addObject("url", "/type/" + id + "/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/type/{id}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewSpecificTypeTeasOnSpecificPage(@PathVariable("id") final int id, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getTeasByType(id, numberOfPage, 3);
        int amountOfTea = teaService.getTeasByType(id).size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3 + 1));
        modelAndView.addObject("url", "/type/" + id + "/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    public ModelAndView viewSpecificCountryTeasOnFirstPage(@PathVariable("id") final int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getTeasByCountry(id, 1, 3);
        int amountOfTea = teaService.getTeasByCountry(id).size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3 + 1));
        modelAndView.addObject("url", "/country/" + id + "/");
        modelAndView.addObject("openedPage", 1);
        return modelAndView;
    }

    @RequestMapping(value = "/country/{id}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView viewSpecificCountryTeasOnSpecificPage(@PathVariable("id") final int id,  @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getTeasByCountry(id, numberOfPage, 3);
        int amountOfTea = teaService.getTeasByCountry(id).size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3  + 1));
        modelAndView.addObject("url", "/country/" + id + "/");
        modelAndView.addObject("openedPage", numberOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchTeas(@RequestParam("searchValue") final String searchValue) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getTeasBySearch(new String (searchValue.getBytes ("iso-8859-1"), "UTF-8"), 1, 3);
        int amountOfTea = teaService.getTeasBySearch(new String (searchValue.getBytes ("iso-8859-1"), "UTF-8")).size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3  + 1));
        modelAndView.addObject("url", "/search/");
        modelAndView.addObject("openedPage", 1);
        modelAndView.addObject("searchValue", new String (searchValue.getBytes ("iso-8859-1"), "UTF-8"));
        return modelAndView;
    }

    @RequestMapping(value = "/search/{searchValue}/{numberOfPage}", method = RequestMethod.GET)
    public ModelAndView searchTeas(@PathVariable("searchValue") final String searchValue, @PathVariable("numberOfPage") final int numberOfPage) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Tea> teaList = teaService.getTeasBySearch(searchValue, numberOfPage, 3);
        int amountOfTea = teaService.getTeasBySearch(searchValue).size();
        modelAndView.addObject("teas", teaList);
        modelAndView.addObject("amountOfPages", (amountOfTea % 3 == 0) ? (amountOfTea / 3) : (amountOfTea / 3  + 1));
        modelAndView.addObject("url", "/search/");
        modelAndView.addObject("openedPage", numberOfPage);
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
