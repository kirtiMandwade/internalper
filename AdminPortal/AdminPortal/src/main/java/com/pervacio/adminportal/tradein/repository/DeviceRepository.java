package com.pervacio.adminportal.tradein.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pervacio.adminportal.tradein.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer>{
	public List<Device> findByModel(String model);

}
