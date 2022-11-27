package com.MockitoJUnit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MockitoJUnit.demo.model.dto.ProductoDto;
import com.MockitoJUnit.demo.service.IProductoService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class ControllerProducto {
	@Autowired
	private IProductoService service;

	@PostMapping("save")
	public ResponseEntity<?> createProduct(@RequestBody ProductoDto dto) {
		return service.guardarProducto(dto);
	}

	@GetMapping("get_productos_baratos_Caros/{criterio}")
	public ResponseEntity<?> getProductosBaratosOrCaros(@PathVariable("criterio") Integer criterio) {
		return  service.getProductosBaratosOrCaros(criterio);
	}
	
	@GetMapping("listaProductos")
	public ResponseEntity<?> getListaProductos() {
		return  service.getListaProductos();
	}

}
