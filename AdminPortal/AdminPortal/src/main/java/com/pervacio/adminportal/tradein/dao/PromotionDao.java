package com.pervacio.adminportal.tradein.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.tradein.entities.Promotion;
import com.pervacio.adminportal.tradein.repository.PromotionRepository;

@Repository
@Transactional
public class PromotionDao
{
	@Autowired
	private PromotionRepository promotionRepository;


	public List<Promotion> getAll() {
		// TODO Auto-generated method stub
		System.out.println("all promotions**********************"+promotionRepository.findAll());
		return promotionRepository.findAll();
	}


	public void add(Promotion promotion) throws Exception {
		// TODO Auto-generated method stub
		promotionRepository.saveAndFlush(promotion);
	}


	public void remove(Promotion promotion) throws Exception {
		// TODO Auto-generated method stub
		promotionRepository.delete(promotion);

	}


	public void update(Promotion promotion) throws Exception {
		// TODO Auto-generated method stub
		promotionRepository.saveAndFlush(promotion);
	}


	public ArrayList<Promotion> findAllByPromotionKeyPromoCode(String promoCode) throws Exception {
		// TODO Auto-generated method stub
		return promotionRepository.findAllByPromotionKeyPromoCode(promoCode);
	}


}