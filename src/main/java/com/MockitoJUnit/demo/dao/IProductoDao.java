package com.MockitoJUnit.demo.dao;

import java.text.ParseException;
import java.util.List;

import com.MockitoJUnit.demo.model.dto.ProductoDto;
import com.MockitoJUnit.demo.model.table.Producto;

public interface IProductoDao {
	public void insertProducto(ProductoDto dto) throws ParseException;

	/**
	 * busca un producto y retorna falso se no existe el producto o verdadero si
	 * existe
	 * 
	 * @param nombre
	 * @return true or false
	 */
	public boolean isProduct(String nombre);

	/**
	 * devuelve una lista de productos cuyo precio es inferior a la media de los
	 * precios o devuelve o lista de prudctos superior a la media de los precios
	 * 
	 * @return
	 */
	public List<Producto> productosBaratosOrCaros(Integer criterio);
	
	/**
	 * retorna una lista de producto
	 * @return List<Producto>
	 */
	public List<Producto> listaProductos();

}
