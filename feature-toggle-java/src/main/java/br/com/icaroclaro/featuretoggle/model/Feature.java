package br.com.icaroclaro.featuretoggle.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Feature {
	@Id
	private String name;
	private String description;
	private LocalDateTime lastDate = LocalDateTime.now();
	
	@OneToMany(mappedBy = "feature")
	private List<FeatureToggle> featureToggle;
	public Feature() {
	}
	public Feature(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public Feature(String name) {
		this.name = name;
	}
	
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
	public LocalDateTime getLastDate() {
		return lastDate;
	}
	public void setLastDate(LocalDateTime lastDate) {
		this.lastDate = lastDate;
	}
	
}
