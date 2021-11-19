package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Donante;




public interface DonanteRepository extends MongoRepository<Donante, String>{
	
	List<Donante> findByDocumento(String documento);
	List<Donante> findByNombrecompleto(String nombrecompleto);

}
