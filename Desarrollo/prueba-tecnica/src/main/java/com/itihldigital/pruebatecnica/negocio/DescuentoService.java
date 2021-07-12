package com.itihldigital.pruebatecnica.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.itihldigital.pruebatecnica.reporsitorio.IDescuentoDao;
import com.itihldigital.pruebatecnica.reporsitorio.modelo.Descuento;
import com.itihldigital.pruebatecnica.utilidades.Constantes;

@Scope("singleton")
@Service
public class DescuentoService implements IDescuentoService {


	
	@Autowired
	private IDescuentoDao descuentoDao;
	
	public Descuento save(Descuento descuento) throws Exception {
		
		if (descuento == null) {
			throw new Exception("El Descuento a guardar esta vacio");
		}
		
		if (descuento.getCurso() == null) {
			throw new Exception("Debe seleccionar un curso");
		}
		
		if (descuento.getNombre() == null || descuento.getNombre().trim().equals("")) {
			throw new Exception("Debe Escribir un nombre de descuento");
		}
		
		if (descuento.getPais() == null || descuento.getPais().trim().equals("")) {
			throw new Exception("Debe Escribir un nombre de descuento");
		}
		
		if (descuento.getCurso().getModalidad().getNombre().trim().equals(Constantes.ON_DEMAND)) {
			descuento.setDescuento("30%");
		}else if ((descuento.getCurso().getModalidad().getNombre().trim().equals(Constantes.ONLINE))) {
			descuento.setDescuento("20%");
		}else if ((descuento.getCurso().getModalidad().getNombre().trim().equals(Constantes.PRIVADO))){
			descuento.setDescuento("10%");
		}else {
			descuento.setDescuento("0%");
			
		}
		
		return descuentoDao.save(descuento);
	}

	@Override
	public List<Descuento> findByAll() throws Exception {
		return descuentoDao.findAll();
	}



}
