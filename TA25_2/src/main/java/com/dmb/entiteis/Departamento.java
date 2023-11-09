package com.dmb.entiteis;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "departamentos")
public class Departamento {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "presupuesto", nullable = false)
	private int presupuesto;

	@OneToMany
	@JoinColumn(name = "FK_departamento")
	private List<Empleado> empleado;



	public Departamento() {
	}

	public Departamento(Integer id, String nombre, int presupuesto) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	// Getters
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleado() {
		return empleado;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}

}