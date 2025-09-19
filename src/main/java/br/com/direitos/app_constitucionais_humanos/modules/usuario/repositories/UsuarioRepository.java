package br.com.direitos.app_constitucionais_humanos.modules.usuario.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.direitos.app_constitucionais_humanos.modules.usuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsernameOrEmail(String username, String email);
    
} 