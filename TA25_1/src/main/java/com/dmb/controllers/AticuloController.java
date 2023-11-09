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

import com.dmb.entities.Articulo;
import com.dmb.services.ArticuloService;


@Controller
@RequestMapping("/api/v1")
public class AticuloController {
	
	@Autowired
	ArticuloService articuloService;
	
	
	@GetMapping("/articulos")
	public ResponseEntity<List<Articulo>> ArticulosList(){
		return ResponseEntity.ok(articuloService.listArticulo());
	}
	
	@GetMapping("/articulo/{id}")
	public ResponseEntity<Articulo> getArticuloByID(@PathVariable (name="id") Integer id){
		Optional<Articulo> articulo = articuloService.ArticuloById(id);
		if (articulo.isPresent()) {
			return ResponseEntity.ok(articulo.get());
		} else {
			return ResponseEntity.notFound().build(); 
		}	
	}
	

	@PostMapping("/articulo")
	public ResponseEntity<Articulo> saveArticulo(@RequestBody Articulo articulo) {
		articuloService.saveArticulo(articulo);
		return ResponseEntity.status(HttpStatus.CREATED).body(articulo);
	}
	
	@DeleteMapping("/articulo/{id}")
	public ResponseEntity<Void> deleteArticulo(@PathVariable(name = "id") Integer id) {
		Optional<Articulo> articulo = articuloService.ArticuloById(id);
		if (articulo.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@PutMapping("/articulo/{id}")
	public ResponseEntity<Articulo> updateArticulo(@PathVariable(name = "id") Integer id,
			
			@RequestBody Articulo updatedTrabajador) {
		
		Optional<Articulo> articulo = articuloService.ArticuloById(id);
		
		if (articulo.isPresent()) {
			
			Articulo selected = new Articulo(id, articulo.get().getNombre() , articulo.get().getPrecio(), articulo.get().getFabricante() );
			Articulo updated = new Articulo();

			updated = articuloService.updateArticulo(selected);
			
			return ResponseEntity.ok(updated); 
			
		} else {
			
			return ResponseEntity.notFound().build(); 
		}
	}
	

}
