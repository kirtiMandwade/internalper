package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.warehouse.entities.Feature;


public interface FeatureManager
{
	public List<Feature> getAll();
	public void add(Feature feature) throws Exception;
	public  void remove(Feature feature) throws Exception;
	public void update(Feature feature) throws Exception ;
//	public ArrayList<Feature> getFeatureByModel(String model) throws Exception;

}
