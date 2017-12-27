package com.pervacio.adminportal.tradein.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.repository.tradein.DeviceRepository;
import com.pervacio.adminportal.tradein.entities.Device;

@Repository
@Transactional
public class DeviceDao
{
	@Autowired
	private DeviceRepository deviceRepository;


	public List<Device> getAll() {
		// TODO Auto-generated method stub

		return deviceRepository.findAll();
	}


	public void add(Device device) throws Exception {
		// TODO Auto-generated method stub
		deviceRepository.saveAndFlush(device);
	}


	public void remove(Device device) throws Exception {
		// TODO Auto-generated method stub
		deviceRepository.delete(device);
	}


	public void update(Device device) throws Exception {
		// TODO Auto-generated method stub
		deviceRepository.saveAndFlush(device);
	}


	public ArrayList<Device> getDeviceByModel(String model) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Device>) deviceRepository.findByModel(model);
	}


}