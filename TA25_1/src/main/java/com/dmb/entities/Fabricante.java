package com.dmb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fabricantes")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="FK_fabricante")
	private List<Articulo> atiticlo;
	
	public Fabricante() {	
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param atiticlo
	 */
	public Fabricante(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Articulo")
	public List<Articulo> getAtiticlo() {
		return atiticlo;
	}

	public void setAtiticlo(List<Articulo> atiticlo) {
		this.atiticlo = atiticlo;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + ", atiticlo=" + atiticlo + "]";
	}

}
