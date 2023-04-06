package com.hotelalura.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotelalura.core.model.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

	@Query("Select h from Habitacion h where h.hotel.idHotel = :idHotel")
	public List<Habitacion> obtenerHabitacionByHotel(@Param("idHotel") Integer idHotel);
}
