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

import com.hotelalura.core.model.Habitacion;
import com.hotelalura.core.model.Huesped;
import com.hotelalura.core.model.MetodoPago;
import com.hotelalura.core.model.Pais;
import com.hotelalura.core.model.Reservacion;
import com.hotelalura.core.service.HuespedService;
import com.hotelalura.core.service.MetodoPagoService;
import com.hotelalura.core.service.PaisService;
import com.hotelalura.core.service.ReservacionService;
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
	private ReservacionService reservaService;

	@Autowired
	private TipoHabitacionService tiposService;

	@Autowired
	private MetodoPagoService metodoPagoService;

	public List<Huesped> huespedes;

	public List<Pais> paises;

	public List<Habitacion> habitaciones;

	public List<MetodoPago> metodosPagos;
	
	public Reservacion reservacion;
	
	private boolean eliminado;
	
	private boolean modificado;

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

		ModelAndView model = new ModelAndView("reservasKomorebi");
		
		agregarDatosComunesAlModelo(model, 1);

		Boolean nuevo = (Boolean) session.getAttribute("nuevo");
		session.removeAttribute("nuevo");

		String habitacionNoDisponble = (String) session.getAttribute("habitacionNoDisponble");
		session.removeAttribute("habitacionNoDisponble");

		model.addObject("nuevo", nuevo);
		model.addObject("habitacionNoDisponble", habitacionNoDisponble);
		return model;
	}

	@GetMapping("/gokolura")
	public ModelAndView reservaGokotta(HttpSession session) {

		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}

		ModelAndView model = new ModelAndView("reservasGokotta");
		
		agregarDatosComunesAlModelo(model, 2);
		
		Boolean nuevo = (Boolean) session.getAttribute("nuevo");
		session.removeAttribute("nuevo");
		
		String habitacionNoDisponble = (String) session.getAttribute("habitacionNoDisponble");
		session.removeAttribute("habitacionNoDisponble");

		model.addObject("nuevo", nuevo);
		model.addObject("habitacionNoDisponble", habitacionNoDisponble);
		
		return model;
	}
	
	@PostMapping("/eliminar")
	public ModelAndView eliminarResever(@RequestParam("id") Integer idReserva, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/listaReservas");
		}
		eliminado = reservaService.eliminarReserva(idReserva);
		session.setAttribute("eliminado", eliminado);
		return new ModelAndView("redirect:/listaReservas");
	}
	
	@PostMapping("/editar")
	public ModelAndView editarResever(@RequestParam("id") Integer id, @RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin, HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/listaReservas");
		}
		reservacion = reservaService.obteneReservaById(id);
		reservacion.setFechaInicio(fechaInicio);
		reservacion.setFechaFin(fechaFin);
		modificado = reservaService.modificarReserva(reservacion);
		session.setAttribute("modificado", modificado);
		return new ModelAndView("redirect:/listaReservas");
	}

	private void agregarDatosComunesAlModelo(ModelAndView model, Integer idHotel) {
		List<String> habitacionesTipos = obtenerTiposDeHabitacionPorHotel(idHotel);
		metodosPagos = metodoPagoService.obtenerTodos();
		huespedes = huespedService.obtenerTodos();
		paises = paisService.obtenerTodos();
		model.addObject("metodos", metodosPagos);
		model.addObject("huespedes", huespedes);
		model.addObject("paises", paises);
		model.addObject("habitaciones", habitacionesTipos);
	}

	private List<String> obtenerTiposDeHabitacionPorHotel(int hotelId) {
		return tiposService.obtenerNombresTiposHabitacionByHotel(hotelId);
	}
	
	
}
