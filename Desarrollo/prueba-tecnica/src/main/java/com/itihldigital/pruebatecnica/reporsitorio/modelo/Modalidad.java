package com.itihldigital.pruebatecnica.reporsitorio.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Document(collection = "modalidad")
public class Modalidad {

	@Id
	private String _id;
	private String nombre;
	private String descripcion;
	
	
	
}
