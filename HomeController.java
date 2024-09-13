package org.pathfinder2.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){

        double sofiaTemp=new Random().nextDouble();
//        ModelAndView mnv= new ModelAndView();
//        mnv.setViewName("index");
//        mnv.addObject("sofiaTemperature",sofiaTemp);
        model.addAttribute("sofiaTemperature", sofiaTemp);

        return "index";
    }
     @GetMapping("/about")
    public ModelAndView index() {
        return new ModelAndView("about");
    }
}
