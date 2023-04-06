package com.hotelalura.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelalura.core.model.Reservacion;

public interface ReservacionRepository extends JpaRepository<Reservacion, Integer> {

}
