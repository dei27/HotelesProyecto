package com.hotelalura.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotelalura.core.model.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {

	@Query("SELECT DISTINCT th.nombre FROM Habitacion h "
			+ "INNER JOIN h.tipoHabitacion th "
			+ "WHERE h.hotel.idHotel = :idHotel")
	public List<String> obtenerNombresTiposHabitacionByHotel(@Param("idHotel") Integer idHotel);
	
	public TipoHabitacion findByNombre(String nombre);
}
