package com.itihldigital.pruebatecnica.pruebasDeUnidad;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.itihldigital.pruebatecnica.negocio.ModalidadService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

@ExtendWith(MockitoExtension.class)
public class ModalidadTest {

	@Mock
	ModalidadService modalidadServices ;

	
	
	@Test
	public void consultarModalidad() throws Exception {
 
		Modalidad document = Modalidad.builder()
				.descripcion(null)
				.descripcion("Nueva Modalidad")
				.nombre("modalidad virtual 3d")
				.build();
		
	
		when(modalidadServices.findAll()).thenReturn(Arrays.asList(document));	
		
		
	
		List<Modalidad> modalidadMock = modalidadServices.findAll();
		
		assertNotNull(modalidadMock);
		assertTrue(modalidadMock != null || modalidadMock.isEmpty());
		
	}
	
	@Test
	public void saveModalidad() throws Exception {
 
		
		Modalidad modalidadRespuesta = null;
		Modalidad document = Modalidad.builder()
				.descripcion(null)
				.descripcion("Nueva Modalidad")
				.nombre("modalidad virtual 3d")
				.build();
		
		when(modalidadServices.save(any(Modalidad.class))).then(new Answer<Modalidad>() {
			String sequence = "suoiwehriweuhriwehrhiewuhr";

			@Override
			public Modalidad answer(InvocationOnMock invocation) throws Throwable {
				Modalidad transaction = invocation.getArgument(0);
				transaction.set_id(sequence);
				return transaction;
			}

		});
		
		modalidadRespuesta = modalidadServices.save(document);

		// Assert
		assertNotNull(modalidadRespuesta.get_id());
	}
}
