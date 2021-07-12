package com.itihldigital.pruebatecnica.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.itihldigital.pruebatecnica.reporsitorio.IModalidadDao;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Modalidad;


@Service
@Scope("singleton")
public class ModalidadService implements IModalidadService {

	@Autowired
	private IModalidadDao modalidadDao;

	@Override
	public List<Modalidad> findAll() throws Exception {
		return modalidadDao.findAll();
	}

	@Override
	public Modalidad save(Modalidad modalidad) throws Exception {
		if (modalidad == null) {
			throw new Exception("El curso a guardar esta vacio");
		}
		
		return modalidadDao.save(modalidad);
	}

}
