package com.hotelalura.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class HomeController extends BaseController{

    @GetMapping()
    public String index(HttpSession session) {
    	
    	if (!isUserAuthenticated(session)) {
            return "redirect:/accesoDenegado";
        }
        return "index";
    }
}
