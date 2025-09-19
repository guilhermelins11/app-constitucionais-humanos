package br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Optional<Admin>findByUsername(String username);

    Optional<Admin>findByUsernameAndId(String username, UUID id);
}
