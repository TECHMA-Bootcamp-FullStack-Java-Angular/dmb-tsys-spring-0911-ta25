package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Almacen;
import com.dmb.repository.AlmacenDAO;

@Service
public class AlmacenService implements IAlmacenService{
	
	@Autowired
	private AlmacenDAO dao;

	@Override
	public List<Almacen> getAlamacenes() {
		return dao.findAll();
	}

	@Override
	public Optional<Almacen> getAlmacen(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Almacen createAlmacen(Almacen al) {
		return dao.save(al);
	}

	@Override
	public Almacen editAlamacen(Almacen al) {
		return dao.save(al);
	}

	@Override
	public void deleteAlamacen(Integer id) {
		dao.deleteById(id);

	}

}
