package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Almacen;

public interface IAlmacenService {

    //CRUD
	public List<Almacen>getAlamacenes();
	public Optional<Almacen> getAlmacen(Integer id);
	public Almacen createAlmacen(Almacen al);
	public Almacen editAlamacen(Almacen al);
	public void deleteAlamacen(Integer id);
}
