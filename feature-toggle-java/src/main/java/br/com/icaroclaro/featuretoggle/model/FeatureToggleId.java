package br.com.icaroclaro.featuretoggle.model;

import java.io.Serializable;

public class FeatureToggleId implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private Feature feature;
	
	public FeatureToggleId() {}
	public FeatureToggleId(String id, Feature feature) {
		this.id = id;
		this.feature = feature;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
}
