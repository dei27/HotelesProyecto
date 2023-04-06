package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.Huesped;
import com.hotelalura.core.repository.HuespedRepository;

@Service
public class HuespedService {

	@Autowired
	private HuespedRepository huespedRepo;
	
	public List<Huesped> obtenerTodos(){
		return huespedRepo.findAll();
	}
}
