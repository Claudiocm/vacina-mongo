package com.imuniza.vacina.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.imuniza.vacina.entidade.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    //O Containing busca o conteudo text, o IgnoreCase busca Maiscula ou minuscula
	List<Post> findByTitleContainingIgnoreCase(String text);
}
