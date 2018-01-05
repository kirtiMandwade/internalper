package com.pervacio.adminportal.care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.AppConfig;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.Promotion;

public interface AppConfigRepository extends JpaRepository<AppConfig, Integer>{
	public List<AppConfig> findByConfigKey(String configKey);
	public List<AppConfig> findAllByCompanyCompanyName(String  companyName);

}
