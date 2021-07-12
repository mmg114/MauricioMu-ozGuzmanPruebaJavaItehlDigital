package com.itihldigital.pruebatecnica.negocio;

import java.util.List;

import com.itihldigital.pruebatecnica.reporsitorio.modelo.Curso;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

public interface ICursoService  {

	Curso save(Curso curso) throws Exception;

	Curso actualizar(Curso curso) throws Exception;

	List<Curso> buscarpormodelo(Modalidad modelo) throws Exception;


}
