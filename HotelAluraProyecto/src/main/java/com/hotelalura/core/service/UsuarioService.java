package com.hotelalura.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelalura.core.model.Usuario;
import com.hotelalura.core.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public Usuario obtenerUsuarioByEmail(String email){
		return usuarioRepo.findByEmail(email);
	}
	
	public void liberarHabitaciones() {
		usuarioRepo.liberarHabitaciones();
	}
}
