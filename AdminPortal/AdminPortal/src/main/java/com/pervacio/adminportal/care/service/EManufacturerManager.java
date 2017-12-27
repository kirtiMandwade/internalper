package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.EManufacturer;


public interface EManufacturerManager
{
	public List<EManufacturer> getAll();
	public void add(EManufacturer EManufacturer) throws Exception;
	public  void remove(EManufacturer wsProfile) throws Exception;
	public void update(EManufacturer EManufacturer) throws Exception ;
	public ArrayList<EManufacturer> getEManufacturerByManufacturerName(String manufacturerName) throws Exception;

}