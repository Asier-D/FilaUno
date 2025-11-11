package com.mikeldi.dam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movimiento_stock")
public class MovimientoStock {

	@Id
	private long id;
	@Column
	private String fecha;
	@Column
	private String tipoMovimiento;
	@Column
	private int cantidad;
	@Column
	private String motivo;
	@Column
	private String referencia;
	
	public MovimientoStock(long id, String fecha, String tipoMovimiento, int cantidad, String motivo,
			String referencia) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.cantidad = cantidad;
		this.motivo = motivo;
		this.referencia = referencia;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	

	
}
