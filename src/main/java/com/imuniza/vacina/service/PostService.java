package com.imuniza.vacina.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imuniza.vacina.entidade.Post;
import com.imuniza.vacina.repository.PostRepository;
import com.imuniza.vacina.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//considere a data 24horas, até 24 do dia.
		maxDate = new Date(maxDate.getTime()+24*60*60*1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
	
	public List<Post> findByTitle(String text) {
		//opção padrão
		//repository.findByTitleContainingIgnoreCase(text)
		return repository.searchTitle(text);
	}

	public Post findById(String id) {
		Post post = repository.findById(id).orElse(new Post());
		if (post.getId() == null) {
			throw new ObjectNotFoundException("Posts não encontrado com esse " + id);
		}
		return post;
	}

}
