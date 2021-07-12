package com.itihldigital.pruebatecnica.reporsitorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itihldigital.pruebatecnica.reporsitorio.modelo.Curso;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

@Repository
public interface ICursoDao extends MongoRepository<Curso, String> {

	List<Curso> findByModalidad(Modalidad modalidad);
	
	
	
}
