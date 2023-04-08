package com.hotelalura.core.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelalura.core.model.Factura;
import com.hotelalura.core.model.Habitacion;
import com.hotelalura.core.model.Huesped;
import com.hotelalura.core.model.MetodoPago;
import com.hotelalura.core.model.Reservacion;
import com.hotelalura.core.model.TipoHabitacion;
import com.hotelalura.core.service.FacturaService;
import com.hotelalura.core.service.HabitacionService;
import com.hotelalura.core.service.HuespedService;
import com.hotelalura.core.service.MetodoPagoService;
import com.hotelalura.core.service.ReservacionService;
import com.hotelalura.core.service.TipoHabitacionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/factura")
public class FacturaController extends BaseController {

	@Autowired
	private ReservacionService reservaService;

	@Autowired
	private TipoHabitacionService tipoService;

	@Autowired
	private HuespedService huespedService;

	@Autowired
	private MetodoPagoService metodoService;
	
	@Autowired
	private FacturaService facturaService;

	@Autowired
	private HabitacionService habitacionService;

	private Integer idReserva;

	private MetodoPago metodo;

	private TipoHabitacion tipo;

	private Huesped huesped;

	private Habitacion habitacionDisponible;
	
	private Factura factura;

	@PostMapping("/alurebi")
	public ModelAndView facturaAlurebi(@RequestParam("huesped") Integer idHuesped,
			@RequestParam("habitacion") String habitacion, @RequestParam("fechaInicio") LocalDate fechaInicio,
			@RequestParam("fechaFin") LocalDate fechaFin, @RequestParam("cantidadPersonas") Integer numPersonas,
			@RequestParam("metodoPago") Integer metodoPago, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("factura");
		huesped = huespedService.obtenerUnHuesped(idHuesped);
		tipo = tipoService.obtenerByNombre(habitacion);
		metodo = metodoService.obtenerById(metodoPago);
		habitacionDisponible = habitacionService.obtenerHabitacionDispoble(1, tipo.getIdTipoHabitacion());

		if (habitacionDisponible != null) {
			idReserva = reservaService.nuevaReserva(new Reservacion(huesped, habitacionDisponible, fechaInicio, fechaFin, numPersonas, metodo));
			factura = facturaService.obtenerByIdReserva(idReserva);
			model.addObject("factura", factura);
		}else {
			String habitacionNoDisponble = "No hay habitaciones disponibles en este momento para el tipo seleccionado";
			session.setAttribute("habitacionNoDisponble", habitacionNoDisponble);
			return new ModelAndView("redirect:/reservas/alurebi");
		}

		return model;
	}

	@PostMapping("/gokolura")
	public ModelAndView facturaGokolura(@RequestParam("huesped") Integer idHuesped,
			@RequestParam("habitacion") String habitacion, @RequestParam("fechaInicio") LocalDate fechaInicio,
			@RequestParam("fechaFin") LocalDate fechaFin, @RequestParam("cantidadPersonas") Integer numPersonas,
			@RequestParam("metodoPago") Integer metodoPago, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("factura");
		huesped = huespedService.obtenerUnHuesped(idHuesped);
		tipo = tipoService.obtenerByNombre(habitacion);
		metodo = metodoService.obtenerById(metodoPago);
		habitacionDisponible = habitacionService.obtenerHabitacionDispoble(2, tipo.getIdTipoHabitacion());

		if (habitacionDisponible != null) {
			idReserva = reservaService.nuevaReserva(new Reservacion(huesped, habitacionDisponible, fechaInicio, fechaFin, numPersonas, metodo));
			factura = facturaService.obtenerByIdReserva(idReserva);
			model.addObject("factura", factura);
		}else {
			String habitacionNoDisponble = "No hay habitaciones disponibles en este momento para el tipo seleccionado";
			session.setAttribute("habitacionNoDisponble", habitacionNoDisponble);
			return new ModelAndView("redirect:/reservas/gokolura");
		}

		return model;
	}
}
