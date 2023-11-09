package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entiteis.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> getAll(); 
	
	public Optional<Empleado> getByDni(String dni);	
	
	public Empleado  save(Empleado empleado); 
	
	public Empleado updateByDni(Empleado empleado); 
	
	public void deleteByDni(String dni);

}
