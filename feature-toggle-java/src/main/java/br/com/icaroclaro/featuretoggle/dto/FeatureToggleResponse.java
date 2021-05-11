package br.com.icaroclaro.featuretoggle.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.icaroclaro.featuretoggle.model.Feature;
import br.com.icaroclaro.featuretoggle.model.FeatureToggle;
import br.com.icaroclaro.featuretoggle.model.Toggle;

public class FeatureToggleResponse {
	private String id;
	private String feature;
	private String toggle;
	
	private FeatureToggleResponse() {}
	private FeatureToggleResponse(String id, String feature) {
		this.id = id;
		this.feature = feature;
	}
	public FeatureToggleResponse(FeatureToggle m) {
		this.id = m.getId();
		this.feature = m.getFeature().getName();
		this.toggle = m.getToggle().getStatusCode();
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
	public static List<FeatureToggleResponse> convertToListFeatureToggleResponse(List<FeatureToggle> featureToggles) {
		return featureToggles.stream().map(m -> new FeatureToggleResponse(m)).collect(Collectors.toList());
	}
}
