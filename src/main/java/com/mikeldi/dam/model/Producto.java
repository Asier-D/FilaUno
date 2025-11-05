package com.mikeldi.dam.model;

public class Producto {

	private long id;
	private String nombre;
	private String sku;
	private String descripcion;
	private double precioUnitario;
	private double ivaPorcentaje;
	private int stockActual;
	private int stockMinimo;

	public Producto(long id, String nombre, String sku, String descripcion, double precioUnitario, double ivaPorcentaje,
			int stockActual, int stockMinimo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sku = sku;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.ivaPorcentaje = ivaPorcentaje;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	
}
