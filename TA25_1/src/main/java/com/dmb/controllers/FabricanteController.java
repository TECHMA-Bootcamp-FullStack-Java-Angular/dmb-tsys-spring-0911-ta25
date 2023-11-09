package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dmb.entities.Fabricante;

import com.dmb.services.FabricanteService;


@Controller
@RequestMapping("/api/v1")
public class FabricanteController {
	
	@Autowired
	FabricanteService fabricanteServ;
	
	@GetMapping("/fabricantes")
	public ResponseEntity<List<Fabricante>> toList(){
		return ResponseEntity.ok(fabricanteServ.listFabticantes());
	}
	
	@PostMapping("/fabricante")
	public ResponseEntity<Fabricante> save(@RequestBody Fabricante fabricante) {
		fabricanteServ.saveFabricante(fabricante);
		return ResponseEntity.status(HttpStatus.CREATED).body(fabricante);
	}
	
	@GetMapping("/fabricante/{id}")
	public ResponseEntity<Fabricante> getByID(@PathVariable (name="id") Integer id){
		Optional<Fabricante> fabricante = fabricanteServ.fabicanteByID(id);
		
		if (fabricante.isPresent()) {
			return ResponseEntity.ok(fabricante.get());
			
		} else {
			return ResponseEntity.notFound().build(); 	
		}				
	}
	
	@DeleteMapping("/fabricante/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Fabricante> fabricante = fabricanteServ.fabicanteByID(id);
		
		if (fabricante.isPresent()) {			
			fabricanteServ.deleteFabricante(id);			
			return	ResponseEntity.noContent().build();
			
		} else {
			return	ResponseEntity.notFound().build(); 
		} 	
	}
	
	@PutMapping("/fabricante/{id}")
	public ResponseEntity<Fabricante> update(@PathVariable(name = "id") Integer id, @RequestBody Fabricante Rectified) {	
		Optional<Fabricante> fabricante = fabricanteServ.fabicanteByID(id);
	
		if (fabricante.isPresent()) {
			Rectified.setCodigo(fabricante.get().getCodigo());	
			return ResponseEntity.ok(fabricanteServ.updateFabricante(Rectified)); 
			
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}
	


}
