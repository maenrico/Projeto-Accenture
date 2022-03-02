package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public Produto save(Produto produto) {

		return produtoRepository.save(produto);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto getById(Long id) {

		return produtoRepository.getById(id);
	}

	public void deleteById(Long id) {

		produtoRepository.deleteById(id);
	}
}
