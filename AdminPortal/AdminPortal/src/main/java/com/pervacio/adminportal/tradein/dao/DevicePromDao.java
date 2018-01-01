package com.pervacio.adminportal.tradein.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.tradein.entities.DevicePromotion;
import com.pervacio.adminportal.tradein.repository.DevicePromotionRepository;

@Repository
@Transactional
public class DevicePromDao
{
	@Autowired
	private DevicePromotionRepository devicePromotionRepository;


	public List<DevicePromotion> getAll() {
		// TODO Auto-generated method stub
		return devicePromotionRepository.findAll();
	}


	public void add(DevicePromotion devicePromotion) throws Exception {
		// TODO Auto-generated method stub
		devicePromotionRepository.saveAndFlush(devicePromotion);
	}


	public void remove(DevicePromotion devicePromotion) throws Exception {
		// TODO Auto-generated method stub
		devicePromotionRepository.delete(devicePromotion);
	}


	public void update(DevicePromotion devicePromotion) throws Exception {
		// TODO Auto-generated method stub
		devicePromotionRepository.saveAndFlush(devicePromotion);
	}


}