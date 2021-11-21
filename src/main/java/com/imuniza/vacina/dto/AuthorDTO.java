package com.imuniza.vacina.dto;

import java.io.Serializable;

import com.imuniza.vacina.entidade.Usuario;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(Usuario usuario) {
		id = usuario.getId();
		name = usuario.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
