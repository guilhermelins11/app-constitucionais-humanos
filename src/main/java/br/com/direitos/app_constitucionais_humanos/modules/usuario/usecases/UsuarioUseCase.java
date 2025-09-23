package br.com.direitos.app_constitucionais_humanos.modules.usuario.usecases;
import br.com.direitos.app_constitucionais_humanos.modules.usuario.repositories.UsuarioRepository;
<<<<<<< HEAD

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 498460fbff3beec3de3deb4b0040b2032abf19d2
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.direitos.app_constitucionais_humanos.modules.usuario.entities.Usuario;

@Service
public class UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioUseCase (UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    };

    public Usuario execute(Usuario usuario) {
        this.usuarioRepository
        .findByUsernameOrEmail(usuario.getUsername(), usuario.getEmail())
        .ifPresent(user -> {
            throw new UnsupportedOperationException("Metodo não implementado'");

        });
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
