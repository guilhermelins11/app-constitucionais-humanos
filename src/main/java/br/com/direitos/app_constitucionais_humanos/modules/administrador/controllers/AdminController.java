package br.com.direitos.app_constitucionais_humanos.modules.administrador.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.Admin;
import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.usecases.CreateAdminUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5500")
public class AdminController {

    private CreateAdminUseCase createAdminUseCase;

    public AdminController(CreateAdminUseCase createAdminUseCase) {
        this.createAdminUseCase = createAdminUseCase;
    }

    @PostMapping("/")
    public Admin create(@Valid @RequestBody Admin admin) {
        return this.createAdminUseCase.execute(admin);
    }
    
}
