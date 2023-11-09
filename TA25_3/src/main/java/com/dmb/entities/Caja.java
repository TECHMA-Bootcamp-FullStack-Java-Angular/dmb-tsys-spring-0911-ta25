package com.dmb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cajas")
public class Caja {

	@Id
	private String ref_num;

	private String contenido;

	private int valor;

	@ManyToOne()
	@JoinColumn(name = "almacen")
	private Almacen almacen;

	public Caja() {
	}

	public Caja(String ref_num, String contenido, int valor, Almacen almacen) {
		this.ref_num = ref_num;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	public String getRef_num() {
		return ref_num;
	}

	public String getContenido() {
		return contenido;
	}

	public int getValor() {
		return valor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setRef_num(String ref_num) {
		this.ref_num = ref_num;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

}