package br.com.direitos.app_constitucionais_humanos.modules.administrador.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.Admin;
import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.usecases.CreateAdminUseCase;
import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private CreateAdminUseCase createAdminUseCase;

    @Autowired
    public AdminController(CreateAdminUseCase createAdminUseCase) {
        this.createAdminUseCase = createAdminUseCase;
    }

    @PostMapping("/")
    public Admin create(@Valid @RequestBody Admin admin) {
        return this.createAdminUseCase.execute(admin);
    }
    
}
