package com.mikeldi.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikeldi.dam.model.Rol;
import java.util.List;


public interface RolRepository extends JpaRepository<Rol, Long> {
	Rol findById(long id);
}
