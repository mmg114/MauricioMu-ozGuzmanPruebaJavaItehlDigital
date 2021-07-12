package com.itihldigital.pruebatecnica.pruebasDeIntegracion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itihldigital.pruebatecnica.negocio.ModalidadService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

@RunWith(SpringRunner.class)
@SpringBootTest
class ModalidadTest {

	@Autowired
	ModalidadService modalidadService;

	//@Test
	void existenModalidades() throws Exception {

		List<Modalidad> modalidadesEncontradas = modalidadService.findAll();

		assertNotNull(modalidadesEncontradas);
		assertFalse(modalidadesEncontradas.isEmpty());

	}

	//@Test
	void crearModalidad() throws Exception {

		Modalidad document = Modalidad.builder()
				.descripcion(null)
				.descripcion("Nueva Modalidad")
				.nombre("modalidad virtual 3d")
				.build();

		Modalidad modalidadCreada = modalidadService.save(document);

		assertNotNull(modalidadCreada);
		assertTrue(modalidadCreada.get_id() != null || !modalidadCreada.get_id().trim().equals(""));

	}

}
