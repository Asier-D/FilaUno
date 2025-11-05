package com.mikeldi.dam.model;

public class LineaPedido {

	private long id;
	private int cantidad;
	private String descripcionProducto;
	private double precioUnitario;
	private double ivaPorcentaje;
	private double subtotalSinImpuestos;
	private double subtotalIva;
	private double subtotalConImpuestos;
	
	public LineaPedido(long id, int cantidad, String descripcionProducto, double precioUnitario, double ivaPorcentaje,
			double subtotalSinImpuestos, double subtotalIva, double subtotalConImpuestos) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcionProducto = descripcionProducto;
		this.precioUnitario = precioUnitario;
		this.ivaPorcentaje = ivaPorcentaje;
		this.subtotalSinImpuestos = subtotalSinImpuestos;
		this.subtotalIva = subtotalIva;
		this.subtotalConImpuestos = subtotalConImpuestos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getIvaPorcentaje() {
		return ivaPorcentaje;
	}

	public void setIvaPorcentaje(double ivaPorcentaje) {
		this.ivaPorcentaje = ivaPorcentaje;
	}

	public double getSubtotalSinImpuestos() {
		return subtotalSinImpuestos;
	}

	public void setSubtotalSinImpuestos(double subtotalSinImpuestos) {
		this.subtotalSinImpuestos = subtotalSinImpuestos;
	}

	public double getSubtotalIva() {
		return subtotalIva;
	}

	public void setSubtotalIva(double subtotalIva) {
		this.subtotalIva = subtotalIva;
	}

	public double getSubtotalConImpuestos() {
		return subtotalConImpuestos;
	}

	public void setSubtotalConImpuestos(double subtotalConImpuestos) {
		this.subtotalConImpuestos = subtotalConImpuestos;
	}
	
}
