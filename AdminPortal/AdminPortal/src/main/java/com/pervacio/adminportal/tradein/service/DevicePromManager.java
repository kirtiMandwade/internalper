package com.pervacio.adminportal.tradein.service;

import java.util.List;

import com.pervacio.adminportal.tradein.entities.DevicePromotion;

public interface DevicePromManager
{
	public List<DevicePromotion> getAll();
	public void add(DevicePromotion devicePromotion)throws Exception;
	public  void remove(DevicePromotion devicePromotion)throws Exception;
	public void update(DevicePromotion devicePromotion) throws Exception;

}
