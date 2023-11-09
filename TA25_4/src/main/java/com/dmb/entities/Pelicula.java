package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String nombre; 
	
	@OneToMany
	@JoinColumn(name = "pelicula")
	private List<Pelicula> peleiculas;
	
	public Pelicula() {
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param peleiculas
	 */
	public Pelicula(int codigo, String nombre, List<Pelicula> peleiculas) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.peleiculas = peleiculas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Sala")
	public List<Pelicula> getPeleiculas() {
		return peleiculas;
	}

	public void setPeleiculas(List<Pelicula> peleiculas) {
		this.peleiculas = peleiculas;
	}


	
	

}
