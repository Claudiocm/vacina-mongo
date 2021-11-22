package com.imuniza.vacina.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.imuniza.vacina.entidade.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	// O Containing busca o conteudo text, o IgnoreCase busca Maiscula ou minuscula
	List<Post> findByTitleContainingIgnoreCase(String text);

	//utiliza EL[regex], i usado para Case Sensitive
	@Query("{'title':{$regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	@Query("{$and: [{date: {$gte: ?1}},{date:{$lte: ?2}},"
			+ "{$or:[{'title':{$regex: ?0, $options: 'i'}},"
			+ "{'body':{$regex: ?0, $options: 'i'}},"
			+ "{'comments.text':{$regex: ?0, $options: 'i'}}]}"
			+ "]}")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
