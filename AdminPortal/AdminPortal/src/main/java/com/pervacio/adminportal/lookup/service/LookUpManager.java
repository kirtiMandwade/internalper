package com.pervacio.adminportal.lookup.service;

import java.util.List;

import com.pervacio.adminportal.lookup.entities.LookUp;

public interface LookUpManager {
	public List<LookUp> getLookUpByLookUpType(String lookUpType)throws Exception;
}
