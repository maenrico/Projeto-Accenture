package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

	@Autowired
	private UsersService usuarioService;
	
	@GetMapping
	public List<Users> GetAll(){
		
		return usuarioService.findAll();
	}
	@PostMapping
	public Users Postuser(@RequestBody Users user) {
		
		return usuarioService.save(user);
	}
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable Long id) {

		return usuarioService.findById(id);
	}
	@DeleteMapping("/{id}")
	public void DeleteUserById(@PathVariable Long id) {
		
		usuarioService.deleteById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Users> update(@PathVariable("id") long id,
	                                      @RequestBody Users user) {
	  Users updateuser = usuarioService.Update(id,user);
	  return ResponseEntity.ok().body(updateuser);
	}
}
