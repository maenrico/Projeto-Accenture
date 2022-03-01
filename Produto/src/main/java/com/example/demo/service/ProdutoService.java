package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	 @Autowired
	 ProdutoRepository produtorepository;
	 
	 public Produto save(Produto produto) {
	 
	 return produtorepository.save(produto);
	 }
	 
	 public List<Produto> findAll(){
		 return produtorepository.findAll();
	 }
	 public Produto GetById(Long id) {
		 
		 return produtorepository.getById(id);
	 }
	 public void DeleteById(Long id) {
		 
		 produtorepository.deleteById(id);
	 }
}
