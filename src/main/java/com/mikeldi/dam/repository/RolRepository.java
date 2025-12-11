package com.mikeldi.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikeldi.dam.model.Rol;
import java.util.List;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	Rol findRolById(long id);
	List<Rol> findAll();
		
}
