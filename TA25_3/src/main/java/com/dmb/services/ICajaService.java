package com.dmb.services;

import java.util.List;
import java.util.Optional;


import com.dmb.entities.Caja;

public interface ICajaService {
	
	   //CRUD
		public List<Caja>getCajas();
		public Optional<Caja> getCaja(String ref_num);
		public Caja createCaja(Caja al);
		public Caja editCaja(Caja al);
		public void deleteCaja(String ref_num);

}
