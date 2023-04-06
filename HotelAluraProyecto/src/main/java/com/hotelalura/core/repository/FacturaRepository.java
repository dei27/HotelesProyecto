package com.hotelalura.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelalura.core.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
