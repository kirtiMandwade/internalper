package com.pervacio.adminportal.lookup.service;

import java.util.List;

import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.entities.LookUpKey;

public interface LookUpManager {
	public List<LookUp> findByLookUpKey(LookUpKey lookUpKey)throws Exception;
}
