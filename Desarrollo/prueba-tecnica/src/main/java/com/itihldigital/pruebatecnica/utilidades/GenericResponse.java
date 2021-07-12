package com.itihldigital.pruebatecnica.utilidades;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

	private String codigo;
	private String mensaje;
	private List<T> lista;
	private T unitario;

	



}
