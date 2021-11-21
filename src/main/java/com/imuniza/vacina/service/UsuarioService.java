package com.imuniza.vacina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imuniza.vacina.dto.UsuarioDTO;
import com.imuniza.vacina.entidade.Usuario;
import com.imuniza.vacina.repository.UsuarioRepository;
import com.imuniza.vacina.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(String id) {
		Usuario usuario = repository.findById(id).orElse(new Usuario());
		if (usuario.getId() == null) {
			throw new ObjectNotFoundException("Usuário não encontrado com esse " + id);
		}
		return usuario;
	}

	public Usuario update(Usuario usuario) {
		Usuario usu = repository.findById(usuario.getId()).get();
		atualizaUsuario(usu, usuario);
		return repository.save(usu);
	}
	
	private void atualizaUsuario(Usuario usu, Usuario usuario) {
		usu.setNome(usuario.getNome());
		usu.setLogin(usuario.getLogin());		
	}

	public Usuario insert(Usuario usuario) {
		return repository.insert(usuario);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Usuario fromDTO(UsuarioDTO dto) {
		return new Usuario(dto.getId(), dto.getNome(), dto.getLogin());
	}
}
