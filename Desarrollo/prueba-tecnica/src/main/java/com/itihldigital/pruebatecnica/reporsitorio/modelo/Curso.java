package com.itihldigital.pruebatecnica.reporsitorio.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Document(collection = "curso")
public class Curso {

	
	@Id 
	private String _id;
	private String nombre;
	private Double costo;
	private String descripcion;
	private Integer horas;
	private String dirigido;
	private Modalidad modalidad;
	


}
