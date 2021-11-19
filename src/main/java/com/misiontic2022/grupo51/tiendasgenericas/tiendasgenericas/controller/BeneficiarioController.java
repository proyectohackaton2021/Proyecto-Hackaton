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


import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Beneficiario;
import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository.BeneficiarioRepository;


@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BeneficiarioController {

	@Autowired
	BeneficiarioRepository beneficiarioRepository;

	@GetMapping("/beneficiarios")
	public ResponseEntity<List<Beneficiario>> getAllBeneficiarios(@RequestParam(required = false) String documento) {
		try {
			List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();

			if (documento == null) {
				beneficiarioRepository.findAll().forEach(beneficiarios::add);
			} else {
				beneficiarioRepository.findByNombrecompleto(documento).forEach(beneficiarios::add);
			}

			if (beneficiarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/beneficiarios/{id}")
	public ResponseEntity<Beneficiario> getBeneficiariosById(@PathVariable("id") String id) {
		Optional<Beneficiario> beneficiarioData = beneficiarioRepository.findById(id);

		if (beneficiarioData.isPresent()) {
			return new ResponseEntity<>(beneficiarioData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/beneficiarios")
	public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario benef) {
		try {
			Beneficiario _beneficiario = beneficiarioRepository.save(
					new Beneficiario(benef.getTipodocumento(), benef.getDocumento(), benef.getNombrecompleto(), 
										benef.getFechanacimiento(), benef.getEmail(), benef.getPassword(), 
										benef.getCelular()));
			return new ResponseEntity<>(_beneficiario, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/beneficiarios/{id}")
	public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable("id") String id, @RequestBody Beneficiario user) {
		Optional<Beneficiario> beneficiarioData = beneficiarioRepository.findById(id);

		if (beneficiarioData.isPresent()) {
			Beneficiario _beneficiario = beneficiarioData.get();
			_beneficiario.setTipodocumento(user.getTipodocumento());
			_beneficiario.setDocumento(user.getDocumento());
			_beneficiario.setNombrecompleto(user.getNombrecompleto());
			_beneficiario.setFechanacimiento(user.getFechanacimiento());
			_beneficiario.setEmail(user.getEmail());
			_beneficiario.setPassword(user.getPassword());
			_beneficiario.setCelular(user.getCelular());
			
			return new ResponseEntity<>(beneficiarioRepository.save(_beneficiario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/beneficiarios/{id}")
	public ResponseEntity<HttpStatus> deleteBeneficiarios(@PathVariable("id") String id) {
		try {
			beneficiarioRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/beneficiarios")
	public ResponseEntity<HttpStatus> deleteAllBeneficiarios() {
		try {
			beneficiarioRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/beneficiarios/{documento}")
	public ResponseEntity<List<Beneficiario>> findByDocumento(@PathVariable("documento") String documento) {
		try {
			List<Beneficiario> beneficiario = beneficiarioRepository.findByDocumento(documento);

			if (beneficiario.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(beneficiario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}