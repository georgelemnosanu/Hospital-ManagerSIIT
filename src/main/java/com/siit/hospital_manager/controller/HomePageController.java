package com.siit.hospital_manager.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.siit.hospital_manager.util.AuthUtils.*;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("message", "Hospital Manager v1");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "accountCreated", required = false) boolean accountCreated){
        if (accountCreated) {
            model.addAttribute("successMessage", "Account created successfully!");
        }
        return "login";
    }


    @GetMapping("/default")
    public String succesPage(HttpServletRequest request){
        if(request.isUserInRole("ADMIN")){
            return "redirect:/";
        }
        else
            return "redirect:/indexUser";
    }


    @GetMapping("/indexUser")
    public String indexUser(){
        return "indexUser";
    }

//    @GetMapping("/dashboard")
//    public String dashBoard(Model model, Authentication authentication){
//        model.addAttribute("userName", authentication.getName());
//        model.addAttribute("isAdmin", isAdmin(authentication));
//        model.addAttribute("isPatient", isPatient(authentication));
//        model.addAttribute("isDoctor", isDoctor(authentication));
//
//
//        model.addAttribute("message", "Hospital Manager v1");
//        return "dashboard/dashboard";
//    }

}
