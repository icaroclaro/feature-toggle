package br.com.icaroclaro.featuretoggle.dto;

import br.com.icaroclaro.featuretoggle.model.Feature;

public class FeatureRequest {
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String featureCode) {
		this.name = featureCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Feature convertToFeature() {
		Feature feature = new Feature(name, description);
		return feature;
	}
	public void atualizaFeature(Feature feature) {
		feature.setDescription(description);
	}
}
