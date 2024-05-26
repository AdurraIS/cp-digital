package com.ibooking.systemapp.repository;

import com.ibooking.systemapp.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
