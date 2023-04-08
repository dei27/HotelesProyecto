package com.hotelalura.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelalura.core.model.Factura;
import com.hotelalura.core.service.FacturaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/listaReservas")
public class ListaReservaController extends BaseController {

	@Autowired
	private FacturaService facturaService;
	
	private List<Factura> facturas;
	
	@GetMapping()
	public ModelAndView listarReservas(HttpSession session) {
		
		if (!isUserAuthenticated(session)) {
			return new ModelAndView("redirect:/accesoDenegado");
		}
		
		ModelAndView model = new ModelAndView("listaReservas");
		facturas = facturaService.obtenerTodas();
		
		Boolean eliminado = (Boolean) session.getAttribute("eliminado");
		session.removeAttribute("eliminado");
		
		Boolean modificado = (Boolean) session.getAttribute("modificado");
		session.removeAttribute("modificado");
		
		model.addObject("eliminado", eliminado);
		model.addObject("modificado", modificado);
		model.addObject("facturas", facturas);
		return model;
	}
}
