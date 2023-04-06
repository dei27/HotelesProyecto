package com.hotelalura.core.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelalura.core.model.MetodoPago;
import com.hotelalura.core.service.ReservacionService;

@Controller
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	private ReservacionService reservaService;
	
	private Integer idReserva;
	
	@GetMapping("/alurebi")
	public ModelAndView facturaAlurebi(@RequestParam("huesped") Integer idHuesped, @RequestParam("habitacion") Integer habitacion, @RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin, @RequestParam("numPersonas") Integer numPersonas, @RequestParam("metodoPago") MetodoPago metodoPago ) {
		idReserva = reservaService.nuevaReserva(null);
		return null;
	}
	
	@GetMapping("/gokolura")
	public ModelAndView facturaGokolura() {
		return null;
	}
}
