package com.hotelalura.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservas")
public class ReservaController extends BaseController{

	@GetMapping()
	public String reserva(HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
            return "redirect:/accesoDenegado";
        }
		return "reservas";
	}
}
