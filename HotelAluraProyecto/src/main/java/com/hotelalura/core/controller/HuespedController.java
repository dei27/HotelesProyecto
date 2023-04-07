package com.hotelalura.core.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelalura.core.model.Huesped;
import com.hotelalura.core.model.Pais;
import com.hotelalura.core.service.HuespedService;
import com.hotelalura.core.service.PaisService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/huesped")
public class HuespedController extends BaseController {

	@Autowired
	private PaisService paisService;
	
	@Autowired
	private HuespedService huespedService;
	
	private Pais pais;
	
	private boolean isNuevo;
	
	
	@PostMapping("/nuevo")
	public ModelAndView nuevoHuesped(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("email") String email, @RequestParam("fechaNacimiento") LocalDate fechaNacimiento, @RequestParam("pais") Integer idPais, @RequestParam("telefono") String telefono, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("redirect:/reservas/gokolura");
		pais = paisService.obtenerByIdPais(idPais);
		isNuevo = huespedService.nuevoHuesped(new Huesped(nombre, apellido, email, fechaNacimiento, pais, telefono));
		session.setAttribute("nuevo", isNuevo);
		return model;
	}
}
