package com.hotelalura.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "facturacion")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private Integer idFactura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reservacion", nullable = false)
	private Reservacion reservacion;

	@Column(name = "monto_total", nullable = false)
	private BigDecimal montoTotal;

	@Column(name = "fecha_pago", nullable = false)
	private LocalDate fechaPago;
	

	public Factura() {
	}

	public Factura(Reservacion reservacion, BigDecimal montoTotal, LocalDate fechaPago) {
		this.reservacion = reservacion;
		this.montoTotal = montoTotal;
		this.fechaPago = fechaPago;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Reservacion getReservacion() {
		return reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
}