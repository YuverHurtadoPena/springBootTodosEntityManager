package com.MockitoJUnit.demo.service;

import org.springframework.http.ResponseEntity;

import com.MockitoJUnit.demo.model.dto.ProductoDto;

public interface IProductoService {
	public ResponseEntity<?> guardarProducto(ProductoDto dto);

	public  ResponseEntity<?>  getProductosBaratosOrCaros(Integer criterio);
	
	public  ResponseEntity<?>  getListaProductos();

}
