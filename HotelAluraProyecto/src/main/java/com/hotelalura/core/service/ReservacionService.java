package com.hotelalura.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.Reservacion;
import com.hotelalura.core.repository.ReservacionRepository;

@Service
public class ReservacionService {

	@Autowired
	private ReservacionRepository reservaRepo;
	
	public Integer nuevaReserva(Reservacion reserva) {
		Reservacion reservaGuardada = reservaRepo.save(reserva);
	    return reservaGuardada.getIdReservacion();
	}
	
	public List<Reservacion> obtenerTodas(){
		return reservaRepo.findAll();
	}
	
	public Reservacion obteneReservaById(Integer idReserva) {
		return reservaRepo.findById(idReserva).orElseThrow(null);
	}
	
	public Boolean eliminarReserva(Integer idReserva) {
		
		try {
			reservaRepo.deleteById(idReserva);;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean modificarReserva(Reservacion reserva) {
		
		try {
			reservaRepo.save(reserva);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
