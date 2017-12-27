package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.warehouse.entities.ProfileFeature;


public interface ProfileFeatureManager
{
	public List<ProfileFeature> getAll();
	public void add(ProfileFeature profileFeature) throws Exception;
	public  void remove(ProfileFeature profileFeature) throws Exception;
	public void update(ProfileFeature profileFeature) throws Exception ;
	public ArrayList<ProfileFeature> findByFeatureValue(String featureValue) throws Exception;

}
