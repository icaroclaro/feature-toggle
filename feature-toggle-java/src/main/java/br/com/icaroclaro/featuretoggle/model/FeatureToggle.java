package br.com.icaroclaro.featuretoggle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@IdClass(FeatureToggleId.class)
public class FeatureToggle {
	@Id
	private String id;
	@Id
	@ManyToOne
    @JoinColumn(name = "feature", updatable = false)	
	private Feature feature;
	@ManyToOne
    @JoinColumn(name = "toggle", updatable = false)	
	private Toggle toggle;
	
	public FeatureToggle() {}
	public FeatureToggle(String id, String feature) {
		this.id=id;
		this.feature = new Feature(feature);
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
	public Toggle getToggle() {
		return toggle;
	}
	public void setToggle(Toggle toggle) {
		this.toggle = toggle;
	}
}
