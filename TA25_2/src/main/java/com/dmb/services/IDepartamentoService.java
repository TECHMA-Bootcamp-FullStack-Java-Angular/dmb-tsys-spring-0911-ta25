package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entiteis.Departamento;

public interface IDepartamentoService {
	
	public List<Departamento> gettAll();
	
	public Optional <Departamento> getByID(int id);
	
	public Departamento save(Departamento dept);
	
	public void deleteByID(int id);

}
