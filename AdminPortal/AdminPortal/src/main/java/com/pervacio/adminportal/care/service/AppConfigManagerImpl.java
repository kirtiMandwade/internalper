package com.pervacio.adminportal.care.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.AppConfigDao;
import com.pervacio.adminportal.care.entities.AppConfig;


@Service
public class AppConfigManagerImpl implements AppConfigManager {

	@Autowired
	AppConfigDao dao;

		public List<AppConfig> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(AppConfig AppConfig) throws Exception {
		// TODO Auto-generated method stub
		dao.add(AppConfig);
	}

	public void remove(AppConfig wsProfile) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(AppConfig AppConfig) throws Exception {
		// TODO Auto-generated method stub
		dao.update(AppConfig);
	};

	public List<AppConfig> findByConfigKey(String configKey) throws Exception {
		return	dao.findByConfigKey(configKey);


	}
}
