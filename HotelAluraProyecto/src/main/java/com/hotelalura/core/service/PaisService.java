package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.Pais;
import com.hotelalura.core.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepo;
	
	public List<Pais> obtenerTodos(){
		return paisRepo.findAll();
	}
	
	public Pais obtenerByIdPais(Integer idPais) {
		return paisRepo.findById(idPais).orElseThrow(null);
	};
}
