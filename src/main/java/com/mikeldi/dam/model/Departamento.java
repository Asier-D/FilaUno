package com.mikeldi.dam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	private long id;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private boolean activo;
	
	public Departamento() {
		super();
	}

	public Departamento(long id, String nombre, String descripcion, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
