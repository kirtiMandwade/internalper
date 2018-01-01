package com.pervacio.adminportal.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String> {

}
