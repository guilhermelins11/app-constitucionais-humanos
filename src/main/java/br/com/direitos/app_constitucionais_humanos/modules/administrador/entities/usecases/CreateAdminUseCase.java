package br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.usecases;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.direitos.app_constitucionais_humanos.exceptions.UserFoundException;
import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.Admin;
import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.repositories.AdminRepository;

@Service
public class CreateAdminUseCase {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateAdminUseCase(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin execute(Admin admin) {
        this.adminRepository.findByUsername(admin.getUsername())
            .ifPresent((existingAdmin) -> {
                throw new UserFoundException();
            });

            var passwordHash = this.passwordEncoder.encode(admin.getPassword());
            admin.setPassword(passwordHash);

        return this.adminRepository.save(admin);
    }
}