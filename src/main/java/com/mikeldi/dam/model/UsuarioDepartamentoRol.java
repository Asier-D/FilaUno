package com.mikeldi.dam.model;

public class UsuarioDepartamentoRol {
	private long id_usuario; //podria ser Usuario usuario
	private long id_rol;
	private long id_departamento;
	
	public UsuarioDepartamentoRol(long id_usuario, long id_rol, long id_departamento) {
		super();
		this.id_usuario = id_usuario;
		this.id_rol = id_rol;
		this.id_departamento = id_departamento;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public long getId_rol() {
		return id_rol;
	}

	public long getId_departamento() {
		return id_departamento;
	}

	
	
	//no se si es necesario el setter
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}

	public void setId_departamento(long id_departamento) {
		this.id_departamento = id_departamento;
	}

}
