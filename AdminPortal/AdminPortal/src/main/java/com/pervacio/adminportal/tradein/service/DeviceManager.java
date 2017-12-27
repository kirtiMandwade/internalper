package com.pervacio.adminportal.tradein.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.tradein.entities.Device;


public interface DeviceManager
{
	public List<Device> getAll();
	public void add(Device device) throws Exception;
	public  void remove(Device device) throws Exception;
	public void update(Device device) throws Exception ;
	public ArrayList<Device> getDeviceByModel(String model) throws Exception;


}
