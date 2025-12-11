package com.mikeldi.dam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mikeldi.dam.model.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRol.UsuarioRolId> {
    List<UsuarioRol> findByIdUsuario(long idUsuario);
    boolean existsByUsuarioIdAndRolId(Long usuarioId, Long rolId);
    UsuarioRol findByIdUsuarioAndIdRol(Long usuarioId, Long rolId);
    List<UsuarioRol> findAll();
    
}