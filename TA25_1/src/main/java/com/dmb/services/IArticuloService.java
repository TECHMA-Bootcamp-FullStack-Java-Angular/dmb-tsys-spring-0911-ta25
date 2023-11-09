package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Articulo;

public interface IArticuloService {
	
	public List<Articulo> listArticulo();

	public Articulo saveArticulo(Articulo articulo);

	public Optional<Articulo> ArticuloById(Integer id);

	public Articulo updateArticulo(Articulo articulo);

	public void deleteArticulo(Integer id);


}
