package br.com.direitos.app_constitucionais_humanos.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.direitos.app_constitucionais_humanos.modules.administrador.entities.repositories.AdminRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public JpaUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.adminRepository.findByUsername(username)
        .map(admin ->
            User.builder()
            .username(admin.getUsername())
            .password(admin.getPassword())
            .roles("ADMIN")
            .build()
            )
            .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado: " + username));
    }
}
