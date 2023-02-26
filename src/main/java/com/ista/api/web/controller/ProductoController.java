package com.ista.api.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ista.api.web.model.Producto;
import com.ista.api.web.repository.IProductosDAO;

@RestController
@CrossOrigin(origins = "=", methods = {
		RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE
})
@RequestMapping("/api/products")
public class ProductoController {

	@Autowired
	private IProductosDAO repository;
	
	@PostMapping("/product")
	public Producto create(@Validated @RequestBody Producto producto) {
		return repository.insert(producto);
	}
	
	@GetMapping("/")
	public List<Producto> readAll(){
		return repository.findAll();
	}
	
	@PutMapping("/product/{id}")
	public Producto update(@PathVariable String id,@Validated @RequestBody Producto producto) {
		return repository.save(producto);
	}
	
	@DeleteMapping("/produc/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
}
