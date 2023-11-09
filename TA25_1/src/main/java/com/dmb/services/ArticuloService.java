package com.dmb.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dmb.entities.Articulo;
import com.dmb.repository.ArticuloDAO;

@Service
public class ArticuloService implements IArticuloService {

	@Autowired
	private ArticuloDAO dao;

	@Override
	public List<Articulo> listArticulo() {
		return dao.findAll();
	}

	@Override
	public Articulo saveArticulo(Articulo articulo) {
		return dao.save(articulo);
	}

	@Override
	public Optional<Articulo> ArticuloById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Articulo updateArticulo(Articulo articulo) {	
		return dao.save(articulo);
	}

	@Override
	public void deleteArticulo(Integer id) {
		dao.deleteById(id);
		
	}



}
