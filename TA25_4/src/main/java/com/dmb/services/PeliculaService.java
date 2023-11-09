package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Pelicula;
import com.dmb.repository.PeliculaDAO;

@Service
public class PeliculaService implements IPeliculaService {

	@Autowired
	private PeliculaDAO dao;

	@Override
	public List<Pelicula> getAllPelicilas() {

		return dao.findAll();
	}

	@Override
	public Optional<Pelicula> getPelicula(int codigo) {

		return dao.findById(codigo);
	}

	@Override
	public Pelicula ceatePelicula(Pelicula peli) {

		return dao.save(peli);
	}

	@Override
	public Pelicula upadatePelicula(Pelicula peli) {

		return dao.save(peli);
	}

	@Override
	public void deletePelicula(int codigo) {
		dao.deleteById(codigo);

	}

}
