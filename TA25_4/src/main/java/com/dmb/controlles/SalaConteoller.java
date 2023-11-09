package com.dmb.controlles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Sala;
import com.dmb.services.SalaService;

@RestController
@RequestMapping("api/v1")
public class SalaConteoller {
	
	@Autowired
	SalaService serv;
	
	@GetMapping("/salas")
	public ResponseEntity<List<Sala>> getSalas() {
		return ResponseEntity.ok(serv.getAllSalas());
	}
	
	@GetMapping("/sala/{codigo}")
	public ResponseEntity<Sala> getSala(@PathVariable (name="codigo") int codigo) {
		Optional<Sala> sala = serv.getSala(codigo);
		if (sala.isPresent()) {
			return ResponseEntity.ok(sala.get());
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping("/sala")
	public ResponseEntity<Sala> potsSala(@RequestBody Sala sala) {
		return ResponseEntity.ok(serv.ceateSala(sala));
		
	}
	
	@PutMapping("/sala/{codigo}")
	public ResponseEntity<Sala> putSala(@PathVariable (name="codigo") int codigo , @RequestBody Sala sala ) {
		Optional<Sala> salaOLD = serv.getSala(codigo);
		if (salaOLD.isPresent()) {
			sala.setCodigo(codigo);
			return ResponseEntity.ok(sala);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/sala/{codigo}") 
	public ResponseEntity<Sala> deletSala(@PathVariable (name="codigo") int codigo) {
		Optional<Sala> sala = serv.getSala(codigo);
		if (sala.isPresent()) {
			serv.deleteSala(codigo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}


}
