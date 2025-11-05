package com.mikeldi.dam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario_rol")
public class UsuarioRol {
	@Id
	private long id_usuario; //podria ser Usuario usuario
	@Id
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
