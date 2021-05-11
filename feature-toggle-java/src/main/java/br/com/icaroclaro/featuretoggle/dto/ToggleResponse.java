package br.com.icaroclaro.featuretoggle.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.icaroclaro.featuretoggle.model.Feature;
import br.com.icaroclaro.featuretoggle.model.Toggle;

public class ToggleResponse {
	private String statusCode;
	private String description;
	
	public ToggleResponse() {
	}

	public ToggleResponse(Toggle toggle) {
		statusCode = toggle.getStatusCode();
		description = toggle.getDescription();
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
	public static List<ToggleResponse> convertToListToggleResponse(List<Toggle> toggles) {
		return toggles.stream().map(m -> new ToggleResponse(m)).collect(Collectors.toList());
	}
}
