package com.imuniza.vacina.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.imuniza.vacina.entidade.Usuario;
import com.imuniza.vacina.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UsuarioRepository repository;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Usuario claudio = new Usuario(null, "Claudio Costa",
		 * "claudio.c.matos@gmail.com", null); Usuario joyce = new Usuario(null,
		 * "Joyce Ribeiro", "joyce.ribeiro@gmail.com", null); Usuario rosangela = new
		 * Usuario(null, "Rosangela Ribeiro", "rosangela.ribeiro@gmail.com", null);
		 * repository.deleteAll(); repository.saveAll(Arrays.asList(joyce, rosangela,
		 * claudio));
		 */
	}

}
