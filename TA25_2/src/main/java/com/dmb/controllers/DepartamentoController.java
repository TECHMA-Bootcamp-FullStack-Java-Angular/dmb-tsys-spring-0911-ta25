package com.dmb.controllers;

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

import com.dmb.entiteis.Departamento;
import com.dmb.services.DepartamentoService;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {

	@Autowired
	DepartamentoService serv;
	
	@GetMapping("/departamentos")
	public ResponseEntity<List<Departamento>> gellAllDepartamento(){
	 return ResponseEntity.ok(serv.gettAll());
	}
	
	@GetMapping("/departamento/{id}")
	public ResponseEntity<Departamento> getDapartamentoByID(@PathVariable (name="id") int id){
		 Optional<Departamento> dpto = serv.getByID(id);
		 if (dpto.isPresent()) {
			 return ResponseEntity.ok(dpto.get());
		 } else {
			 return ResponseEntity.status(404).build();
		 }
	}
	
	@PostMapping("/departamento")
	public ResponseEntity<Departamento> saveDepartamento(@RequestBody Departamento dpto){
		        serv.save(dpto);
		return ResponseEntity.status(201).body(dpto);
	}
	
	@PutMapping("/departamento/{id}")
	public ResponseEntity<Departamento> updateDepatemanto(@RequestBody Departamento dptoUpdate , @PathVariable (name="id") int id){
		 Optional<Departamento> dpto = serv.getByID(id);
		 if(dpto.isPresent()) {
			 dptoUpdate.setId(id);
			 return ResponseEntity.ok(serv.save(dptoUpdate));
		 } else {
			 return ResponseEntity.notFound().build();
		 }
	}
	
	@DeleteMapping("/departamento/{id}")
	public ResponseEntity<Void> deleteDepartemento(@PathVariable(name = "id") int id) {
		 Optional<Departamento> dpto = serv.getByID(id);
		if (dpto.isPresent()) {
			serv.deleteByID(id);
			return ResponseEntity.noContent().build(); 
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}
	
}
