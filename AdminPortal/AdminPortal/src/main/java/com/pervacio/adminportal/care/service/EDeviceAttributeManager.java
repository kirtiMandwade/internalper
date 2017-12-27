package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.EDeviceAttribute;


public interface EDeviceAttributeManager
{
	public List<EDeviceAttribute> getAll();
	public void add(EDeviceAttribute eDeviceAttribute) throws Exception;
	public  void remove(EDeviceAttribute eDeviceAttribute) throws Exception;
	public void update(EDeviceAttribute eDeviceAttribute) throws Exception ;
	public ArrayList<EDeviceAttribute> getEDeviceAttributeByAttributeName(String attributeName) throws Exception;

}