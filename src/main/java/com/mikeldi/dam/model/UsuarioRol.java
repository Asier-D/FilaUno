package com.mikeldi.dam.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="usuario_rol")
@IdClass(UsuarioRol.UsuarioRolId.class)
public class UsuarioRol {
    @Id
    private long idUsuario;
    
    @Id
    private long idRol;
    
    public UsuarioRol() {}
    
    public UsuarioRol(long idUsuario, long idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    // Getters y setters
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    // Clase interna para la clave compuesta, si no, no se puede hacer bien al tener 2 ids
    public static class UsuarioRolId implements Serializable {
        private long idUsuario;
        private long idRol;

        public UsuarioRolId() {}

        public UsuarioRolId(long idUsuario, long idRol) {
            this.idUsuario = idUsuario;
            this.idRol = idRol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UsuarioRolId that = (UsuarioRolId) o;
            return idUsuario == that.idUsuario && idRol == that.idRol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idUsuario, idRol);
        }
    }
}