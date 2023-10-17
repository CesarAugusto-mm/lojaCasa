package com.loja.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.model.Imobiliaria;
import com.loja.repository.imobiliariaRepository;

@RestController
@RequestMapping("/imobiliaria")
public class imoliliariaController {	
	
	@Autowired
	private imobiliariaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Imobiliaria>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
		
	@GetMapping("/id")
	public ResponseEntity<Imobiliaria> getById(@PathVariable int id) {
		Optional<Imobiliaria> imobiliariaExist = repository.findById(id);
		
		if(imobiliariaExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(imobiliariaExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Imobiliaria> post(@RequestBody Imobiliaria imobiliaria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(imobiliaria));
			
	}
	
	@PutMapping
	public ResponseEntity<Imobiliaria> put(@RequestBody Imobiliaria imobiliaria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save (imobiliaria));
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<?> delete(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
