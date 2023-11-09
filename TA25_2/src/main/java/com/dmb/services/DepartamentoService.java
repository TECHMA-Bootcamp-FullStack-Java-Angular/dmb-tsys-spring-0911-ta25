package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entiteis.Departamento;
import com.dmb.repository.DepartamentoDAO;

@Service
public class DepartamentoService implements IDepartamentoService {

	
	@Autowired
	private DepartamentoDAO dao;

	@Override
	public List<Departamento> gettAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Departamento> getByID(int id) {
		return dao.findById(id);
	}

	@Override
	public Departamento save(Departamento dept) {
		return dao.save(dept);
	}

	@Override
	public void deleteByID(int id) {
		dao.deleteById(id);
	}
}
