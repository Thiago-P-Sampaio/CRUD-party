package com.festa.api.Controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.festa.api.DTO.FestaDTO;
import com.festa.api.Model.FestaModel;
import com.festa.api.Repository.FestaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("api")
public class FestaController {

	
	@Autowired
	FestaRepository repo;
	
	
	@GetMapping
	public ResponseEntity getAll() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity getById(@PathVariable @Valid UUID id) {
		return ResponseEntity.ok(repo.findById(id));
	}
	
	@PostMapping ("new")
	public ResponseEntity newFesta(@RequestBody @Valid FestaDTO data) {
		FestaModel newFesta = new FestaModel(data);
		repo.save(newFesta);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping ("/{id}")
	public ResponseEntity Updt(@PathVariable UUID id, @RequestBody @Valid FestaDTO dto) {
		Optional<FestaModel> exists = repo.findById(id);
		if(exists.isPresent()) {
			FestaModel updt = exists.get();
			updt.setNome(dto.nome());
			updt.setPresente(dto.presente());
			repo.save(updt);
			return ResponseEntity.ok().build();
		}else return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping ("dell/{id}")
	public ResponseEntity delete(@PathVariable  @Valid UUID id) {
		Optional<FestaModel> exists = repo.findById(id);
		if(exists.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}else return ResponseEntity.notFound().build();
	}
}
