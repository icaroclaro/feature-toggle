package br.com.icaroclaro.featuretoggle.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.icaroclaro.featuretoggle.dto.ToggleRequest;
import br.com.icaroclaro.featuretoggle.dto.ToggleResponse;
import br.com.icaroclaro.featuretoggle.model.Toggle;
import br.com.icaroclaro.featuretoggle.repository.ToggleRepository;

@RestController
@RequestMapping("/toggles")
public class ToggleController {
	@Autowired
	private ToggleRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ToggleResponse>>consultaToggles() {
		List<Toggle> toggles = repository.findAll();
		if(toggles == null)
			return ResponseEntity.notFound().build();
		
		List<ToggleResponse> response = ToggleResponse.convertToListToggleResponse(toggles);			
		return ResponseEntity.ok().body(response);
	}
	@GetMapping("{id}")
	public ResponseEntity<ToggleResponse>consultaToggle(@PathVariable String id) {
		Optional<Toggle> toggles = repository.findById(id);
		if(!toggles.isPresent())
			return ResponseEntity.notFound().build();
			
		return ResponseEntity.ok().body(new ToggleResponse(toggles.get()));
	}
	@PostMapping
	@Transactional
	public ResponseEntity<ToggleResponse>insereToggle(@RequestBody ToggleRequest request, UriComponentsBuilder uriBuilder) {
		Toggle toggle = request.convertToToggle();
		repository.save(toggle);
		
		URI uri = uriBuilder.path("/toggle/{id}").buildAndExpand(toggle.getStatusCode()).toUri();
		return ResponseEntity.created(uri).body(new ToggleResponse(toggle));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?>insereToggle(@PathVariable String id) {
		Optional<Toggle> toggle = repository.findById(id);
		if(!toggle.isPresent())
			return ResponseEntity.notFound().build();
		
		repository.delete(toggle.get());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<ToggleResponse>alteraToggle(@PathVariable String id, @RequestBody ToggleRequest request) {
		Optional<Toggle> optional = repository.findById(id);
		if(!optional.isPresent())
			return ResponseEntity.notFound().build();
		Toggle toggle = optional.get();
		
		request.atualizaToggle(toggle);
		return ResponseEntity.ok(new ToggleResponse(toggle));
	}
}
