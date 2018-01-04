package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.EManufacturer;


public interface EManufacturerManager
{
	public List<EManufacturer> getAll();
	public void add(EManufacturer eManufacturer) throws Exception;
	public  void remove(EManufacturer eManufacturer) throws Exception;
	public void update(EManufacturer eManufacturer) throws Exception ;
	public ArrayList<EManufacturer> getEManufacturerByManufacturerName(String manufacturerName) throws Exception;

}