package com.pervacio.adminportal.repository.tradein;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.tradein.entities.DevPriceKey;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.DevicePrice;

public interface DevicePriceRepository extends JpaRepository<DevicePrice, DevPriceKey> {

	public ArrayList<DevicePrice> findByDeviceEntity(Device deviceEntity);
}
