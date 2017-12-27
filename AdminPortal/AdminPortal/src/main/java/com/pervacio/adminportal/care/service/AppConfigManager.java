package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.AppConfig;


public interface AppConfigManager
{
	public List<AppConfig> getAll();
	public void add(AppConfig appConfig) throws Exception;
	public  void remove(AppConfig appConfig) throws Exception;
	public void update(AppConfig appConfig) throws Exception ;
	public List<AppConfig> findByConfigKey(String configKey) throws Exception;
}
