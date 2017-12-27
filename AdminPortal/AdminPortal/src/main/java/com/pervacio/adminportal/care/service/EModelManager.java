package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.EModel;


public interface EModelManager
{
	public List<EModel> getAll();
	public void add(EModel EModel) throws Exception;
	public  void remove(EModel wsProfile) throws Exception;
	public void update(EModel EModel) throws Exception ;
	public ArrayList<EModel> getEModelByModel(String model) throws Exception;

}