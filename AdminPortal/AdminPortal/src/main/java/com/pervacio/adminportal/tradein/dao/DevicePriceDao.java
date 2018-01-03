package com.pervacio.adminportal.tradein.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.DevicePrice;
import com.pervacio.adminportal.tradein.repository.DevicePriceRepository;

@Repository
@Transactional
public class DevicePriceDao  {
	@Autowired
	private DevicePriceRepository devicePriceRepository;

	public List<DevicePrice> getAll() {
		// TODO Auto-generated method stub
		return devicePriceRepository.findAll();
	}


	public void add(DevicePrice devicePrice) throws Exception {
		// TODO Auto-generated method stub
		devicePriceRepository.saveAndFlush(devicePrice);
	}


	public void remove(DevicePrice devicePrice) throws Exception {
		// TODO Auto-generated method stub
		devicePriceRepository.delete(devicePrice);
	}

	public void update(DevicePrice devicePrice) throws Exception {
		// TODO Auto-generated method stub
		devicePriceRepository.saveAndFlush(devicePrice);
	}
	public ArrayList<DevicePrice> getDevicePriceByDevice(Device device)
	{
		return devicePriceRepository.findByDeviceEntity(device);
	}
	
	public List<DevicePrice> findByCompanyName(String companyName)
	{
		return devicePriceRepository.findAllByDevPriceKeyCompanyName(companyName);
	}
	
}