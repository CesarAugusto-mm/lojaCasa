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

import com.loja.model.Casa;
import com.loja.repository.casaRepository;



@RestController
@RequestMapping("/Casa")
public class CasaController {
	
	@Autowired
	private casaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Casa>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Casa> getById(@PathVariable int id) {
		Optional<Casa> casaExist = repository.findById(id);
		
		if (casaExist.isEmpty())
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.ok(casaExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Casa> post(@RequestBody Casa casa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(casa));
	}
	
	@PutMapping
	public ResponseEntity<Casa> put(@RequestBody Casa casa) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(casa));
	}
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<?> delete(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
		}
	
}