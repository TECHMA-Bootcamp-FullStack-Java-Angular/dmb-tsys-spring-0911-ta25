package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Caja;
import com.dmb.repository.CajaDAO;

@Service
public class CajaService implements ICajaService {

	@Autowired
	private CajaDAO dao;

	@Override
	public List<Caja> getCajas() {
		return dao.findAll();
	}

	@Override
	public Optional<Caja> getCaja(String ref_num) {
		return dao.findById(ref_num);
	}

	@Override
	public Caja createCaja(Caja al) {
		return dao.save(al);
	}

	@Override
	public Caja editCaja(Caja al) {
		return dao.save(al);
	}

	@Override
	public void deleteCaja(String ref_num) {
		dao.deleteById(ref_num);
	}

}
