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

import com.itihldigital.pruebatecnica.negocio.CursoService;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Curso;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

@ExtendWith(MockitoExtension.class)
public class CursoTest {

	@Mock
	CursoService cursoServices ;

	
	
	@Test
	public void buscarPorModalidad() throws Exception {
 
		Modalidad document = Modalidad.builder()
				.descripcion(null)
				.descripcion("Nueva Modalidad")
				.nombre("modalidad virtual 3d")
				.build();
		
		
		Curso curso = Curso.builder()
				._id("14123123123213123123213")
				.costo(null)
				.descripcion(null)
				.dirigido(null)
				.horas(null)
				.modalidad(document)
				.build();
	
		when(cursoServices.buscarpormodelo(document)).thenReturn(Arrays.asList(curso));	
		
		
	
		List<Curso> listaCurso = cursoServices.buscarpormodelo(document);
		
		assertNotNull(listaCurso);
		assertTrue(listaCurso != null || listaCurso.isEmpty());
		
	}
	
	@Test
	public void saveCurso() throws Exception {
 
		
		Curso modalidadRespuesta = null;

		Modalidad document = Modalidad.builder()
				.descripcion(null)
				.descripcion("Nueva Modalidad")
				.nombre("modalidad virtual 3d")
				.build();
		
		
		Curso curso = Curso.builder()
				._id("14123123123213123123213")
				.costo(null)
				.descripcion(null)
				.dirigido(null)
				.horas(null)
				.modalidad(document)
				.build();
		
		when(cursoServices.save(any(Curso.class))).then(new Answer<Curso>() {
			String sequence = "suoiwehriweuhriwehrhiewuhr";

			@Override
			public Curso answer(InvocationOnMock invocation) throws Throwable {
				Curso curso = invocation.getArgument(0);
				curso.set_id(sequence);
				return curso;
			}

		});
		
		modalidadRespuesta = cursoServices.save(curso);

		// Assert
		assertNotNull(modalidadRespuesta.get_id());
	}
	
	@Test
	public void updateCurso() throws Exception {
 
		
		Curso modalidadRespuesta = null;

		Modalidad document = Modalidad.builder()
				.descripcion(null)
				.descripcion("Nueva Modalidad")
				.nombre("modalidad virtual 3d")
				.build();
		
		
		Curso curso = Curso.builder()
				._id("14123123123213123123213")
				.costo(null)
				.descripcion("Descripcion")
				.dirigido(null)
				.horas(null)
				.modalidad(document)
				.build();
		
		when(cursoServices.save(any(Curso.class))).then(new Answer<Curso>() {
			String sequence = "suoiwehriweuhriwehrhiewuhr";

			@Override
			public Curso answer(InvocationOnMock invocation) throws Throwable {
				Curso curso = invocation.getArgument(0);
				curso.set_id(sequence);
				return curso;
			}

		});
		
		modalidadRespuesta = cursoServices.save(curso);

		// Assert
		assertNotNull(modalidadRespuesta.get_id());
	}


}
