package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Credito;

public interface CreditoRepository extends MongoRepository<Credito, String>{
	
	List<Credito> findByIdbeneficiario(String idbeneficiario);	
	List<Credito> findByIddonante(String iddonante);
	List<Credito> findByFechainicio(String fechainicio);

}
