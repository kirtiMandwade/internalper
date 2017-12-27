package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.warehouse.dao.ProductFeatureDao;
import com.pervacio.adminportal.warehouse.entities.ProductFeature;


@Service
public class ProductFeatureManagerImpl implements ProductFeatureManager {

	@Autowired
	ProductFeatureDao dao;

		public List<ProductFeature> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(ProductFeature productFeature) throws Exception {
		// TODO Auto-generated method stub
		dao.add(productFeature);
	}

	public void remove(ProductFeature productFeature) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(productFeature);
	}

	public void update(ProductFeature productFeature) throws Exception {
		// TODO Auto-generated method stub
		dao.update(productFeature);
	};
	public ArrayList<ProductFeature> findAllByProductFeatureIdFeatureCd(String featureCd) throws Exception{
		return dao.findAllByProductFeatureIdFeatureCd(featureCd);
	}
}
