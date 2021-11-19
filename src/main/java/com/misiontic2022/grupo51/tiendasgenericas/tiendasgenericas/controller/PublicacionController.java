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

import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.model.Publicacion;
import com.misiontic2022.grupo51.tiendasgenericas.tiendasgenericas.repository.PublicacionRepository;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PublicacionController {
	
	@Autowired
	PublicacionRepository publicacionRepository;
	
	@GetMapping("/publicaciones")
    public ResponseEntity<List<Publicacion>> getAllPublicaciones(@RequestParam(required = false) String estado) {
        try {
            List<Publicacion> publicaciones = new ArrayList<Publicacion>();
            if (estado == null) {
                publicacionRepository.findAll().forEach(publicaciones::add);
            } else {
                publicacionRepository.findByEstado(estado).forEach(publicaciones::add);
            }
            if (publicaciones.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(publicaciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/publicaciones/{id}")
	public ResponseEntity<Publicacion> getPublicacionById(@PathVariable("id") String id) {
		Optional<Publicacion> publicacionData = publicacionRepository.findById(id);

		if (publicacionData.isPresent()) {
			return new ResponseEntity<>(publicacionData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/publicaciones")
	public ResponseEntity<Publicacion> createPublicacion(@RequestBody Publicacion user) {
		try {
			Publicacion _publicacion = publicacionRepository.save(
					new Publicacion(user.getIdbeneficiario(), user.getFechacreacion(), user.getMonto(), user.getDescripcion(), user.getDuracion(), user.getEstado()));
			return new ResponseEntity<>(_publicacion, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/publicaciones/{id}")
	public ResponseEntity<Publicacion> updatePublicacion(@PathVariable("id") String id, @RequestBody Publicacion user) {
		Optional<Publicacion> publicacionData = publicacionRepository.findById(id);

		if (publicacionData.isPresent()) {
			Publicacion _publi = publicacionData.get();
			_publi.setIdbeneficiario(user.getIdbeneficiario());
			_publi.setFechacreacion(user.getFechacreacion());
			_publi.setMonto(user.getMonto());
			_publi.setDescripcion(user.getDescripcion());
			_publi.setDuracion(user.getDuracion());
			_publi.setEstado(user.getEstado());
			
			return new ResponseEntity<>(publicacionRepository.save(_publi), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/publicaciones/{id}")
	public ResponseEntity<HttpStatus> deletePublicacion(@PathVariable("id") String id) {
		try {
			publicacionRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/publicaciones")
	public ResponseEntity<HttpStatus> deleteAllPublicaciones() {
		try {
			publicacionRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/publicaciones/{estado}")
	public ResponseEntity<List<Publicacion>> findByFechacreacion(@PathVariable("fechacreacion") String fechacreacion) {
		try {
			List<Publicacion> publicaciones = publicacionRepository.findByFechacreacion(fechacreacion);

			if (publicaciones.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(publicaciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
