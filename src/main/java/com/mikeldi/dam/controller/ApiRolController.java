package com.mikeldi.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikeldi.dam.model.Rol;
import com.mikeldi.dam.model.UsuarioRol;
import com.mikeldi.dam.service.RolService;

@RestController
@RequestMapping("/api")
public class ApiRolController {
	
	@Autowired
    private RolService rolService;
    
    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }
    
    @GetMapping("/usuarios/{usuarioId}/roles")
    public ResponseEntity<List<UsuarioRol>> getUserRoles(@PathVariable Long usuarioId) {
        List<UsuarioRol> roles = rolService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(roles);
    }
    
    @PostMapping("/usuarios/{usuarioId}/roles")
    public ResponseEntity<?> addRoleToUser(
            @PathVariable Long usuarioId,
            @RequestBody RolRequest request) {
        try {
            UsuarioRol usuarioRol = rolService.assignRoleToUser(usuarioId, request.getRolId());
            return ResponseEntity.ok(usuarioRol);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage()));
        }
    }
    
    @DeleteMapping("/usuarios/{usuarioId}/roles/{rolId}")
    public ResponseEntity<?> removeRoleFromUser(
            @PathVariable Long usuarioId,
            @PathVariable Long rolId) {
        try {
            rolService.removeRolFromUser(usuarioId, rolId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage()));
        }
    }
}

class RolRequest {
    private Long rolId;
    
    public Long getRolId() {
        return rolId;
    }
    
    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }
}

class ErrorResponse {
    private String message;
    
    public ErrorResponse(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
	
	


