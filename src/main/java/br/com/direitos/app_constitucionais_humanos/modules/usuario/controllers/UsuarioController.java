package br.com.direitos.app_constitucionais_humanos.modules.usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.direitos.app_constitucionais_humanos.modules.usuario.entities.Usuario;
import br.com.direitos.app_constitucionais_humanos.modules.usuario.usecases.UsuarioUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Usuario usuario) {
        try {
            var result = this.usuarioUseCase.execute(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
