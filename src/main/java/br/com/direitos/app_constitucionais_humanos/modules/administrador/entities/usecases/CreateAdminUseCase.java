package br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.direitos.app_constitucionais_humanos.exceptions.UserFoundException;
import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.Admin;
import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.repositories.AdminRepository;

@Service
public class CreateAdminUseCase {

    @Autowired
    private final AdminRepository adminRepository;

    public CreateAdminUseCase(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin execute(Admin admin) {
        this.adminRepository.findByUsername(admin.getUsername())
            .ifPresent((existingAdmin) -> {
                throw new UserFoundException();
            });

        return this.adminRepository.save(admin);
    }
}