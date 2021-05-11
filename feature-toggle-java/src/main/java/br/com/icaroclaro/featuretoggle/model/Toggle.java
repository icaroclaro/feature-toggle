package br.com.icaroclaro.featuretoggle.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Toggle {
	@Id
	private String statusCode;
	private String description;
	private LocalDateTime lastDate;
	
	@OneToMany(mappedBy = "toggle")
	private List<FeatureToggle> featureToggle;
	
	public List<FeatureToggle> getFeatureToggle() {
		return featureToggle;
	}
	public void setFeatureToggle(List<FeatureToggle> featureToggle) {
		this.featureToggle = featureToggle;
	}
	public Toggle() {
	}
	public Toggle(String statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;		
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String code) {
		this.statusCode = code;
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
