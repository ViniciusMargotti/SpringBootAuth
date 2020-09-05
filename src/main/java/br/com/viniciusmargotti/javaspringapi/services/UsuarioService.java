package br.com.viniciusmargotti.javaspringapi.services;

import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import br.com.viniciusmargotti.javaspringapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PrePersist
    @PreUpdate
    private void beforeAnyUpdate(Usuario usuario) {
       Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

       if(usuarioExistente != null && usuarioExistente.getId().equals(usuario.getId())){
           new RuntimeException("Já existe um usuário cadastrado para o email " + usuario.getEmail());
       }

       usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
    }
}
