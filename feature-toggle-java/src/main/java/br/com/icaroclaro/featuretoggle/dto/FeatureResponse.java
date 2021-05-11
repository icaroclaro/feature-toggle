package br.com.icaroclaro.featuretoggle.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.icaroclaro.featuretoggle.model.Feature;

public class FeatureResponse {
	private String name;
	private String description;
	private LocalDateTime lastDate = LocalDateTime.now();
	
	public FeatureResponse() {
	}

	public FeatureResponse(Feature feature) {
		name = feature.getName();
		description = feature.getDescription();
		lastDate = feature.getLastDate();
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
	public static List<FeatureResponse> convertToListFeatureResponse(List<Feature> features){
		return features.stream().map(m -> new FeatureResponse(m)).collect(Collectors.toList());
	}
}