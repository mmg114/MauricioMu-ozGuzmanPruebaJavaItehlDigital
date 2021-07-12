package com.itihldigital.pruebatecnica.reporsitorio.modelo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Document(collection = "descuento")
public class Descuento {

	@Id
	private String _id;
	private String nombre; 
	private Modalidad modalidad;
	private String pais; 
	private String descuento;
	private Curso curso;
	private LocalDate fechaInicial;

	
	
}
