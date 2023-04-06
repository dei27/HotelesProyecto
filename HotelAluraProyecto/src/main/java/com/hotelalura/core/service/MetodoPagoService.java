package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.MetodoPago;
import com.hotelalura.core.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService {

	@Autowired
	private MetodoPagoRepository metodoPagoRepo;
	
	public List<MetodoPago> obtenerTodos(){
		return metodoPagoRepo.findAll();
	}
	
	public MetodoPago obtenerById(Integer idMetodo) {
		return metodoPagoRepo.findById(idMetodo).orElseThrow(null);
	}
}
