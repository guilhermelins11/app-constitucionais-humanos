package br.com.direitos.app_constitucionais_humanos.modules.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.direitos.app_constitucionais_humanos.modules.usuario.entities.Usuario;
import br.com.direitos.app_constitucionais_humanos.modules.usuario.usecases.UsuarioUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/usuario")
@PreAuthorize("hasAnyRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @GetMapping("/")
    public List<Usuario> listarTodosOsUsuarios() {
        return this.usuarioUseCase.findAll(); 
    }

    @PostMapping("/")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioUseCase.execute(usuario);
    }
    
    
}
