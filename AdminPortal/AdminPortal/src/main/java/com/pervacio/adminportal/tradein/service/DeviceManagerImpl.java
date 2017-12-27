package com.pervacio.adminportal.tradein.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.tradein.dao.DeviceDao;
import com.pervacio.adminportal.tradein.entities.Device;


@Service
public class DeviceManagerImpl implements DeviceManager {

	@Autowired
	DeviceDao dao;

		public List<Device> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(Device device) throws Exception {
		// TODO Auto-generated method stub
		dao.add(device);
	}

	public void remove(Device device) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(device);
	}

	public void update(Device device) throws Exception {
		// TODO Auto-generated method stub
		dao.update(device);
	};
	public ArrayList<Device> getDeviceByModel(String model) throws Exception{
		return dao.getDeviceByModel(model);
	}
}
