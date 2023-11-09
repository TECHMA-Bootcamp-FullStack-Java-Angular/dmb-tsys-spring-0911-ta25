package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Sala;
import com.dmb.repository.SalaDAO;

@Service
public class SalaService implements ISalaService{
	
	@Autowired
	private SalaDAO dao;

	@Override
	public List<Sala> getAllSalas() {
	
		return dao.findAll();
	}

	@Override
	public Optional<Sala> getSala(int codigo) {

		return dao.findById(codigo);
	}

	@Override
	public Sala ceateSala(Sala peli) {

		return dao.save(peli);
	}

	@Override
	public Sala upadateSala(Sala peli) {

		return dao.save(peli);
	}

	@Override
	public void deleteSala(int codigo) {

		dao.deleteById(codigo);
	}

}
