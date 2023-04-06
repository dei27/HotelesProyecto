package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.Habitacion;
import com.hotelalura.core.repository.HabitacionRepository;

@Service
public class HabitacionService {

	@Autowired
	private HabitacionRepository habitacionRepo;
	
	public List<Habitacion> obtenerHabitacionesbyHotel(Integer idHotel){
		return habitacionRepo.obtenerHabitacionByHotel(idHotel);
	}
	
	public Habitacion obtenerHabitacionDispoble(Integer idHotel, Integer idTipo) {
		return habitacionRepo.obtenerHabitacionDisponible(idHotel, idTipo);
	}
	
}
