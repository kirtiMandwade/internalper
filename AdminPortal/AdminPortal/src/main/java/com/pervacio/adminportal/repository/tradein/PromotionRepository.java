package com.pervacio.adminportal.repository.tradein;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.tradein.entities.Promotion;
import com.pervacio.adminportal.tradein.entities.PromotionKey;

public interface PromotionRepository extends JpaRepository<Promotion, PromotionKey>{
		public ArrayList<Promotion> findAllByPromotionKeyPromoCode(String promoCode);
}
