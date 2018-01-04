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

	public void add(Feature feature) throws Exception {
		// TODO Auto-generated method stub
		dao.add(feature);
	}

	public void remove(Feature feature) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(feature);
	}

	public void update(Feature feature) throws Exception {
		// TODO Auto-generated method stub
		dao.update(feature);
	}

	@Override
	public ArrayList<Feature> getFeatureByFeatureCd(String featureCd) throws Exception {
		// TODO Auto-generated method stub
		return dao.getFeatureByFeatureCd(featureCd);
	};

}
