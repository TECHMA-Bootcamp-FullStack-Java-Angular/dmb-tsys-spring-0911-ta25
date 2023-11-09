package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Fabricante;

public interface IFabricanteService {
	
	public List<Fabricante> listFabticantes();
	
	public Fabricante saveFabricante(Fabricante fabricante);
	
	public Optional<Fabricante> fabicanteByID( Integer id);
	
	public Fabricante updateFabricante (Fabricante fabricante);
	
	public void deleteFabricante(Integer id);
	


}
