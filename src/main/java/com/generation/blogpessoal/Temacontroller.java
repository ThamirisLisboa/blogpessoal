package com.generation.blogpessoal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.repository.temarepository;

import antlr.collections.List;
import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*") )
public class Temacontroller {
	
     @Autowired
	private temarepository repository;

	public temarepository getRepository() {
		return repository;
	}

	public void setRepository(temarepository repository) {
		this.repository = repository;
	}

     @GetMapping
    public<List<Tema>> getAll() {
     return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
     }
     @GetMapping ("/{id}")
     public ResponseEntity<Tema> getById(@PathVariable long id){
    	  return repository.findBy(id).map (resp -> ResponseEntity.ok(resp)); 
             .OrElse(ResponseEntity.notFound().build());
    }
     @GetMapping("/nome/{nome}")
     public ResponseEntity<List<Tema>> GetByName(@PathVariable String nome){
    	   return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
     }
     @PostMappin
     public ResponseEntity<Tema> post (@RequestBody Tema tema) {
    	 return ResponseEntity.status(HttpStatus.CREATED)
    			 .body(repository.save(tema));
    	 

     }
     @PutMapping
     public ResponseEntity<Tema> put (@RequestBody Tema tema) {
    	 return ResponseEntity.ok(repository.save(tema));
    			 .body(repository.save(tema));
    	 
  }
     @DeleteMapping("/{id}")
     public void delete(@PathVariable long id) {
    	 repository.deleteBy(id);
     }
} 