package com.MockitoJUnit.demo.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MockitoJUnit.demo.dao.IProductoDao;
import com.MockitoJUnit.demo.model.dto.ProductoDto;
import com.MockitoJUnit.demo.model.table.Producto;

@Repository
@SuppressWarnings("unused")
public class ProductoDaoImpl implements IProductoDao {
	private static final String YYYY_MM_DD = "yyyy/MM/dd";

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insertProducto(ProductoDto dto) {
		Producto producto = new Producto();
		producto.setNombre(dto.getNombre());
		producto.setValor(dto.getValor());
		producto.setFechaRegistro(new Date());
		producto.setFechaActualizacion(null);
		entityManager.persist(producto);

	}

	@Override
	public boolean isProduct(String nombre) {
		String sql = "SELECT case WHEN nombre=?1 THEN true else false END FROM producto where nombre=?1";
		try {
			Integer valor = (Integer) entityManager.createNativeQuery(sql).setParameter(1, nombre).getSingleResult();
			return valor == 1;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Producto> productosBaratosOrCaros(Integer criterio) {

		String sqlBaratos = "SELECT id,nombre,precio,fecha_actualizacion,fecha_registro FROM producto WHERE precio<(SELECT AVG(precio) FROM producto)";
		String sqlCaros = "SELECT id,nombre,precio,fecha_actualizacion,fecha_registro FROM producto WHERE precio>(SELECT AVG(precio) FROM producto)";
		if (criterio == 2) {
			Query query = entityManager.createNativeQuery(sqlBaratos, Producto.class);
			return query.getResultList();

		} else {
			Query query = entityManager.createNativeQuery(sqlCaros, Producto.class);
			return query.getResultList();
		}
	}

	@Override
	public List<Producto> listaProductos() {
		String sql = "SELECT id,nombre,precio,fecha_actualizacion,fecha_registro FROM producto order by nombre";
		Query query = entityManager.createNativeQuery(sql, Producto.class);
		return query.getResultList();
	}

}
