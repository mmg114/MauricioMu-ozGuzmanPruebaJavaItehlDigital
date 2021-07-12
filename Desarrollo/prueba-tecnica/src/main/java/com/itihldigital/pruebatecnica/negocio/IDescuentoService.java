package com.itihldigital.pruebatecnica.negocio;

import java.util.List;

import com.itihldigital.pruebatecnica.reporsitorio.modelo.Descuento;

public interface IDescuentoService  {

	Descuento save(Descuento descuento) throws Exception;

	List<Descuento> findByAll() throws Exception;


}
