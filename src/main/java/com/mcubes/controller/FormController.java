package com.mcubes.controller;

import com.mcubes.entity.AppUser;
import com.mcubes.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
@Controller
public class FormController {

    private static final Logger LOG = Logger.getLogger(FormController.class.getName());
    @Autowired
    private AppUserService appUserService;

    @RequestMapping("/home")
    public String home(Model model, Principal principal){
        String email = principal.getName();
        AppUser appUser = appUserService.appUserByEmail(email);
        appUser.setPassword(null);
        model.addAttribute("appUser", appUser);
        return "/home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/registration")
    public String registration(Model model){
        AppUser appUser = new AppUser();
        model.addAttribute("appUser", appUser);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute @Valid AppUser appUser, Errors errors, Model model){
        // Server side form validation
        LOG.log(Level.INFO, "AppUser : " + appUser.toString());
        if(errors.hasErrors()) {
            model.addAttribute("appUser", appUser);
            return "registration";
        }
        // Check weather entering email address already exist or not.
        if(appUserService.isExist(appUser.getEmail())){
            model.addAttribute("error", "This email address already exist.");
            return "registration";
        }
        appUserService.save(appUser);
        return "registration_success";
    }

}
