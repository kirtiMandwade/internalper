package com.pervacio.adminportal.tradein.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.DevicePrice;

public interface DevicePriceManager
{
	public List<DevicePrice> getAll();
	public void add(DevicePrice devicePrice)throws Exception;
	public  void remove(DevicePrice devicePrice)throws Exception;
	public void update(DevicePrice devicePrice)throws Exception ;
	public ArrayList<DevicePrice> getDevicePriceByDevice(Device device);
	
	public List<DevicePrice> findByCompanyName(String companyName);


}
