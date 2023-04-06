package com.hotelalura.core.service;

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
}
