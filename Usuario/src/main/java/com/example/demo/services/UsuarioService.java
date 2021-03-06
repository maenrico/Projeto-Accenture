package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepositories;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositories usuarioRepository;
	
	public Usuario save(Usuario user) {
		
		return usuarioRepository.save(user);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		
		return usuarioRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		
	  usuarioRepository.deleteById(id);
	}
	
	public Usuario Update(Long id, Usuario user) {
		
		Usuario updateUser = findById(id);
		updateUser.setNome(user.getNome());
		updateUser.setEmail(user.getEmail());
		updateUser.setContato(user.getContato());
		return usuarioRepository.save(updateUser);
		}
}
