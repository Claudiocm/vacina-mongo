package com.imuniza.vacina.service;

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

	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}

	public Post findById(String id) {
		Post post = repository.findById(id).orElse(new Post());
		if (post.getId() == null) {
			throw new ObjectNotFoundException("Posts não encontrado com esse " + id);
		}
		return post;
	}

	/*
	 * public Post update(Post post) { Post usu =
	 * repository.findById(post.getId()).get(); atualizaPost(usu, post); return
	 * repository.save(usu); }
	 */
	
	/*
	 * private void atualizaPost(Post usu, Post post) { usu.setNome(post.get);
	 * usu.setLogin(post.getLogin()); }
	 */

	public Post insert(Post post) {
		return repository.insert(post);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	/*
	 * public Post fromDTO(PostDTO dto) { return new Post(dto.getId(),
	 * dto.getNome(), dto.getLogin()); }
	 */
}
