package com.hotelalura.core.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel", nullable = false)
    private Hotel hotel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_habitacion", nullable = false)
    private TipoHabitacion tipoHabitacion;
    
    @Column(name = "num_habitacion", nullable = false)
    private Integer numHabitacion;
    
    @Column(name = "precio_habitacion", nullable = false)
    private BigDecimal precio;
    
    @Column(name = "max_personas", nullable = false)
    private Integer maxPersonas;
    
    @Column(name = "disponible", nullable = false, columnDefinition = "boolean default true")
    private boolean disponible;
    
    public Habitacion() {}

	public Habitacion(Hotel hotel, TipoHabitacion tipoHabitacion, int numHabitacion, BigDecimal precio, int maxPersonas) {
		this.hotel = hotel;
		this.tipoHabitacion = tipoHabitacion;
		this.numHabitacion = numHabitacion;
		this.precio = precio;
		this.maxPersonas = maxPersonas;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Integer idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(Integer numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getMaxPersonas() {
		return maxPersonas;
	}

	public void setMaxPersonas(Integer maxPersonas) {
		this.maxPersonas = maxPersonas;
	}
    
    
}
