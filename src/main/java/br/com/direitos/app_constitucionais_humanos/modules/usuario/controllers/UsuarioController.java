package br.com.direitos.app_constitucionais_humanos.modules.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.direitos.app_constitucionais_humanos.modules.usuario.entities.Usuario;
import br.com.direitos.app_constitucionais_humanos.modules.usuario.usecases.UsuarioUseCase;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:5500")
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
