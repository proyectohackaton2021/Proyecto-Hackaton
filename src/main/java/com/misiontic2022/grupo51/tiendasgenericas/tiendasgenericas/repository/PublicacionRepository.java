package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Publicacion;

public interface PublicacionRepository extends MongoRepository<Publicacion, String>{
	
	List<Publicacion> findByEstado(String estado);
	List<Publicacion> findByFechacreacion(String fechacreacion);
}
