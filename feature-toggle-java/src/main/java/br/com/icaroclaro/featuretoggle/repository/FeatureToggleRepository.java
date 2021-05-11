package br.com.icaroclaro.featuretoggle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icaroclaro.featuretoggle.model.FeatureToggle;
import br.com.icaroclaro.featuretoggle.model.FeatureToggleId;

public interface FeatureToggleRepository extends JpaRepository<FeatureToggle, FeatureToggleId>{
}
