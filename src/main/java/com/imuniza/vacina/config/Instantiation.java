package com.imuniza.vacina.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.imuniza.vacina.entidade.Post;
import com.imuniza.vacina.entidade.Usuario;
import com.imuniza.vacina.repository.PostRepository;
import com.imuniza.vacina.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		repository.deleteAll();
		postRepository.deleteAll();
		
		Usuario claudio = new Usuario(null, "Claudio Costa", "claudio.c.matos@gmail.com", null);
		Usuario joyce = new Usuario(null, "Joyce Ribeiro", "joyce.ribeiro@gmail.com", null);
		Usuario rosangela = new Usuario(null, "Rosangela Ribeiro", "rosangela.ribeiro@gmail.com", null);
	
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajars para São Paulo, abraços",
				claudio);
		Post post2 = new Post(null, sdf.parse("22/03/2018"), "Praia ", "E ai galera, bora pra praia", joyce);
		
		repository.saveAll(Arrays.asList(claudio, joyce, rosangela));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
