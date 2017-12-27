package com.pervacio.adminportal.tradein.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.tradein.dao.DevicePromDao;
import com.pervacio.adminportal.tradein.entities.DevicePromotion;


@Service
public class DevicePromManagerImpl implements DevicePromManager {

	@Autowired
	DevicePromDao dao;

		public List<DevicePromotion> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(DevicePromotion devicePromotion) throws Exception{
		// TODO Auto-generated method stub
		dao.add(devicePromotion);
	}

	public void remove(DevicePromotion devicePromotion)throws Exception {
		// TODO Auto-generated method stub
		dao.remove(devicePromotion);
	}

	public void update(DevicePromotion devicePromotion)throws Exception {
		// TODO Auto-generated method stub
		dao.update(devicePromotion);
	}



}
