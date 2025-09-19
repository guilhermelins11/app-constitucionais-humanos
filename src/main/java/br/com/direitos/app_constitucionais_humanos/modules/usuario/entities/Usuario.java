package br.com.direitos.app_constitucionais_humanos.modules.usuario.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\\\S+\", message = \"O campo não deve conter espaço.")
    private String username;

    @Email(message = "O campo Email deve conter um email válido.")
    private String email;

    @Length(min = 8, max = 20, message = "A senha deve conter entre (8) e (20) caracteres.")
    private String password;
}
