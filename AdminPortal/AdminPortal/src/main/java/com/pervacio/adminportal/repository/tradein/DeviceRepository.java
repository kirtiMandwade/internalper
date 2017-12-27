package com.pervacio.adminportal.repository.tradein;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.tradein.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer>{
	public List<Device> findByModel(String model);

}
