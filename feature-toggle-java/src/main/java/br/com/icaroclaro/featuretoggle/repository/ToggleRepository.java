package br.com.icaroclaro.featuretoggle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icaroclaro.featuretoggle.model.Toggle;

public interface ToggleRepository extends JpaRepository<Toggle, String>{

}
