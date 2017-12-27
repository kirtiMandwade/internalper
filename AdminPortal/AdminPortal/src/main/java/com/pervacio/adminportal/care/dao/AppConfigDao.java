package com.pervacio.adminportal.care.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.AppConfig;
import com.pervacio.adminportal.repository.care.AppConfigRepository;

@Repository
@Transactional
public class AppConfigDao {

	@Autowired
	private AppConfigRepository appRepo;

	public List<AppConfig> getAll() {
//Get All
		return appRepo.findAll();

	}

	public void add(AppConfig appConfig) throws Exception {
		appRepo.saveAndFlush(appConfig);

	}

	public void remove(AppConfig appConfig) throws Exception {
		appRepo.delete(appConfig);

	}

	public void update(AppConfig appConfig) throws Exception {
		appRepo.saveAndFlush(appConfig);

	}


	public List<AppConfig> findByConfigKey(String configKey) throws Exception {
	return	appRepo.findByConfigKey(configKey);

	}
}