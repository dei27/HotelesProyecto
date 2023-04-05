package com.hotelalura.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accesoDenegado")
public class AccesoDenegadoController {

	@GetMapping()
	public String accesoDenegado() {
		return "accesoDenegado";
	}
}
