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
    
    // Esta parte para que pueda acceder a los usuarios solo teniendo los ids en el html
    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "idRol", insertable = false, updatable = false)
    private Rol rol;
    
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
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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