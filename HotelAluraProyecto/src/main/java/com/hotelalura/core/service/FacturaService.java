package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.Factura;
import com.hotelalura.core.repository.FacturaRepository;

@Service
public class FacturaService {

	@Autowired
	private FacturaRepository facturaRepo;
	
	public Factura obtenerByIdReserva(Integer idReserva) {
		return facturaRepo.findById(idReserva).orElseThrow(null);
	}
	
	public List<Factura> obtenerTodas(){
		return facturaRepo.findAll();
	}
}
