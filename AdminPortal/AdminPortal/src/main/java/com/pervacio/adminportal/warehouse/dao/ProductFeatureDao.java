package com.pervacio.adminportal.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.warehouse.entities.ProductFeature;
import com.pervacio.adminportal.warehouse.repository.ProductFeatureRepository;

@Repository
@Transactional
public class ProductFeatureDao
{
	@Autowired
	private ProductFeatureRepository productFeatureRepository;



	public List<ProductFeature> getAll() {
		// TODO Auto-generated method stub
		return productFeatureRepository.findAll();
	}


	public void add(ProductFeature productFeature) throws Exception {
		// TODO Auto-generated method stub
		productFeatureRepository.saveAndFlush(productFeature);
	}


	public void remove(ProductFeature productFeature) throws Exception {
		// TODO Auto-generated method stub
		productFeatureRepository.delete(productFeature);
	}


	public void update(ProductFeature productFeature) throws Exception {
		// TODO Auto-generated method stub
		productFeatureRepository.saveAndFlush(productFeature);
	}


	public ArrayList<ProductFeature> findAllByProductFeatureIdFeatureCd(String featureCd) throws Exception {
		// TODO Auto-generated method stu
		return productFeatureRepository.findAllByProductFeatureIdFeatureCd(featureCd);
	}
}