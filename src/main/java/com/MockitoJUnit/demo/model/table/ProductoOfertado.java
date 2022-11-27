package com.MockitoJUnit.demo.model.table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos_oferta")
public class ProductoOfertado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto")
	private Producto idPdroducto;

	private double porcentaje;

	private boolean activo;

	public Producto getIdPdroducto() {
		return idPdroducto;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setIdPdroducto(Producto idPdroducto) {
		this.idPdroducto = idPdroducto;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
