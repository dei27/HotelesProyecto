package com.hotelalura.core.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private List<Huesped> huespedes;
	
	private Huesped huesped;
	
	private List<Pais> paises;
	
	private boolean isNuevo;
	
	private boolean isEliminadoHuesped;
	
	private boolean isModificadoHuesped;
	

	@PostMapping("/nuevo")
	public ModelAndView nuevoHuesped(@RequestParam("destino") String destino, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("email") String email, @RequestParam("fechaNacimiento") LocalDate fechaNacimiento, @RequestParam("pais") Integer idPais, @RequestParam("telefono") String telefono, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("redirect:" + destino);
		pais = paisService.obtenerByIdPais(idPais);
		isNuevo = huespedService.nuevoHuesped(new Huesped(nombre, apellido, email, fechaNacimiento, pais, telefono));
		session.setAttribute("nuevo", isNuevo);
		return model;
	}
	
	@GetMapping("/lista")
	public ModelAndView listaHuespedes(HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("listaHuespedes");
		huespedes = huespedService.obtenerTodos();
		paises = paisService.obtenerTodos();
		
		Boolean isEliminadoHuesped = (Boolean) session.getAttribute("eliminadoHuesped");
		session.removeAttribute("eliminadoHuesped");
		
		Boolean isModificadoHuesped = (Boolean) session.getAttribute("modificadoHuesped");
		session.removeAttribute("modificadoHuesped");
		
		model.addObject("paises", paises);
		model.addObject("huespedes", huespedes);
		model.addObject("eliminadoHuesped", isEliminadoHuesped);
		model.addObject("modificadoHuesped", isModificadoHuesped);
		return model;
	}
	
	@PostMapping("/eliminar")
	public ModelAndView eliminarHuesped(@RequestParam("id") Integer idHuesped, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		isEliminadoHuesped = huespedService.eliminarHuesped(idHuesped);
		session.setAttribute("eliminadoHuesped", isEliminadoHuesped);
		return new ModelAndView("redirect:/huesped/lista");
	}
	
	@PostMapping("/editar")
	public ModelAndView editarHuesped(@RequestParam("idHuesped") Integer idHuesped, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("correo") String correo, @RequestParam("fechaNacimiento") LocalDate fechaNacimiento, @RequestParam("pais") Integer idPais, @RequestParam("telefono") String telefono, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("redirect:/huesped/lista");
		pais = paisService.obtenerByIdPais(idPais);
		huesped = huespedService.obtenerUnHuesped(idHuesped);
		huesped.setNombre(nombre);
		huesped.setApellido(apellido);
		huesped.setFechaNacimiento(fechaNacimiento);
		huesped.setPais(pais);
		huesped.setTelefono(telefono);
		isModificadoHuesped = huespedService.nuevoHuesped(huesped);
		session.setAttribute("modificadoHuesped", isModificadoHuesped);
		return model;
	}
}
