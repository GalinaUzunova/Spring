package org.pathfinder2.web;

import jakarta.validation.Valid;
import org.pathfinder2.model.LoginDto;
import org.pathfinder2.model.UserLevel;
import org.pathfinder2.model.UserProfileDto;
import org.pathfinder2.servises.UserServiceImpl;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

//    @ModelAttribute("profileDate")
//    public UserProfileDto userProfileDto(){
//
//        return new UserProfileDto();
//    }


    @GetMapping("users/register")


    public String viewRegister(Model model) {
        if (!model.containsAttribute("registerData")) {
            model.addAttribute("registerData", new UserRegisterDto());
            model.addAttribute("level", UserLevel.values());


        }
        return "register";

    }

    @PostMapping("users/register")


    public String doRegister(@Valid UserRegisterDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult." +
                    "registerData", bindingResult);
            return "redirect:register";
        }
        userService.registerUser(data);
        return "redirect:/users/login";

    }

    @GetMapping("users/login")

    public String viewLogin(Model model) {
        if (!model.containsAttribute("loginData")) {
            model.addAttribute("loginData", new LoginDto());
        }

        return "login";
    }

    @PostMapping("users/login")

    public String doLogin(@Valid LoginDto loginDto, BindingResult bindingResult, RedirectAttributes
            redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginData", loginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);
            return "redirect:/users/login";
        }

        this.userService.userLogin(loginDto);
        return "redirect:/";

    }

    @PostMapping("/users/logout")

    public String logout() {
        userService.logout();

        return "redirect:/";
    }

    @GetMapping("/users/profile")

    public String gerProfile( Model model) {

        if (!model.containsAttribute("profileDate")) {
            model.addAttribute("profileDate", userService.getProfile());



        }
        return "profile";
    }
}











