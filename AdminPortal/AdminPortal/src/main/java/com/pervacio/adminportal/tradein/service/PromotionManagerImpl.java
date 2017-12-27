package com.pervacio.adminportal.tradein.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.tradein.dao.PromotionDao;
import com.pervacio.adminportal.tradein.entities.Promotion;

@Service
public class PromotionManagerImpl implements PromotionManager {

	@Autowired
	PromotionDao dao;

		public List<Promotion> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(Promotion promotion)throws Exception {
		// TODO Auto-generated method stub
		dao.add(promotion);
	}

	public void remove(Promotion id) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	public void update(Promotion promotion)throws Exception {
		// TODO Auto-generated method stub
		dao.update(promotion);
	};

	public ArrayList<Promotion> findAllByPromotionKeyPromoCode(String promoCode)throws Exception {
		// TODO Auto-generated method stub
		return dao.findAllByPromotionKeyPromoCode(promoCode);
	};

}
