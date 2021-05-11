package br.com.icaroclaro.featuretoggle.dto;

import br.com.icaroclaro.featuretoggle.model.Feature;
import br.com.icaroclaro.featuretoggle.model.Toggle;

public class ToggleRequest {
	private String statusCode;
	private String description;
	
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
	public Toggle convertToToggle() {
		Toggle toggle = new Toggle(statusCode, description);
		return toggle;
	}
	public void atualizaToggle(Toggle toggle) {
		toggle.setDescription(description);
	}
}
