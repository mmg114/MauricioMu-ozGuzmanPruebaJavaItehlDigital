package com.itihldigital.pruebatecnica.reporsitorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itihldigital.pruebatecnica.reporsitorio.modelo.Descuento;

@Repository
public interface IDescuentoDao extends MongoRepository<Descuento, String> {

}
