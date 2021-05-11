package br.com.icaroclaro.featuretoggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class FeatureToggleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureToggleApplication.class, args);
	}


}
