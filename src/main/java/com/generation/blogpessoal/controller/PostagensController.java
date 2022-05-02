package com.generation.blogpessoal.controller;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

import antlr.collections.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagensController {
	@Autowired
 private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<java.util.List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
}
