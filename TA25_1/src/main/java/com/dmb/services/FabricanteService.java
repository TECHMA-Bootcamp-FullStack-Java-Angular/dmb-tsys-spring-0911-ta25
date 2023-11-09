package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Fabricante;
import com.dmb.repository.FabricanteDAO;

@Service
public class FabricanteService implements IFabricanteService {

	@Autowired
    private FabricanteDAO dao;
	
	
	@Override
	public List<Fabricante> listFabticantes() {
		
		return dao.findAll();
	}

	@Override
	public Fabricante saveFabricante(Fabricante fabricante) {
		
		return dao.save(fabricante);
	}

	@Override
	public Optional<Fabricante> fabicanteByID(Integer id) {
		
		return dao.findById(id);
	}

	@Override
	public Fabricante updateFabricante(Fabricante fabricante) {	
		return dao.save(fabricante);
	}

	@Override
	public void deleteFabricante(Integer id) {
		dao.deleteById(id);
	}


}
