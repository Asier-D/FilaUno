package com.mikeldi.dam.model;

public class UsuarioRol {
	private long id_usuario; //podria ser Usuario usuario
	private long id_rol;
	
	public UsuarioRol(long id_usuario, long id_rol) {
		super();
		this.id_usuario = id_usuario;
		this.id_rol = id_rol;
	}

	public long getId_usuario() {
		return id_usuario;
	}
	
	//no se si el set es necesario
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public long getId_rol() {
		return id_rol;
	}
	
	//no se si el set es necesario
	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}
	
	
}
