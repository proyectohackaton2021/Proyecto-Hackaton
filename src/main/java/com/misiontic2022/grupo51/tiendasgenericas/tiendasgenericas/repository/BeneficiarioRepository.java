package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Beneficiario;

public interface BeneficiarioRepository extends MongoRepository<Beneficiario, String>{
	
	List<Beneficiario> findByDocumento(String documento);	
	List<Beneficiario> findByNombrecompleto(String nombrecompleto);

}
