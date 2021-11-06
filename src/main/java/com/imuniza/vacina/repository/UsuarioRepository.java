package com.imuniza.vacina.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.imuniza.vacina.entidade.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String>{

}
