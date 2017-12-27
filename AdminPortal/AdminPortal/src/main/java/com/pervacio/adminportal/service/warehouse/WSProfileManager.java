package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.warehouse.entities.WSProfile;


public interface WSProfileManager
{
	public List<WSProfile> getAll();
	public void add(WSProfile wsProfile) throws Exception;
	public  void remove(WSProfile wsProfile) throws Exception;
	public void update(WSProfile wsProfile) throws Exception ;
	public ArrayList<WSProfile> getWSProfileByprofile(String profile) throws Exception;

}
