package com.MockitoJUnit.demo.model.dto;

import java.util.Date;

public class ProductoDto {

	private String nombre;

	private double valor;

	private Date fechaRegistro;

	private Date fechaActualizacion;

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
