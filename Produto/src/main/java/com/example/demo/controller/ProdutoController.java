package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produto;
import com.example.demo.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> GetAll(){
		
		return produtoService.findAll();
	}
	@PostMapping
	public Produto saveproduto(@RequestBody Produto produto) {
	
	return produtoService.save(produto);
	}
	@GetMapping("/{id}")
	public Produto GetprodutoById(@PathVariable Long id) {
		
		return produtoService.GetById(id);
	}
	@GetMapping("/{id}")
	public void deleteprodutoById(@PathVariable Long id) {

		produtoService.DeleteById(id);
	}
}
