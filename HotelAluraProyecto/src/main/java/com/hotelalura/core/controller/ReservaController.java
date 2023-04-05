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
	
	@GetMapping("/alurebi")
	public String reservaKomorebi(HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
            return "redirect:/accesoDenegado";
        }
		return "reservasKomorebi";
	}
	
	@GetMapping("/gokolura")
	public String reservaGokotta(HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
            return "redirect:/accesoDenegado";
        }
		return "reservasGokotta";
	}
}

