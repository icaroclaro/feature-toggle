package br.com.icaroclaro.featuretoggle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icaroclaro.featuretoggle.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String>{

}
