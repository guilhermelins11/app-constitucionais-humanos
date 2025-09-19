package br.com.direitos.app_constitucionais_humanos.modules.administrador.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "admin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome de usuario é obrigatorio")
    private String username;
    
    @NotBlank(message = "Essa senha é obrigatoria")
    private String password;    

}
