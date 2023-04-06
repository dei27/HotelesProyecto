package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.TipoHabitacion;
import com.hotelalura.core.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionService {
	
	@Autowired
	private TipoHabitacionRepository tiposRepo;
	
	public List<String> obtenerNombresTiposHabitacionByHotel(Integer idHotel){
		return tiposRepo.obtenerNombresTiposHabitacionByHotel(idHotel);
	}
	
	public TipoHabitacion obtenerByNombre(String nombre) {
		return tiposRepo.findByNombre(nombre);
	}
}
