package com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Credito;
import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository.CreditoRepository;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CreditoController {

	@Autowired
	CreditoRepository creditoRepository;

	@GetMapping("/creditos")
	public ResponseEntity<List<Credito>> getAllCreditos(@RequestParam(required = false) String fechainicio) {
		try {
			List<Credito> creditos = new ArrayList<Credito>();

			if (fechainicio == null) {
				creditoRepository.findAll().forEach(creditos::add);
			} else {
				creditoRepository.findByFechainicio(fechainicio).forEach(creditos::add);
			}

			if (creditos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(creditos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/creditos/{id}")
	public ResponseEntity<Credito> getCreditosById(@PathVariable("id") String id) {
		Optional<Credito> creditoData = creditoRepository.findById(id);

		if (creditoData.isPresent()) {
			return new ResponseEntity<>(creditoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/creditos")
	public ResponseEntity<Credito> createCredito(@RequestBody Credito cred) {
		try {
			Credito _credito = creditoRepository.save(new Credito(cred.getMonto(), cred.getIdbeneficiario(),
					cred.getIddonante(), cred.getFechainicio(), cred.getFechafin(), cred.getInteres()));
			return new ResponseEntity<>(_credito, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/creditos/{id}")
	public ResponseEntity<Credito> updateCredito(@PathVariable("id") String id, @RequestBody Credito user) {
		Optional<Credito> creditoData = creditoRepository.findById(id);

		if (creditoData.isPresent()) {
			Credito _credito = creditoData.get();
			_credito.setMonto(user.getMonto());
			_credito.setIdbeneficiario(user.getIdbeneficiario());
			_credito.setIddonante(user.getIddonante());
			_credito.setFechainicio(user.getFechainicio());
			_credito.setFechafin(user.getFechafin());
			_credito.setInteres(user.getInteres());

			return new ResponseEntity<>(creditoRepository.save(_credito), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/creditos/{id}")
	public ResponseEntity<HttpStatus> deleteCreditos(@PathVariable("id") String id) {
		try {
			creditoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/creditos")
	public ResponseEntity<HttpStatus> deleteAllCreditos() {
		try {
			creditoRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/creditos/{idbeneficiario}")
	public ResponseEntity<List<Credito>> findByIdBeneficiario(@PathVariable("idbeneficiario") String idbeneficiario) {
		try {
			List<Credito> credito = creditoRepository.findByIdbeneficiario(idbeneficiario);

			if (credito.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(credito, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/creditos/{iddonante}")
	public ResponseEntity<List<Credito>> findByIdDonante(@PathVariable("iddonante") String iddonante) {
		try {
			List<Credito> credito = creditoRepository.findByIddonante(iddonante);

			if (credito.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(credito, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}