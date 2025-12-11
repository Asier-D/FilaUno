package com.mikeldi.dam.service;

import com.mikeldi.dam.model.Rol;
import com.mikeldi.dam.model.UsuarioRol;

import java.util.List; 

public interface IRolService {
	public List<Rol> findAll();
	public List<UsuarioRol> findByUsuarioId(Long usuarioId);
	public UsuarioRol assignRoleToUser(Long usuarioId, Long rolId);
	public void removeRolFromUser(Long usuarioId, Long rolId);
}
