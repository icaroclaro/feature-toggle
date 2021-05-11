package br.com.icaroclaro.featuretoggle.dto;

import br.com.icaroclaro.featuretoggle.model.Feature;
import br.com.icaroclaro.featuretoggle.model.FeatureToggle;

public class FeatureToggleRequest {
	private String id;
	private String feature;
	
	private FeatureToggleRequest() {}
	private FeatureToggleRequest(String id, String feature) {
		this.id = id;
		this.feature = feature;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public FeatureToggle convertToFeature() {
		FeatureToggle featureToggle = new FeatureToggle(id, feature);
		return featureToggle;
	}
}
