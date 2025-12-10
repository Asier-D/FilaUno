package com.mikeldi.dam.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.component.PeliculaComp;
import com.example.demo.models.entity.Pelicula;
import com.mikeldi.dam.model.Rol;
import com.mikeldi.dam.model.Usuario;
import com.mikeldi.dam.model.UsuarioRol;
import com.mikeldi.dam.repository.RolRepository;
import com.mikeldi.dam.repository.UsuarioRepository;
import com.mikeldi.dam.repository.UsuarioRolRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    //kerman
    @Autowired
    private UsuarioRolRepository usuariorolRepository;
    @Autowired
    private RolRepository rolRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email, 
                                @RequestParam String password, 
                                HttpSession session, 
                                Model model) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && passwordEncoder.matches(password, usuario.getPasswordHash())) {
        	//cambios hecho por Kerman
        	List<UsuarioRol> listaRol = usuariorolRepository.findByIdUsuario(usuario.getId());
        	if (!listaRol.isEmpty()) {
				for (UsuarioRol usuarioRol : listaRol) {
					Rol rolVer = rolRepository.findById(usuarioRol.getIdRol());
					if (rolVer.getNombre().equals("Administrador")) {
						session.setAttribute("usuario", usuario);
						return "redirect:/administrador";
					}
				}
			}
            session.setAttribute("usuario", usuario);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@RequestParam String nombre,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   Model model) {
        if (usuarioRepository.findByEmail(email) != null) {
            model.addAttribute("error", "El email ya está registrado");
            return "register";
        }
        Usuario nuevo = new Usuario();
        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setPasswordHash(passwordEncoder.encode(password));
        nuevo.setActivo(true);
        usuarioRepository.save(nuevo);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String mostrarHome(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) return "redirect:/login";
        model.addAttribute("usuario", usuario);
        return "home";
    }
    @GetMapping("/administrador")
    public String mostrarAdministrador(HttpSession session, Model model) {
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) return "redirect:/login";
        
        // Enviar todos los usuarios
        List<Usuario> todosUsuarios = usuarioRepository.findAll();
        
        // Enviar todos los UsuarioRol para poder buscar los roles
        List<UsuarioRol> listaUR = usuariorolRepository.findAll();
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuariosLista", todosUsuarios);
        model.addAttribute("usuarioRoles", listaUR);
        
        return "administrador";
    }
    
    
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String verPelisUsuario(@RequestParam("usuarioID") String usuID, Model model) {
        // Aquí recibes el imdbID y puedes buscar la película
    	Long id = Long.valueOf(usuID);
        Optional<Usuario> user = usuarioRepository.findById(id);
        model.addAttribute("usuario", user);
        
        return "usuario";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    
    
}

