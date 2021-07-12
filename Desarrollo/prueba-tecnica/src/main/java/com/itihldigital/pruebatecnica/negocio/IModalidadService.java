package com.itihldigital.pruebatecnica.negocio;

import java.util.List;

import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

public interface IModalidadService {

	List<Modalidad> findAll() throws Exception;

	Modalidad save(Modalidad modalidad)throws Exception;

}
