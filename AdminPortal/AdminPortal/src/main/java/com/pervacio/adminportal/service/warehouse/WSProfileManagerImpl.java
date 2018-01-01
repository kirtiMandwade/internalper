package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.warehouse.dao.WSProfileDao;
import com.pervacio.adminportal.warehouse.entities.ProfileFeature;
import com.pervacio.adminportal.warehouse.entities.ProfileFeatureId;
import com.pervacio.adminportal.warehouse.entities.WSProfile;

@Service
public class WSProfileManagerImpl implements WSProfileManager {

	@Autowired
	WSProfileDao dao;

	public List<WSProfile> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(WSProfile wsProfile) throws Exception {


		for (ProfileFeature feat : wsProfile.getProfileFeatures()) {
			ProfileFeatureId featureId = new ProfileFeatureId();
			featureId.setFeatureCd(feat.getFeature().getFeatureCd());
			featureId.setWsProfileId(wsProfile.getWsProfileId());
			feat.setProfileFeatureId(featureId);

		}
		// WSProfile.getProfileFeatures().forEach(c -> c.setWsProfiles(WSProfile));
		dao.add(wsProfile);
	}

	public void remove(WSProfile wsProfile) throws Exception {
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(WSProfile wsProfile) throws Exception {

		for (ProfileFeature feat : wsProfile.getProfileFeatures()) {
			ProfileFeatureId featureId = new ProfileFeatureId();
			featureId.setFeatureCd(feat.getFeature().getFeatureCd());
			featureId.setWsProfileId(wsProfile.getWsProfileId());
			feat.setProfileFeatureId(featureId);

		}
		dao.update(wsProfile);
	};

	public ArrayList<WSProfile> getWSProfileByprofile(String profile) throws Exception {
		return dao.getWSProfileByprofile(profile);
	}
}
