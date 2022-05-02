package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoal.model.Postagem;

@ReadingConverter
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
 public List<Postagem> findAllByTituloContainingIgnoreCase( String titulo);
}
