package com.mikeldi.dam.model;

public class Rol {
	private long id;
	private String nombre;
	private String descirpcion;
	
	public Rol() {
		super();
	}

	public Rol(long id, String nombre, String descirpcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descirpcion = descirpcion;
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

	public String getDescirpcion() {
		return descirpcion;
	}

	public void setDescirpcion(String descirpcion) {
		this.descirpcion = descirpcion;
	}
	
	

}
