package com.hotelalura.core.controller;

import org.springframework.stereotype.Controller;

import com.hotelalura.core.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaseController {
    
	protected boolean isUserAuthenticated(HttpSession session) {
        Usuario user = (Usuario) session.getAttribute("user");
        return user != null && user.getEmail() != null && user.getPassword() != null;
}
    
}
