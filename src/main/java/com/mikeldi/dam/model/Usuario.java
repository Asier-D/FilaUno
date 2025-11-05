package com.mikeldi.dam.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	private long id;
	@Column
	private String nombre;
	@Column
	private String email;
	@Column
	private String passwordHash;
	@Column
	private boolean activo;
	@Column
	private LocalDateTime fechaAlta;
	
	public Usuario() {
		super();
	}

	public Usuario(long id, String nombre, String email, String passwordHash, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = passwordHash;
		this.activo = activo;
	}

	public Usuario(long id, String nombre, String email, String passwordHash, boolean activo, LocalDateTime fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.passwordHash = passwordHash;
		this.activo = activo;
		this.fechaAlta = fechaAlta;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	

}
