package com.pervacio.adminportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.constants.ValueType;
import com.pervacio.adminportal.model.ResponseMessage;
import com.pervacio.adminportal.service.warehouse.FeatureManager;
import com.pervacio.adminportal.service.warehouse.ProductFeatureManager;
import com.pervacio.adminportal.service.warehouse.ProfileFeatureManager;
import com.pervacio.adminportal.service.warehouse.WSProfileManager;
import com.pervacio.adminportal.service.warehouse.WorkstationFeatureManager;
import com.pervacio.adminportal.service.warehouse.WorkstationManager;
import com.pervacio.adminportal.warehouse.entities.Feature;
import com.pervacio.adminportal.warehouse.entities.ProductFeature;
import com.pervacio.adminportal.warehouse.entities.ProfileFeature;
import com.pervacio.adminportal.warehouse.entities.WSProfile;
import com.pervacio.adminportal.warehouse.entities.WorkStation;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;
import com.pervacio.adminportal.warehouse.model.FeatureBean;
import com.pervacio.adminportal.warehouse.model.ProductFeatureBean;
import com.pervacio.adminportal.warehouse.model.ProfileFeatureBean;
import com.pervacio.adminportal.warehouse.model.ProfileFeatureBeanList;
import com.pervacio.adminportal.warehouse.model.WSProfileBean;
import com.pervacio.adminportal.warehouse.model.WorkStationBean;
import com.pervacio.adminportal.warehouse.model.WorkStationFeatureBean;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	private static final Logger logger = Logger.getLogger(WarehouseController.class);

	@Autowired
