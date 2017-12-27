package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.EDeviceTradeInBasePrice;


public interface EDeviceTradeInBasePriceManager
{
	public List<EDeviceTradeInBasePrice> getAll();
	public void add(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception;
	public  void remove(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception;
	public void update(EDeviceTradeInBasePrice EDevieDeviceTradeInBasePriceceTradeInBasePrice) throws Exception ;
	public ArrayList<EDeviceTradeInBasePrice> getEDeviceTradeInBasePriceByCompanyName(String companyName) throws Exception;

}