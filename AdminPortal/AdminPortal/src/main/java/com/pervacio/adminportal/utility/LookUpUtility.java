package com.pervacio.adminportal.utility;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.service.LookUpManager;

public class LookUpUtility {
	private static final Logger logger = Logger.getLogger(LookUpUtility.class);

	@Autowired
	LookUpManager lookUpManager;

	public List<LookUp> getLookUpByLookUpType(String lookUpType) {
		List<LookUp> arrLookUp = null;

		try {
			arrLookUp = lookUpManager.getLookUpByLookUpType(lookUpType);

			logger.info("search LookUp " + arrLookUp.size());
		} catch (Exception e) {
			logger.error("error while searching LookUp " + e.getMessage());
			// e.printStackTrace();
		}

		return arrLookUp;
	}

}
