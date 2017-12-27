package com.pervacio.adminportal.repository.warehouse;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String> {

}
