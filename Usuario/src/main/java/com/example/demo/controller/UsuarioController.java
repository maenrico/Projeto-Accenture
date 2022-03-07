package com.example.demo.controller;

import java.util.List;

import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> getAll(){
		
		return usuarioService.findAll();
	}
	@PostMapping
	public Usuario postUser(@RequestBody Usuario user) {
		
		return usuarioService.save(user);
	}
	@GetMapping("/{id}")
	public Usuario getUserById(@PathVariable Long id) {

		return usuarioService.findById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		
		usuarioService.deleteById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable("id") long id, @RequestBody Usuario user) {
	  Usuario updateUser = usuarioService.Update(id,user);
	  return ResponseEntity.ok().body(updateUser);
	}
}
