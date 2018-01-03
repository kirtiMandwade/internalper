package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.warehouse.dao.FeatureDao;
import com.pervacio.adminportal.warehouse.entities.Feature;


@Service
public class FeatureManagerImpl implements FeatureManager {

	@Autowired
	FeatureDao dao;

		public List<Feature> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(Feature Feature) throws Exception {
		// TODO Auto-generated method stub
		dao.add(Feature);
	}

	public void remove(Feature wsProfile) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(Feature Feature) throws Exception {
		// TODO Auto-generated method stub
		dao.update(Feature);
	}

	@Override
	public ArrayList<Feature> getFeatureByFeatureCd(String featureCd) throws Exception {
		// TODO Auto-generated method stub
		return dao.getFeatureByFeatureCd(featureCd);
	};
	
}
