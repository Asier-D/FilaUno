package com.mikeldi.dam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikeldi.dam.model.Usuario;
import com.mikeldi.dam.model.Rol;
import com.mikeldi.dam.model.UsuarioRol;
import com.mikeldi.dam.repository.RolRepository;
import com.mikeldi.dam.repository.UsuarioRepository;
import com.mikeldi.dam.repository.UsuarioRolRepository;

@Service
public class RolService implements IRolService {
	
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioRolRepository usuRolRepository;
	

	@Override
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}
	
	@Override
	public List<UsuarioRol> findByUsuarioId(Long usuarioId) {
        return usuRolRepository.findByIdUsuario(usuarioId);
    }

	@Override
	public UsuarioRol assignRoleToUser(Long usuarioId, Long rolId) {
		Usuario usuario = usuarioRepository.findUsuarioById(usuarioId);
		if (usuario == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		Rol rol = rolRepository.findRolById(rolId);
		if (rol == null) {
			throw new RuntimeException("Rol no encontrado");
		}
		boolean existe = usuRolRepository.existsByUsuarioIdAndRolId(usuarioId, rolId);
		if (existe) {
			new RuntimeException("El usuario ya tiene este rol asignado");
		}
		UsuarioRol usuarioRol = new UsuarioRol();
	    usuarioRol.setIdUsuario(usuario.getId()); //esto se hacer pq, JPA no va a usar los objetos usuario o rol para generar los valores de las columnas. Solo va a usar los long idUsuario y long idRol.
	    usuarioRol.setIdRol(rol.getId());
	    
	    return usuRolRepository.save(usuarioRol);
	}

	@Override
	public void removeRolFromUser(Long usuarioId, Long rolId) {
		UsuarioRol usuarioRol = usuRolRepository.findByIdUsuarioAndIdRol(usuarioId, rolId);
		if (usuarioRol == null) {
			throw new RuntimeException("Relación usuario-rol no encontrada");
		} else {
			usuRolRepository.delete(usuarioRol);
		}

	}

}
