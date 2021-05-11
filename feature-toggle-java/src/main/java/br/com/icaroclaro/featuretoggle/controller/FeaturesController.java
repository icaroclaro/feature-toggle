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

import br.com.icaroclaro.featuretoggle.dto.FeatureRequest;
import br.com.icaroclaro.featuretoggle.dto.FeatureResponse;
import br.com.icaroclaro.featuretoggle.model.Feature;
import br.com.icaroclaro.featuretoggle.repository.FeatureRepository;

@RestController
@RequestMapping("/features")
public class FeaturesController {
	@Autowired
	private FeatureRepository repository;
	
	@GetMapping
	public ResponseEntity<List<FeatureResponse>>consultaFeatures() {
		List<Feature> features = repository.findAll();
		if(features == null)
			return ResponseEntity.notFound().build();
		
		List<FeatureResponse> response = FeatureResponse.convertToListFeatureResponse(features);			
		return ResponseEntity.ok().body(response);
	}
	@GetMapping("{id}")
	public ResponseEntity<FeatureResponse>consultaFeature(@PathVariable String id) {
		Optional<Feature> features = repository.findById(id);
		if(!features.isPresent())
			return ResponseEntity.notFound().build();
			
		return ResponseEntity.ok().body(new FeatureResponse(features.get()));
	}
	@PostMapping
	@Transactional
	public ResponseEntity<FeatureResponse>insereFeature(@RequestBody FeatureRequest request, UriComponentsBuilder uriBuilder) {
		Feature feature = request.convertToFeature();
		repository.save(feature);
		
		URI uri = uriBuilder.path("/features/{id}").buildAndExpand(feature.getName()).toUri();
		return ResponseEntity.created(uri).body(new FeatureResponse(feature));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?>insereFeature(@PathVariable String id) {
		Optional<Feature> feature = repository.findById(id);
		if(!feature.isPresent())
			return ResponseEntity.notFound().build();
		
		repository.delete(feature.get());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<FeatureResponse>alteraFeature(@PathVariable String id, @RequestBody FeatureRequest request) {
		Optional<Feature> optional = repository.findById(id);
		if(!optional.isPresent())
			return ResponseEntity.notFound().build();
		Feature feature = optional.get();
		
		request.atualizaFeature(feature);
		return ResponseEntity.ok(new FeatureResponse(feature));
	}
}
