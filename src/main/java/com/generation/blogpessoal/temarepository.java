package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Tema;

import antlr.collections.List;

@Repository
public interface temarepository extends JpaRepository<Tema, Long> {
 public List<Tema> findllByDescricaoContainingIgnoreCase(String descricao);
 
}
