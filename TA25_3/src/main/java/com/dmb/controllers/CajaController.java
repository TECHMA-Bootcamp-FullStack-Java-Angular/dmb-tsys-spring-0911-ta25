package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Caja;
import com.dmb.services.CajaService;

@RestController
@RequestMapping("api/v1")
public class CajaController {

	@Autowired
	private CajaService serv;

	@GetMapping("/cajas")
	public ResponseEntity<List<Caja>> getCajas() {
		return ResponseEntity.ok(serv.getCajas());
	}

	@GetMapping("/caja/{ref}")
	public ResponseEntity<Caja> getCajasByID(@PathVariable(name = "ref") String ref) {
		Optional<Caja> caja = serv.getCaja(ref);
		if (caja.isPresent()) {
			return ResponseEntity.ok(caja.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/caja")
	public ResponseEntity<Caja> saveCaja(@RequestBody Caja caja) {
		serv.createCaja(caja);
		return ResponseEntity.status(HttpStatus.CREATED).body(caja);
	}

	@DeleteMapping("/caja/{ref}")
	public ResponseEntity<Void> deleteCaja(@PathVariable(name = "ref")String ref) {
		Optional<Caja> caja = serv.getCaja(ref);
		if (caja.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/caja/{ref}")
	public ResponseEntity<Caja> updateCaja(@PathVariable(name = "ref") String ref,

			@RequestBody Caja updatedIntity) {

		Optional<Caja> caja = serv.getCaja(ref);

		if (caja.isPresent()) {
			updatedIntity.setRef_num(ref);
			serv.editCaja(updatedIntity);

			return ResponseEntity.ok(updatedIntity);

		} else {

			return ResponseEntity.notFound().build();
		}
	}


}
