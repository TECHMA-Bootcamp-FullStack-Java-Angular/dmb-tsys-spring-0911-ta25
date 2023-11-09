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

import com.dmb.entities.Pelicula;
import com.dmb.services.PeliculaService;

@RestController
@RequestMapping("api/v1")
public class PeliculaController {

	@Autowired
	PeliculaService serv;
	
	@GetMapping("/peliculas")
	public ResponseEntity<List<Pelicula>> getPeliculas() {
		return ResponseEntity.ok(serv.getAllPelicilas());
	}
	
	@GetMapping("/pelicula/{codigo}")
	public ResponseEntity<Pelicula> getPelicula(@PathVariable (name="codigo") int codigo) {
		Optional<Pelicula> peli = serv.getPelicula(codigo);
		if (peli.isPresent()) {
			return ResponseEntity.ok(peli.get());
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping("/pelicula")
	public ResponseEntity<Pelicula> potsPelicula(@RequestBody Pelicula peli) {
		return ResponseEntity.ok(serv.ceatePelicula(peli));
		
	}
	
	@PutMapping("/pelicula/{codigo}")
	public ResponseEntity<Pelicula> putPelicula(@PathVariable (name="codigo") int codigo , @RequestBody Pelicula peli ) {
		Optional<Pelicula> peliculaOLD = serv.getPelicula(codigo);
		if (peliculaOLD.isPresent()) {
			peli.setCodigo(codigo);
			return ResponseEntity.ok(peli);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/pelicula/{codigo}") 
	public ResponseEntity<Pelicula> deletPelicula(@PathVariable (name="codigo") int codigo) {
		Optional<Pelicula> peli = serv.getPelicula(codigo);
		if (peli.isPresent()) {
			serv.deletePelicula(codigo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
