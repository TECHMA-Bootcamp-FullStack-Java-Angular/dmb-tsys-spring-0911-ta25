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

import com.dmb.entiteis.Empleado;
import com.dmb.services.EmpleadoService;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

	@Autowired
	EmpleadoService serv;

	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> getAllEmpleados() {
		return ResponseEntity.ok(serv.getAll());
	}

	@GetMapping("/empleado/{dni}")
	public ResponseEntity<Optional<Empleado>> getByDNIEmpleado(@PathVariable(name = "dni") String dni) {
		Optional<Empleado> empleado = serv.getByDni(dni);
		System.out.println(empleado.get().toString());
		if (empleado.isPresent()) {
			return ResponseEntity.ok(empleado);
		} else {
			return ResponseEntity.status(404).build();
		}

	}

	@PostMapping("/empleado")
	public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
		return ResponseEntity.status(201).body(serv.save(empleado));
	}

	@PutMapping("/empleado/{dni}")
	public ResponseEntity<Empleado> updateEmpeado(@RequestBody Empleado empleado,
			@PathVariable(name = "dni") String dni) {

		Optional<Empleado> empleadoOld = serv.getByDni(dni);

		if (empleadoOld.isPresent()) {
			empleado.setDni(dni);
			return ResponseEntity.status(204).body(empleado);
		} else {
			return ResponseEntity.status(404).build();
		}

	}

	@DeleteMapping("/empleado/{dni}")
	public ResponseEntity<Void> deleteByDNIEmpleado(@PathVariable(name = "dni") String dni) {

		Optional<Empleado> empleado = serv.getByDni(dni);

		if (empleado.isPresent()) {
			serv.deleteByDni(dni);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(404).build();
		}

	}

}
