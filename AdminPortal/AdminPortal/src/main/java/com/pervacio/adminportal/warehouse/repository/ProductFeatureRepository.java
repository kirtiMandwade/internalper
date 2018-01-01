package com.pervacio.adminportal.warehouse.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.ProductFeature;
import com.pervacio.adminportal.warehouse.entities.ProductFeatureId;

public interface ProductFeatureRepository extends JpaRepository<ProductFeature, ProductFeatureId>{
	public ArrayList<ProductFeature> findAllByProductFeatureIdFeatureCd(String featureCd);

}
