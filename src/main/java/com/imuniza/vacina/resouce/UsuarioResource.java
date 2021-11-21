package com.imuniza.vacina.resouce;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imuniza.vacina.dto.UsuarioDTO;
import com.imuniza.vacina.entidade.Usuario;
import com.imuniza.vacina.service.UsuarioService;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> usuarios = usuarioService.findAll();
		List<UsuarioDTO> listaDTO = usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") String id) {
		Usuario usu = usuarioService.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usu));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO dto) {
		Usuario usu = usuarioService.fromDTO(dto);
		usu = usuarioService.insert(usu);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UsuarioDTO dto, @PathVariable("id") String id) {
		Usuario usu = usuarioService.fromDTO(dto);
		usu.setId(id);
		usu = usuarioService.update(usu);
	    return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		usuarioService.findById(id);
		return ResponseEntity.noContent().build();
	}
}
