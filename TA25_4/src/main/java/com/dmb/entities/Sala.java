package com.dmb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="salas")
public class Sala {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name = "pelicula")
	private Pelicula pelicula;

	public Sala() {
	}
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param pelicula
	 */
	public Sala(int codigo, String nombre, Pelicula pelicula) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.pelicula = pelicula;
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

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}



}
