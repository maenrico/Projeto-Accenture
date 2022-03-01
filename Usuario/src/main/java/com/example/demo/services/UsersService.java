package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepositories;

@Service
public class UsersService {
	
	@Autowired
	UsersRepositories usuarioRepository;
	
	public Users save(Users user) {
		
		return usuarioRepository.save(user);
	}

	public List<Users> findAll() {
		return usuarioRepository.findAll();
	}

	public Users findById(Long id) {
		
		return usuarioRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		
	  usuarioRepository.deleteById(id);
	}
	
	public Users Update(Long id, Users user) {
		
		Users updateuser = findById(id);
		updateuser.setName(user.getName());
		updateuser.setEmail(user.getEmail());
		updateuser.setContato(user.getContato());
		return usuarioRepository.save(updateuser);
		}
}
