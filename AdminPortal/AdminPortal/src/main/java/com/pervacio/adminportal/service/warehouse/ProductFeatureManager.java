package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.warehouse.entities.ProductFeature;


public interface ProductFeatureManager
{
	public List<ProductFeature> getAll();
	public void add(ProductFeature productFeature) throws Exception;
	public  void remove(ProductFeature productFeature) throws Exception;
	public void update(ProductFeature productFeature) throws Exception ;
	public ArrayList<ProductFeature> findAllByProductFeatureIdFeatureCd(String featureCd) throws Exception;

}
