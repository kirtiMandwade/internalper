package com.pervacio.adminportal.care.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.care.entities.EDeviceTradeInBasePrice;

public interface EDeviceTradeInBasePriceRepository extends JpaRepository<EDeviceTradeInBasePrice, Integer>{

	public ArrayList<EDeviceTradeInBasePrice> findAllByCompanyCompanyName(String companyName)throws Exception;
	
}
