package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public List<Produto> getAll() {

		return produtoService.findAll();
	}

	@PostMapping
	public Produto saveProduto(@RequestBody Produto produto) {

		return produtoService.save(produto);
	}

	@GetMapping(value = "{id}")
	public Produto getProdutoById(@PathVariable Long id) {

		return produtoService.getById(id);
	}

	@DeleteMapping(value = "{id}")
	public void deleteProdutoById(@PathVariable Long id) {

		produtoService.deleteById(id);
	}
}
