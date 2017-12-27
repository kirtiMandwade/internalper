package com.pervacio.adminportal.tradein.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.tradein.dao.DevicePriceDao;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.DevicePrice;

@Service
public class DevicePriceManagerImpl implements DevicePriceManager {

	@Autowired
	DevicePriceDao dao;

		public List<DevicePrice> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(DevicePrice devicePrice) throws Exception{
		// TODO Auto-generated method stub
		try {
			dao.add(devicePrice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remove(DevicePrice devicePrice) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(devicePrice);
	}

	public void update(DevicePrice devicePrice) throws Exception{
		// TODO Auto-generated method stub
		dao.update(devicePrice);
	}

	public ArrayList<DevicePrice> getDevicePriceByDevice(Device device){
		// TODO Auto-generated method stub
		return dao.getDevicePriceByDevice(device);
		
	};

}
