package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.AppConfig;
import com.pervacio.adminportal.care.repository.AppConfigRepository;

@Repository
@Transactional
public class AppConfigDao {

	@Autowired
	private AppConfigRepository appRepo;

	public List<AppConfig> getAll() {
		return appRepo.findAll();

	}

	public void add(AppConfig appConfig) throws Exception {
		appRepo.saveAndFlush(appConfig);

	}

	public void addAll(ArrayList<AppConfig> arrappConfig) throws Exception {
		appRepo.save(arrappConfig);

	}

	public void remove(AppConfig appConfig) throws Exception {
		appRepo.delete(appConfig);

	}

	public void update(AppConfig appConfig) throws Exception {
		appRepo.saveAndFlush(appConfig);

	}

	public List<AppConfig> findByConfigKey(String configKey) throws Exception {
		return appRepo.findByConfigKey(configKey);
	}

	public List<AppConfig> findAllByCompanyCompanyName(String companyName) {
		return appRepo.findAllByCompanyCompanyName(companyName);
	}
}
