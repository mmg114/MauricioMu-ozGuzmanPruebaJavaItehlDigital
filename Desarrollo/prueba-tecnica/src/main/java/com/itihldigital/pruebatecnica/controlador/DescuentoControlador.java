package com.itihldigital.pruebatecnica.controlador;

import java.util.List;

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

import com.itihldigital.pruebatecnica.negocio.IDescuentoService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Descuento;
import com.itihldigital.pruebatecnica.utilidades.Constantes;
import com.itihldigital.pruebatecnica.utilidades.GenericResponse;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/descuento")
public class DescuentoControlador {

	@Autowired
	private IDescuentoService descuentosServices;
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveDescuento(@Validated @RequestBody Descuento descuento) throws Exception {


		Descuento descuentoRespuesta = null;

		GenericResponse<Descuento> genericResponse = new GenericResponse<Descuento>();
		try {

			descuentoRespuesta = descuentosServices.save(descuento);

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setUnitario(descuentoRespuesta);

		} catch (Exception e) {
			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());
		}
		return ResponseEntity.ok().body(genericResponse);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByAll() throws Exception {


		List<Descuento> descuentoRespuesta = null;

		GenericResponse<Descuento> genericResponse = new GenericResponse<Descuento>();
		try {

			descuentoRespuesta = descuentosServices.findByAll();

			genericResponse.setCodigo(Constantes.HTTP_OK);
			genericResponse.setLista(descuentoRespuesta);
		
		} catch (Exception e) {
			genericResponse.setCodigo(Constantes.HTTP_BAD_REQUEST);
			genericResponse.setMensaje(e.getMessage());
		}
		return ResponseEntity.ok().body(genericResponse);
	}
	
	
	
	
}
