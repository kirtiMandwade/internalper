package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.warehouse.dao.ProfileFeatureDao;
import com.pervacio.adminportal.warehouse.entities.ProfileFeature;


@Service
public class ProfileFeatureManagerImpl implements ProfileFeatureManager {

	@Autowired
	ProfileFeatureDao dao;

		public List<ProfileFeature> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(ProfileFeature ProfileFeature) throws Exception {
		// TODO Auto-generated method stub
		dao.add(ProfileFeature);
	}

	public void remove(ProfileFeature wsProfile) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(ProfileFeature ProfileFeature) throws Exception {
		// TODO Auto-generated method stub
		dao.update(ProfileFeature);
	};
	public ArrayList<ProfileFeature> findByFeatureValue(String model) throws Exception{
		return dao.findByFeatureValue(model);
	}
}