private	WSProfileManager wsProfileManager;
	@Autowired
	private	FeatureManager featureManager;
	@Autowired
	private	ProductFeatureManager productFeatureManager;
	@Autowired
	private	WorkstationManager workstationManager;
	@Autowired
	private	WorkstationFeatureManager workStationFeature;
	@Autowired
	private	ProfileFeatureManager profilefeatureManager;

	@RequestMapping(value = "/profile/getall", method = RequestMethod.GET)
	public @ResponseBody List<WSProfile> getAllWSProfiles() {
		List<WSProfile> arrWSProfiles = null;
		try {
			arrWSProfiles = wsProfileManager.getAll();
			logger.info("get all WSProfiles called---- returning list "+arrWSProfiles.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("error in returning all WSProfiles "+e.getMessage());
		}

		return arrWSProfiles;

	}



	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {

		logger.info("redirecting to manageWSProfile jsp");

		return "ManageProfiles";
	}

	@RequestMapping(value = "/profile/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updatewsProfiles(@RequestBody WSProfileBean wsProfile) {
		ResponseMessage message = null;
		WSProfile entity = new WSProfile();
		BeanUtils.copyProperties(wsProfile, entity);
		try {

			wsProfileManager.update(entity);
			logger.info("WSProfile updated");

			message = new ResponseMessage("success", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("error while updating WSProfile "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/profile/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage savewsProfiles(@RequestBody WSProfileBean wsProfile) {
		WSProfile entity = new WSProfile();
		BeanUtils.copyProperties(wsProfile, entity);

		WSProfile entity2 = new WSProfile();
	/*	BeanUtils.copyProperties(WSProfile, entity2);
		entity2.setProfileFeatures(null);
	*/	ResponseMessage message = null;


//		entity.getProfileFeatures().forEach(c -> c.setWsProfiles(entity2));


		try {
			wsProfileManager.add(entity);
			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		// ResponseMessage message = new ResponseMessage("success", "200");
		return message;

	}

	@RequestMapping(value = "/profile/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removewsProfiles(@RequestBody WSProfileBean wsProfile) {
		ResponseMessage message = null;
		WSProfile entity = new WSProfile();
		BeanUtils.copyProperties(wsProfile, entity);

		try {
			wsProfileManager.remove(entity);
			logger.info("WSProfile removed");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error while removing WSProfile "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/profile/search", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<WSProfile> searchwsProfiles(@RequestBody String model) {

		List<WSProfile> arrDev = null;
		try {
			arrDev = wsProfileManager.getWSProfileByprofile(model);
			logger.info("search WSProfile  "+arrDev.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while searching WSProfile "+e.getMessage());

		}

		return arrDev;

	}

	@RequestMapping(value = "/feature/getall", method = RequestMethod.GET)
	public @ResponseBody List<Feature> getAllFeatures() {
		List<Feature> arrFeatures = null;
		try {
			arrFeatures = featureManager.getAll();
			logger.info("returning all Features "+arrFeatures.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while fetching Features "+e.getMessage());
		}

		return arrFeatures;

	}

	@RequestMapping(value = "/feature", method = RequestMethod.GET)
	public String ManageFeature() {

		logger.info("redirecting to manage Features jsp");
		return "ManageFeature";
	}

	@RequestMapping(value = "/feature/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateFeatures(@RequestBody Feature entity) {
		ResponseMessage message = null;
		try {
			featureManager.update(entity);
			logger.info("updated Features");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			logger.error("error in updating Features "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/feature/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveFeatures(@RequestBody FeatureBean feature) {
		Feature entity = new Feature();
		BeanUtils.copyProperties(feature, entity);
		ResponseMessage message = null;

		try {
			featureManager.add(entity);
			logger.info("Features added");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			logger.error("error in saving Features "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/feature/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage RemoveFeatures(@RequestBody Feature feature) {
		ResponseMessage message = null;
		Feature entity = new Feature();
		BeanUtils.copyProperties(feature, entity);

		try {
			featureManager.remove(entity);
			logger.info("Features removed");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			 			logger.error("error in updating Features "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/productfeature/getall", method = RequestMethod.GET)
	public @ResponseBody List<ProductFeature> getAllProFeature() {
		List<ProductFeature> arrProFeature = null;
		try {

			arrProFeature = productFeatureManager.getAll();

			logger.info("returning all ProFeature "+arrProFeature.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in fetching ProFeature "+e.getMessage());
		}

		return arrProFeature;

	}


	@RequestMapping(value = "/productfeature", method = RequestMethod.GET)
	public String manageProFeature() {

		logger.info("redirecting to manage ProFeature");
		return "ManageProductFeature";
	}

	@RequestMapping(value = "/productfeature/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateProFeature(@RequestBody ProductFeature entity) {
		ResponseMessage message = null;

		try {
			productFeatureManager.update(entity);
			logger.info("ProFeature updated");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error in updating ProFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "200");
		}

		return message;

	}

	@RequestMapping(value = "/productfeature/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveProFeature(@RequestBody ProductFeatureBean productFeature) {
		ProductFeature entity = new ProductFeature();
		BeanUtils.copyProperties(productFeature, entity);
		ResponseMessage message = null;

		try {
			productFeatureManager.add(entity);
			message = new ResponseMessage("success", "200");
			logger.info("ProFeature added");


		} catch (Exception e) {
			logger.error("error in saving ProFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "200");
		}
		return message;

	}

	@RequestMapping(value = "/productfeature/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage RemoveProFeature(@RequestBody ProductFeatureBean productfeature) {
		ResponseMessage message = null;
		ProductFeature entity = new ProductFeature();
		BeanUtils.copyProperties(productfeature, entity);

		try {
			productFeatureManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("ProFeature removed");

		} catch (Exception e) {
			logger.error("error in removing ProFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}




	/*WorkStation Started*/




	@RequestMapping(value = "/workstation/getall", method = RequestMethod.GET)
	public @ResponseBody List<WorkStation> getAllWorkStation() {
		List<WorkStation> arrWorkStationFeatures = null;
		try {
			arrWorkStationFeatures = workstationManager.getAll();
			logger.info("returning all Workstation "+arrWorkStationFeatures.size());

		} catch (Exception e) {
e.printStackTrace();
logger.error("error in returning Workstation "+e.getMessage());
		}

		return arrWorkStationFeatures;

	}

	@RequestMapping(value = "/workstation", method = RequestMethod.GET)
	public String manageWorkstation() {

		logger.info("returning to manage Workstation");
		return "ManageWorkstation";
	}

	@RequestMapping(value = "/workstation/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateWorkstation(@RequestBody WorkStation workstation) {
		ResponseMessage message;
		WorkStation entity = new WorkStation();
		BeanUtils.copyProperties(workstation, entity);

		try {
			workstationManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("Workstation updated");

		} catch (Exception e) {
			logger.error("error in updating Workstation "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/workstation/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveWorkstation(@RequestBody WorkStationBean workstation) {
		WorkStation entity = new WorkStation();
		BeanUtils.copyProperties(workstation, entity);
		ResponseMessage message;
		try {
			workstationManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("Workstation added");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error in saving Workstation "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/workstation/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeWorkstation(@RequestBody WorkStationBean workstation) {
		ResponseMessage message;
		WorkStation entity = new WorkStation();
		BeanUtils.copyProperties(workstation, entity);

		try {
			workstationManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("Workstation removed");

		} catch (Exception e) {
			logger.error("error in removing Workstation "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}




/*--WorkStation Feature Started--*/




	@RequestMapping(value = "/workstationfeature/getall", method = RequestMethod.GET)
	public @ResponseBody List<WorkStationFeature> getAllWorkStationFeatures() {
		List<WorkStationFeature> arrWorkStationFeatures = null;
		try {
			arrWorkStationFeatures = workStationFeature.getAll();
			logger.info("returning all WorkStationFeature "+arrWorkStationFeatures.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning WorkStationFeature "+e.getMessage());
		}

		return arrWorkStationFeatures;

	}

	@RequestMapping(value = "/workstationfeature", method = RequestMethod.GET)
	public String manageWorkStationFeature() {

		logger.info("returning to manage WorkStationFeature");
		return "ManageWorkstationFeature";
	}

	@RequestMapping(value = "/workstationfeature/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateWorkStationFeature(@RequestBody WorkStationFeatureBean workstationfeature) {
		ResponseMessage message;
		WorkStationFeature entity = new WorkStationFeature();
		BeanUtils.copyProperties(workstationfeature, entity);

		try {
			workStationFeature.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("workstationfeature updated");

		} catch (Exception e) {
			logger.error("error in updating WorkStationFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/workstationfeature/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveWorkStationFeature(@RequestBody WorkStationFeatureBean workstationfeature) {
		WorkStationFeature entity = new WorkStationFeature();
		BeanUtils.copyProperties(workstationfeature, entity);
		ResponseMessage message;
		try {
			workStationFeature.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("WorkStationFeature added");

		} catch (Exception e) {
			logger.error("error in saving WorkStationFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/workstationfeature/saveall", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage Save_work_station_feature_list(@RequestBody ArrayList<WorkStationFeatureBean> workstationfeature) {
		System.out.println("In Controller"+workstationfeature.size());
		ArrayList<WorkStationFeature> entity = new ArrayList<WorkStationFeature>();
		//BeanUtils.copyProperties(WorkStationFeature, entity);


		for(WorkStationFeatureBean wrkFeature: workstationfeature) {
			WorkStationFeature wsf=new WorkStationFeature();
			//wsf.setCreationDttm(wrkFeature.getCreationDttm());
			wsf.setFea(wrkFeature.getFeature());
			System.out.println(wrkFeature.getFeatureValue());
			System.out.println(wrkFeature.getFeature());
			wsf.setFeatureValue(wrkFeature.getFeatureValue());
		//	wsf.setLastUpdatedDttm(lastUpdatedDttm);
			entity.add(wsf);

		}
		ResponseMessage message;
		try {
			workStationFeature.addWorkStationFeatureList(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("WorkStationFeature added");

		} catch (Exception e) {
			logger.error("error in saving WorkStationFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}



	@RequestMapping(value = "/workstationfeature/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeWorkStationFeature(@RequestBody WorkStationFeatureBean workstationfeature) {
		ResponseMessage message;
		WorkStationFeature entity = new WorkStationFeature();
		BeanUtils.copyProperties(workstationfeature, entity);

		try {
			workStationFeature.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("workstationfeature removed");

		} catch (Exception e) {
			logger.error("error in removing WorkStationFeature "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}



	@RequestMapping(value = "/GetDeductionType", method = RequestMethod.GET)
	public @ResponseBody DeductionType[] GetDeductionType() {
		logger.info("returning deduction types");

		return DeductionType.values();

	}


	@RequestMapping(value = "/GetValueType", method = RequestMethod.GET)
	public @ResponseBody  ValueType[] GetValueType() {
		logger.info("returning value types"+ValueType.values());
		return ValueType.values();

	}



	/*----*/





	@RequestMapping(value = "/profilefeature/getAllProfileFeatures", method = RequestMethod.GET)
	public @ResponseBody List<ProfileFeature> getAllProfileFeatures() {
		List<ProfileFeature> arrProfileFeatures = null;
		try {
			arrProfileFeatures = profilefeatureManager.getAll();
			logger.info("returning all ProfileFeatures "+arrProfileFeatures.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning ProfileFeatures "+e.getMessage());
		}

		return arrProfileFeatures;

	}

	@RequestMapping(value = "/profilefeature", method = RequestMethod.GET)
	public String manageProfileFeature() {

		logger.info("returning to manage ProfileFeatures");
		return "ManageProfileFeature";
	}

	@RequestMapping(value = "/profilefeature/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateProfileFeature(@RequestBody ProfileFeatureBeanList profilefeature) {
		ResponseMessage message;
		ProfileFeature entity = new ProfileFeature();
		BeanUtils.copyProperties(profilefeature, entity);

		try {
			profilefeatureManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("ProfileFeatures updated");

		} catch (Exception e) {
			logger.error("error in updating ProfileFeatures "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/profilefeature/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveProfileFeature(@RequestBody ProfileFeatureBeanList saveProFeatBean) {
/*		ProfileFeature entity = new ProfileFeature();
		BeanUtils.copyProperties(ProfileFeature, entity);

*/	ResponseMessage message = null;

		for(ProfileFeatureBean feature: saveProFeatBean.getFea()) {
	ProfileFeature entity = new ProfileFeature();

	BeanUtils.copyProperties(feature, entity);
	entity.setWsProfiles(saveProFeatBean.getWsProfiles());
	try {
		profilefeatureManager.add(entity);
		message = new ResponseMessage("success: ", "200");
		logger.info("ProfileFeatures added");

	} catch (Exception e) {
		logger.error("error in saving ProfileFeatures "+e.getMessage());
		message = new ResponseMessage("error: " + e.getMessage(), "400");
	}
}


		return message;

		}

	@RequestMapping(value = "/profilefeature/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeProfileFeature(@RequestBody ProfileFeatureBeanList profilefeature) {
		ResponseMessage message;
		ProfileFeature entity = new ProfileFeature();
		BeanUtils.copyProperties(profilefeature, entity);

		try {
			profilefeatureManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("ProfileFeatures removed");

		} catch (Exception e) {
			logger.error("error in removing ProfileFeatures "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}
	}


