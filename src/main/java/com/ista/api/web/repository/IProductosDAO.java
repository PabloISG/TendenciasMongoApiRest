package com.ista.api.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ista.api.web.model.Producto;


@Repository
public interface IProductosDAO extends MongoRepository<Producto, String>{

	//Producto insert(Producto producto);
	

}
