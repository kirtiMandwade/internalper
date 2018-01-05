package com.pervacio.adminportal.lookup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.entities.LookUpKey;


public interface LookUpRepository extends JpaRepository<LookUp, Integer> {
	
	
	public List<LookUp> findByLookUpKey(LookUpKey lookUpKey);
}
