package com.itihldigital.pruebatecnica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itihldigital.pruebatecnica.negocio.IModalidadService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;
import com.itihldigital.pruebatecnica.utilidades.Constantes;
import com.itihldigital.pruebatecnica.utilidades.GenericResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,})
@RequestMapping("/modalidad")
@ApiOperation(value="Creacion de nuevo curso", notes="")
@Slf4j
public class ModalidadControlador {

	
	
	
	@Autowired
	private IModalidadService modalidadService;

	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Respuesta Satisfactoria",response = GenericResponse.class),
            @ApiResponse(code = 400, message = "Error en el proceso", response = GenericResponse.class),
            @ApiResponse(code = 500, message = "Internal server error") 
        }
)
	@GetMapping()
	public ResponseEntity<?> consultar() throws Exception {



		GenericResponse<Modalidad> genericResponse = new GenericResponse<Modalidad>();
		try {

		

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setMensaje("Consulta Exitosa exito");
			genericResponse.setLista( modalidadService.findAll());

		} catch (Exception e) {

			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());


		}
		return ResponseEntity.ok().body(genericResponse);
	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@Validated @RequestBody Modalidad modalidad) throws Exception {
		log.debug("Creando Modalidad: {}", modalidad);

		Modalidad modalidadRespusta = null;

		GenericResponse<Modalidad> genericResponse = new GenericResponse<Modalidad>();
		try {

			modalidadRespusta = modalidadService.save(modalidad);

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setMensaje("Creado Con exito");
			genericResponse.setUnitario(modalidadRespusta);
			log.debug("finalizo  la Creando Modalidad: {}", modalidadRespusta);

		} catch (Exception e) {

			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());
			log.debug("Error en la Creando Modalidad: {}", modalidad);

		}
		return ResponseEntity.ok().body(genericResponse);
	}
}
