package com.MockitoJUnit.demo.model.table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 150, unique = true)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private double valor;

	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public Integer getId() {
		return id;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
