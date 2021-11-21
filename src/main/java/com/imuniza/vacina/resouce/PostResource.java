package com.imuniza.vacina.resouce;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imuniza.vacina.dto.UsuarioDTO;
import com.imuniza.vacina.entidade.Post;
import com.imuniza.vacina.resource.util.URL;
import com.imuniza.vacina.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	@Autowired
	private PostService service;

	@RequestMapping(value="/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll(@RequestParam(value="text", defaultValue="")  String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok().body(posts);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable("id") String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Void>
	 * insert(@RequestBody PostDTO dto) { Post post = postService.fromDTO(dto); post
	 * = postService.insert(post); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (post.getId()).toUri(); return ResponseEntity.created(uri).build(); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<Void> update(@RequestBody PostDTO dto, @PathVariable("id")
	 * String id) { Post post = postService.fromDTO(dto); post.setId(id); post =
	 * postService.update(post); return ResponseEntity.noContent().build(); }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) public
	 * ResponseEntity<Void> delete(@PathVariable("id") String id) {
	 * postService.findById(id); return ResponseEntity.noContent().build(); }
	 * 
	 * @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET) public
	 * ResponseEntity<List<Post>> findPosts(@PathVariable("id") String id) { Post
	 * post = postService.findById(id); return
	 * ResponseEntity.ok().body(post.getPosts()); }
	 */
}
