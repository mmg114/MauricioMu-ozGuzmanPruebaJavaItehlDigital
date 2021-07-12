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

import com.itihldigital.pruebatecnica.negocio.DescuentoService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Descuento;

@ExtendWith(MockitoExtension.class)
public class DescuentosTest {

	@Mock
	DescuentoService descuentoSeervice;

	
	
	@Test
	public void findByAll() throws Exception {
 
		Descuento document = Descuento.builder()
				._id("0189264709218u312")
				.nombre("Descuento de navidad")
				.build();
		
	
		when(descuentoSeervice.findByAll()).thenReturn(Arrays.asList(document));	
		
		
	
		List<Descuento> descuento = descuentoSeervice.findByAll();
		
		assertNotNull(descuento);
		assertTrue(descuento != null || descuento.isEmpty());
		
	}
	
	@Test
	public void buscarpormodelo() throws Exception {
 
		
		Descuento modalidadRespuesta = null;
		Descuento document = Descuento.builder()
				._id(null)
				.descuento("10%")
				.build();
		
		when(descuentoSeervice.save(any(Descuento.class))).then(new Answer<Descuento>() {
			String sequence = "suoiwehriweuhriwehrhiewuhr";

			@Override
			public Descuento answer(InvocationOnMock invocation) throws Throwable {
				Descuento transaction = invocation.getArgument(0);
				transaction.set_id(sequence);
				return transaction;
			}

		});
		
		modalidadRespuesta = descuentoSeervice.save(document);

		// Assert
		assertNotNull(modalidadRespuesta.get_id());
	}
}
