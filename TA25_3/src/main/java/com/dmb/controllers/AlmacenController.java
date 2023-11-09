package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Almacen;
import com.dmb.services.AlmacenService;

@RestController
@RequestMapping("api/v1")
public class AlmacenController {
	
	@Autowired
	private AlmacenService serv;

	@GetMapping("/almacenes")
	public ResponseEntity<List<Almacen>> getAlamacenes() {
		return ResponseEntity.ok(serv.getAlamacenes());
	}
	
	@GetMapping("/almacen/{id}")
	public ResponseEntity<Almacen> getAlamacen(@PathVariable(name = "id") Integer id ) {
		Optional<Almacen> almacen = serv.getAlmacen(id);
		if (almacen.isPresent()) {
			return ResponseEntity.ok(almacen.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@PostMapping("/almacen")
	public ResponseEntity<Almacen> saveAlamacen(@RequestBody Almacen articulo) {
		serv.createAlmacen(articulo);
		return ResponseEntity.status(HttpStatus.CREATED).body(articulo);
	}
	
	@DeleteMapping("/almacen/{id}")
	public ResponseEntity<Void> deleteAlmacen(@PathVariable(name = "id")Integer id ) {
		Optional<Almacen> almacen = serv.getAlmacen(id);
		if (almacen.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@PutMapping("/almacen/{id}")
	public ResponseEntity<Almacen> updateAlmacen(@PathVariable(name = "id") Integer id, @RequestBody Almacen updatedEntity ) {
		
		System.out.println("\n\n"+id);
		Optional<Almacen> almacen = serv.getAlmacen(id);
		System.out.println("\n\n"+ almacen.get().toString());
		if (almacen.isPresent()) {	
			    Almacen entity = almacen.get();
	 
			    entity.setId(id);
			    entity.setLugar(updatedEntity.getLugar());
			    entity.setCapacidad(updatedEntity.getCapacidad());
				entity.setCajas(updatedEntity.getCajas());
	
			  
			return ResponseEntity.ok(  serv.editAlamacen(entity));
		} else {

			return ResponseEntity.notFound().build();
		}
	}
	
}
