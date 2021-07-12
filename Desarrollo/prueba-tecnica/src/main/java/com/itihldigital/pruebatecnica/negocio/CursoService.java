package com.itihldigital.pruebatecnica.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.itihldigital.pruebatecnica.reporsitorio.ICursoDao;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Curso;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;

@Scope("singleton")
@Service
public class CursoService implements ICursoService {


	
	@Autowired
	private ICursoDao cursoDao;
	
	public Curso save(Curso curso) throws Exception {
		
		if (curso == null) {
			throw new Exception("El curso a guardar esta vacio");
		}
		
		return cursoDao.save(curso);
	}

	@Override
	public Curso actualizar(Curso curso) throws Exception {
		if (curso == null) {
			throw new Exception("El curso a guardar esta vacio");
		}
		if (curso.get_id()==null || curso.get_id().trim().equals("")) {
			throw new Exception("debe Seleccionar un curso");
		}
		
		return cursoDao.save(curso);
	}

	@Override
	public List<Curso> buscarpormodelo(Modalidad modalidad) throws Exception {
		
		List<Curso> resultado = cursoDao.findByModalidad(modalidad);
		return resultado;
	}

}
