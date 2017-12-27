package com.pervacio.adminportal.tradein.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.tradein.entities.Promotion;


public interface PromotionManager
{
	public List<Promotion> getAll();
	public void add(Promotion promotion)throws Exception;
	public  void remove(Promotion promotion)throws Exception;
	public void update(Promotion promotion)throws Exception ;
	public ArrayList<Promotion> findAllByPromotionKeyPromoCode(String promoCode) throws Exception;
}
