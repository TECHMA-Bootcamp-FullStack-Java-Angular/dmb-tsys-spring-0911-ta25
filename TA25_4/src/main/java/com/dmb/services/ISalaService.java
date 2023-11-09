package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Sala;

public interface ISalaService {
	
	//CRUD
	public List<Sala> getAllSalas();
	public Optional<Sala> getSala(int codigo);
	public Sala ceateSala(Sala peli );
	public Sala upadateSala(Sala peli);
	public void deleteSala(int codigo);


}
