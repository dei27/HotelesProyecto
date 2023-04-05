package com.hotelalura.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelalura.core.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByEmail(String email);
}
