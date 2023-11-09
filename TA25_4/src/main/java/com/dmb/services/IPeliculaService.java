package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Pelicula;

public interface IPeliculaService {
	
	//CRUD
	public List<Pelicula> getAllPelicilas();
	public Optional<Pelicula> getPelicula(int codigo);
	public Pelicula ceatePelicula(Pelicula peli );
	public Pelicula upadatePelicula(Pelicula peli);
	public void deletePelicula(int codigo);

}
