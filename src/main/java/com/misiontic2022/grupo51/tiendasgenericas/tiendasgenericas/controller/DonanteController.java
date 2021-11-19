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

import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Donante;
import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository.DonanteRepository;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DonanteController {
	
	@Autowired
	DonanteRepository donanteRepository;
	
	@GetMapping("/donantes")
    public ResponseEntity<List<Donante>> getAllDonantes(@RequestParam(required = false) String documento) {
        try {
            List<Donante> donantes = new ArrayList<Donante>();
            if (documento == null) {
                donanteRepository.findAll().forEach(donantes::add);
            } else {
                donanteRepository.findByDocumento(documento).forEach(donantes::add);
            }
            if (donantes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(donantes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/donantes/{id}")
	public ResponseEntity<Donante> getDonanteById(@PathVariable("id") String id) {
		Optional<Donante> donanteData = donanteRepository.findById(id);

		if (donanteData.isPresent()) {
			return new ResponseEntity<>(donanteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/donantes")
	public ResponseEntity<Donante> createDonante(@RequestBody Donante user) {
		try {
			Donante _usuario = donanteRepository.save(
					new Donante(user.getNaturaleza(), user.getTipodocumento(), user.getDocumento(), user.getNombrecompleto(), user.getEmail(), user.getPassword(), user.getCelular()));
			return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/donantes/{id}")
	public ResponseEntity<Donante> updateDonante(@PathVariable("id") String id, @RequestBody Donante user) {
		Optional<Donante> donanteData = donanteRepository.findById(id);

		if (donanteData.isPresent()) {
			Donante _donante = donanteData.get();
			_donante.setNaturaleza(user.getNaturaleza());
			_donante.setTipodocumento(user.getTipodocumento());
			_donante.setDocumento(user.getDocumento());
			_donante.setNombrecompleto(user.getNombrecompleto());
			_donante.setEmail(user.getEmail());
			_donante.setPassword(user.getPassword());
			_donante.setCelular(user.getCelular());
			return new ResponseEntity<>(donanteRepository.save(_donante), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/donantes/{id}")
	public ResponseEntity<HttpStatus> deleteDonantes(@PathVariable("id") String id) {
		try {
			donanteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/donantes")
	public ResponseEntity<HttpStatus> deleteAllDonantes() {
		try {
			donanteRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/donantes/{documento}")
	public ResponseEntity<List<Donante>> findByDocumento(@PathVariable("documento") String documento) {
		try {
			List<Donante> donantes = donanteRepository.findByDocumento(documento);

			if (donantes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(donantes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
