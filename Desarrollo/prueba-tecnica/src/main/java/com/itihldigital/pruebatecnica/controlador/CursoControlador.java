package com.itihldigital.pruebatecnica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itihldigital.pruebatecnica.negocio.ICursoService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Curso;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;
import com.itihldigital.pruebatecnica.utilidades.Constantes;
import com.itihldigital.pruebatecnica.utilidades.GenericResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET })
@RequestMapping("/curso")
@Slf4j
@ApiOperation(value = "Creacion de nuevo curso", notes = "")
public class CursoControlador {

	@Autowired
	private ICursoService cursoService;

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Respuesta Satisfactoria", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Error en el proceso", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@Validated @RequestBody Curso curso) throws Exception {
		log.debug("Creando Curso: {}", curso);

		Curso cursoRespusta = null;

		GenericResponse<Curso> genericResponse = new GenericResponse<Curso>();
		try {

			cursoRespusta = cursoService.save(curso);

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setMensaje("Creado Con exito");
			genericResponse.setUnitario(cursoRespusta);
			log.debug("finalizo  la Creando Curso: {}", curso);

		} catch (Exception e) {

			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());
			log.debug("Error en la Creando Curso: {}", curso);

		}
		return ResponseEntity.ok().body(genericResponse);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Respuesta Satisfactoria", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Error en el proceso", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizar(@Validated @RequestBody Curso curso) throws Exception {
		log.debug("Actualiando Curso: {}", curso);

		Curso cursoRespusta = null;

		GenericResponse<Curso> genericResponse = new GenericResponse<Curso>();
		try {

			cursoRespusta = cursoService.actualizar(curso);

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setMensaje("Creado Con exito");
			genericResponse.setUnitario(cursoRespusta);
			log.debug("finalizo  la Actualiando Curso: {}", curso);

		} catch (Exception e) {
			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());
			log.debug("Error en la Actualiando Curso: {}", curso);
		}
		return ResponseEntity.ok().body(genericResponse);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Respuesta Satisfactoria", response = GenericResponse.class),
			@ApiResponse(code = 400, message = "Error en el proceso", response = GenericResponse.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(path = ("/buscarpormodelo"), produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarpormodelo(@Validated @RequestBody Modalidad modalidad) throws Exception {
		log.debug("Actualiando Curso: {}", modalidad);

		List<Curso> cursoRespusta = null;

		GenericResponse<Curso> genericResponse = new GenericResponse<Curso>();
		try {

			cursoRespusta = cursoService.buscarpormodelo(modalidad);

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setLista(cursoRespusta);
			log.debug("finalizo  la Actualiando Curso: {}", modalidad);

		} catch (Exception e) {
			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());
			log.debug("Error en la Actualiando Curso: {}", modalidad);
		}
		return ResponseEntity.ok().body(genericResponse);
	}

}
