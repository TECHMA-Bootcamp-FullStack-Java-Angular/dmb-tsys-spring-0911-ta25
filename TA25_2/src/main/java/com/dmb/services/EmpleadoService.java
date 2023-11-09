package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entiteis.Empleado;
import com.dmb.repository.EmpleadoDAO;

@Service
public class EmpleadoService implements IEmpleadoService {


	@Autowired
	private EmpleadoDAO dao;
	
	
	@Override
	public List<Empleado> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Empleado> getByDni(String dni) {
		return dao.findById(dni);
	}

	@Override
	public Empleado save(Empleado empleado) {
		return dao.save(empleado);
	}

	@Override
	public Empleado updateByDni(Empleado empleado) {

		return dao.save(empleado);
	}

	@Override
	public void deleteByDni(String dni) {
		dao.deleteById(dni);
		
	}

	

}
