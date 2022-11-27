package com.MockitoJUnit.demo.service.impl;

import java.text.ParseException;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.MockitoJUnit.demo.dao.IProductoDao;
import com.MockitoJUnit.demo.model.dto.ProductoDto;
import com.MockitoJUnit.demo.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	@Autowired
	private IProductoDao dao;

	@Override
	public ResponseEntity<?> guardarProducto(ProductoDto dto) {
		try {
			if (!dao.isProduct(dto.getNombre())) {
				dao.insertProducto(dto);
				return new ResponseEntity<>("producto registrado con exito", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("El producto ya existe", HttpStatus.BAD_REQUEST);
			}

		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>("ocurrio un error interno", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> getProductosBaratosOrCaros(Integer criterio) {
		if (criterio == 1 || criterio == 2) {
			return new ResponseEntity<>(dao.productosBaratosOrCaros(criterio), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("criterio de busqueda no soportado", HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<?> getListaProductos() {
		try {
			return new ResponseEntity<>(dao.listaProductos(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("ocurrio un error interno", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
