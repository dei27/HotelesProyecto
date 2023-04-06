package com.hotelalura.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelalura.core.model.Habitacion;
import com.hotelalura.core.model.Huesped;
import com.hotelalura.core.model.MetodoPago;
import com.hotelalura.core.model.Pais;
import com.hotelalura.core.service.HuespedService;
import com.hotelalura.core.service.MetodoPagoService;
import com.hotelalura.core.service.PaisService;
import com.hotelalura.core.service.TipoHabitacionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservas")
public class ReservaController extends BaseController {

	@Autowired
	private HuespedService huespedService;
	
	@Autowired
	private PaisService paisService;

	@Autowired
	private TipoHabitacionService tiposService;

	@Autowired
	private MetodoPagoService metodoPagoService;

	public List<Huesped> huespedes;
	
	public List<Pais> paises;

	public List<Habitacion> habitaciones;

	public List<MetodoPago> metodosPagos;

	@GetMapping("/lista")
	public String reserva(HttpSession session) {

		if (!isUserAuthenticated(session)) {
			return "redirect:/accesoDenegado";
		}
		return "reservasLista";
	}

	@GetMapping("/alurebi")
	public ModelAndView reservaAlurebi(HttpSession session) {

		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		ModelAndView model = new ModelAndView("reservasGokotta");
		List<String> habitacionesTipos = tiposService.obtenerNombresTiposHabitacionByHotel(1);
		metodosPagos = metodoPagoService.obtenerTodos();
		huespedes = huespedService.obtenerTodos();
		model.addObject("habitaciones", habitacionesTipos);
		model.addObject("metodos", metodosPagos);
		model.addObject("huespedes", huespedes);
		return model;
	}

	@GetMapping("/gokolura")
	public ModelAndView reservaGokotta(HttpSession session) {

		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}

		ModelAndView model = new ModelAndView("reservasGokotta");
		List<String> habitacionesTipos = tiposService.obtenerNombresTiposHabitacionByHotel(1);
		metodosPagos = metodoPagoService.obtenerTodos();
		huespedes = huespedService.obtenerTodos();
		paises = paisService.obtenerTodos();
		model.addObject("habitaciones", habitacionesTipos);
		model.addObject("metodos", metodosPagos);
		model.addObject("huespedes", huespedes);
		model.addObject("paises", paises);
		Boolean nuevo = (Boolean) session.getAttribute("nuevo");
	    session.removeAttribute("nuevo");
	    model.addObject("nuevo", nuevo);
		return model;
	}
}
