package com.imuniza.vacina;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.imuniza.vacina.entidade.Usuario;

class VacinaApplicationTests {
    Usuario usuario;
    
	public void inicia() {
		usuario = new Usuario(null,"nome", "claudio@saovicente.sp", "senha");
		//Usuario u = new Usuario(null, null, null);
		usuario.setNome(usuario.getNome());
		usuario.setLogin(usuario.getLogin());
		usuario.setSenha(usuario.getSenha());
		
	}
	
	@Test
	void buscaUsuario() {
		inicia();
		System.out.println("Nome: "+usuario.getNome());		
		System.out.println("Login: "+usuario.getLogin());
		System.out.println("Senha: "+usuario.getSenha());
	}

}
