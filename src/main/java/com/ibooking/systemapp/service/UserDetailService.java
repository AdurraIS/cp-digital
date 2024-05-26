package com.ibooking.systemapp.service;

import com.ibooking.systemapp.model.entities.Usuario;
import com.ibooking.systemapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails carregarDetalhesPorNomeDeUsuario(String userName) {
        Usuario usuario = userRepository.findByUsername(userName)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario nao encontrado: +" + userName));

        return new User(usuario.getUsername(),usuario.getPassword(),new ArrayList<>());
    }

}
