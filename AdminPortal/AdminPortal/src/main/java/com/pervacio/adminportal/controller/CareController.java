package com.pervacio.adminportal.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pervacio.adminportal.care.entities.AppConfig;
import com.pervacio.adminportal.care.entities.DiagIssuesFlow;
import com.pervacio.adminportal.care.entities.DiagTest;
import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;
import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.care.entities.EDeviceAttribute;
import com.pervacio.adminportal.care.entities.EDeviceTradeInBasePrice;
import com.pervacio.adminportal.care.entities.EManufacturer;
import com.pervacio.adminportal.care.entities.EModel;
import com.pervacio.adminportal.care.entities.EUser;
import com.pervacio.adminportal.care.model.AppConfigBean;
import com.pervacio.adminportal.care.model.DiagIssuesFlowBean;
import com.pervacio.adminportal.care.model.DiagTestBean;
import com.pervacio.adminportal.care.model.DiagTestCompanyMapBean;
import com.pervacio.adminportal.care.model.ECompanyBean;
import com.pervacio.adminportal.care.model.EDeviceAttributeBean;
import com.pervacio.adminportal.care.model.EDeviceTradeInBasePriceBean;
import com.pervacio.adminportal.care.model.EManufacturerBean;
import com.pervacio.adminportal.care.model.EModelBean;
import com.pervacio.adminportal.care.model.EUserBean;
import com.pervacio.adminportal.care.service.AppConfigManager;
import com.pervacio.adminportal.care.service.DiagIssueFlowManager;
import com.pervacio.adminportal.care.service.DiagTestCompanyMapManager;
import com.pervacio.adminportal.care.service.DiagTestManager;
import com.pervacio.adminportal.care.service.ECompanyManager;
import com.pervacio.adminportal.care.service.EDeviceAttributeManager;
import com.pervacio.adminportal.care.service.EDeviceTradeInBasePriceManager;
import com.pervacio.adminportal.care.service.EManufacturerManager;
import com.pervacio.adminportal.care.service.EModelManager;
import com.pervacio.adminportal.care.service.EUserManager;
import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.constants.ValueType;
import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.service.LookUpManager;
import com.pervacio.adminportal.model.ResponseMessage;

@Controller
@RequestMapping("/care")
public class CareController {
	private static final Logger logger = Logger.getLogger(CareController.class);

	@Autowired
	private AppConfigManager appConfigManager;
	@Autowired
	private DiagIssueFlowManager diagIssueFlowManager;
	@Autowired
	private DiagTestManager diagTestManager;
	@Autowired
	private DiagTestCompanyMapManager diagTestCompanyMapManager;
	@Autowired
	private EModelManager eModelManager;
	@Autowired
	private EManufacturerManager eManufacturerManager;
	@Autowired
	private ECompanyManager eCompanyManager;
	@Autowired
	private EDeviceAttributeManager eDeviceAttributeManager;
	@Autowired
	private EDeviceTradeInBasePriceManager eDeviceTradeInBasePriceManager;
	@Autowired
	private EUserManager eUserManager;

	@Autowired
	LookUpManager lookUpManager;


	@RequestMapping(value="/lookup/getall",method=RequestMethod.GET)
	public @ResponseBody List<LookUp> getAllLookUp(@RequestParam String lookUpType)
	{
		System.out.println("Method is called---------------------------------------------------------------------------------------------");
		//String lookUpType="PRODUCTCD";
		List<LookUp> arrLookUp=null;

		try {
			arrLookUp=lookUpManager.findAllByLookUpKeyLookUpType(lookUpType);
			System.out.println("ALLLLLLLLLLLLLLLLlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll"+" " +arrLookUp.size());
			logger.debug("get all LookUp by Lookuptype");

		} catch (Exception e) {
			logger.debug("error while getting all LookUp by Lookuptype "+e.getMessage());
			e.printStackTrace();
		}

		return arrLookUp;

	}


	@RequestMapping(value = "/appConfig/getall", method = RequestMethod.GET)
	public @ResponseBody List<AppConfig> getAllAppConfigs() {
		//fetching app config details
		List<AppConfig> arrAppConfigs = null;
		try {
			arrAppConfigs = appConfigManager.getAll();
			logger.info("get all AppConfigs called---- returning list "+arrAppConfigs.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning all AppConfigs "+e.getMessage());
		}

		return arrAppConfigs;

	}



	@RequestMapping(value = "/appConfig", method = RequestMethod.GET)
	public String appConfig() {

		logger.info("redirecting to manageAppConfig jsp");

		return "ManageAppConfig";
	}

	@RequestMapping(value = "/appConfig/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateAppConfig(@RequestBody AppConfigBean appConfig) {
		ResponseMessage message = null;
		AppConfig entity = new AppConfig();
		BeanUtils.copyProperties(appConfig, entity);
		try {

			appConfigManager.update(entity);
			logger.info("AppConfig updated");

			message = new ResponseMessage("success", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("error while updating AppConfig "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/appConfig/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveAppConfig(@RequestBody AppConfigBean appConfig) {
		AppConfig entity = new AppConfig();
		BeanUtils.copyProperties(appConfig, entity);
		ResponseMessage message = null;

		try {
			appConfigManager.add(entity);
			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		// ResponseMessage message = new ResponseMessage("success", "200");
		return message;

	}

	@RequestMapping(value = "/appConfig/saveAll", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveAllAppConfig(@RequestBody ArrayList<AppConfigBean> arrAppConfig) {
		ArrayList<AppConfig> arrEntity = new ArrayList<AppConfig>();
		for(AppConfigBean appConfig:arrAppConfig) {
			AppConfig entity = new   AppConfig();
			BeanUtils.copyProperties(appConfig, entity);
		arrEntity.add(entity);
		}
		ResponseMessage message = null;

		try {
			appConfigManager.addAll(arrEntity);
			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		// ResponseMessage message = new ResponseMessage("success", "200");
		return message;

	}

	@RequestMapping(value = "/appConfig/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeAppConfigs(@RequestBody AppConfigBean appConfig) {
		ResponseMessage message = null;
		AppConfig entity = new AppConfig();
		BeanUtils.copyProperties(appConfig, entity);

		try {
			appConfigManager.remove(entity);
			logger.info("AppConfig removed");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error while removing AppConfig "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/appConfig/search", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<AppConfig> searchAppConfigs(@RequestBody String companyName) {

		List<AppConfig> arrDev = null;
		try {
			arrDev = appConfigManager.findAllByCompanyCompanyName(companyName);
			logger.info("search AppConfig  "+arrDev.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while searching AppConfig "+e.getMessage());

		}

		return arrDev;

	}

	@RequestMapping(value = "/diagissue/getall", method = RequestMethod.GET)
	public @ResponseBody List<DiagIssuesFlow> getAllDiagIssuesFlows() {
		List<DiagIssuesFlow> arrDiagIssuesFlows = null;
		try {
			arrDiagIssuesFlows = diagIssueFlowManager.getAll();
			logger.info("returning all diagissue "+arrDiagIssuesFlows.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while fetching diagissue "+e.getMessage());
		}

		return arrDiagIssuesFlows;

	}

	@RequestMapping(value = "/diagissue", method = RequestMethod.GET)
	public String diagissue() {

		logger.info("redirecting to manage diagissue jsp");
		return "ManageDiagIssuesFlow";
	}

	@RequestMapping(value = "/diagissue/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateDiagIssuesFlow(@RequestBody DiagIssuesFlow entity) {
		ResponseMessage message = null;
		try {
			diagIssueFlowManager.update(entity);
			logger.info("updated diagissue");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			logger.error("error in updating diagissue "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/diagissue/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveDiagIssuesFlows(@RequestBody DiagIssuesFlowBean diagIssuesFlow) {
		DiagIssuesFlow entity = new DiagIssuesFlow();
		BeanUtils.copyProperties(diagIssuesFlow, entity);
		ResponseMessage message = null;

		try {
			diagIssueFlowManager.add(entity);
			logger.info("/diagissue added");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			logger.error("error in saving /diagissue "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/diagissue/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeDiagIssuesFlows(@RequestBody DiagIssuesFlow diagIssuesFlow) {
		ResponseMessage message = null;
		DiagIssuesFlow entity = new DiagIssuesFlow();
		BeanUtils.copyProperties(diagIssuesFlow, entity);

		try {
			diagIssueFlowManager.remove(entity);
			logger.info("diagissue removed");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			 			logger.error("error in updating diagissue "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/diagtest/getall", method = RequestMethod.GET)
	public @ResponseBody List<DiagTest> getAllDiagTest() {
		List<DiagTest> arrDiagTest = null;
		try {

			arrDiagTest = diagTestManager.getAll();

			logger.info("returning all diagissue "+arrDiagTest.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in fetching diagissue "+e.getMessage());
		}

		return arrDiagTest;

	}


	@RequestMapping(value = "/diagtest", method = RequestMethod.GET)
	public String ManageDiagTest() {

		logger.info("redirecting to manage diagtest price");
		return "ManageDiagTest";
	}

	@RequestMapping(value = "/diagtest/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateDiagTest(@RequestBody DiagTest entity) {
		ResponseMessage message = null;

		try {
			diagTestManager.update(entity);
			logger.info("diagtest updated");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error in updating diagtest "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "200");
		}

		return message;

	}

	@RequestMapping(value = "/diagtest/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveDiagTest(@RequestBody DiagTestBean diagTest) {
		DiagTest entity = new DiagTest();
		BeanUtils.copyProperties(diagTest, entity);
		ResponseMessage message = null;

		try {
			diagTestManager.add(entity);
			message = new ResponseMessage("success", "200");
			logger.info("diagtest added");


		} catch (Exception e) {
			logger.error("error in saving diagtest"+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "200");
		}
		return message;

	}

	@RequestMapping(value = "/diagtest/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeDiagTest(@RequestBody DiagTestBean diagTestBean) {
		ResponseMessage message = null;
		DiagTest entity = new DiagTest();
		BeanUtils.copyProperties(diagTestBean, entity);

		try {
			diagTestManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("diagtest removed");

		} catch (Exception e) {
			logger.error("error in removing diagtest "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}



	@RequestMapping(value = "/diagtestcompany/search", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<DiagTestCompanyMap> searchDiagTestCompany(@RequestBody String companyName) {

	//	System.out.println("\n\nIn diagTestCompany\n\n");

		List<DiagTestCompanyMap> arrDiagtestcomp = null;
		try {
			arrDiagtestcomp = diagTestCompanyMapManager.findByCompanyName(companyName);
			logger.info("search AppConfig  "+arrDiagtestcomp.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while searching AppConfig "+e.getMessage());

		}

		return arrDiagtestcomp;

	}




	@RequestMapping(value = "/diagtestcompany/getall", method = RequestMethod.GET)
	public @ResponseBody List<DiagTestCompanyMap> getAllDiagTestCompanyMap() {
		List<DiagTestCompanyMap> arrdiagcomp = null;
		try {
			arrdiagcomp = diagTestCompanyMapManager.getAll();
			logger.info("returning all diagtestcompany "+arrdiagcomp.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning diagtestcompany "+e.getMessage());
		}

		return arrdiagcomp;

	}

	@RequestMapping(value = "/diagtestcompany", method = RequestMethod.GET)
	public String manageDiagTestCompanyMap() {

		logger.info("returning to manage diagtestcompany");
		return "ManageDiagTestCompanyMap";
	}

	@RequestMapping(value = "/diagtestcompany/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage UpdateDiagTestCompanyMap(@RequestBody DiagTestCompanyMap diagTestCompanyMap) {
		ResponseMessage message;
		DiagTestCompanyMap entity = new DiagTestCompanyMap();
		BeanUtils.copyProperties(diagTestCompanyMap, entity);

		try {
			diagTestCompanyMapManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("diagtestcompany updated");

		} catch (Exception e) {
			logger.error("error in updating diagtestcompany "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}


	/*@RequestMapping(value = "/diagtestcompany/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveDiagTestCompanyMap(@RequestBody DiagTestCompanyMapBean diagTestCompanyMapBean) {
		DiagTestCompanyMap entity = new DiagTestCompanyMap();
		BeanUtils.copyProperties(diagTestCompanyMapBean, entity);
		ResponseMessage message;
		try {
			diagTestCompanyMapManager.add(entity);

			message = new ResponseMessage("success: ", "200");
			logger.info("diagtestcompany added");

		} catch (Exception e) {
			logger.error("error in saving diagtestcompany "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}*/

	@RequestMapping(value = "/diagtestcompany/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveDiagTestCompanyMap(@RequestBody List<DiagTestCompanyMapBean> diagTestCompanyMapBean) {
		List<DiagTestCompanyMap> entityList = new ArrayList<DiagTestCompanyMap>();
		//BeanUtils.copyProperties(diagTestCompanyMapBean, entity);
		ResponseMessage message;


		for (DiagTestCompanyMapBean diagTestCompanyMap : diagTestCompanyMapBean) {
			DiagTestCompanyMap entity= new DiagTestCompanyMap();
			BeanUtils.copyProperties(diagTestCompanyMap, entity);
			entityList.add(entity);
		}

		System.out.println("\n\nlength of diagtestcompanymapLIST \t\t"+entityList.size()+"\n\n");


		try {
			for (DiagTestCompanyMap diagTestCompanyMap : entityList) {
				diagTestCompanyMapManager.add(diagTestCompanyMap);
			}
			//diagTestCompanyMapManager.add(entity);

			message = new ResponseMessage("success: ", "200");
			logger.info("diagtestcompany added");

		} catch (Exception e) {
			logger.error("error in saving diagtestcompany "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}



	@RequestMapping(value = "/diagtestcompany/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeDiagTestCompanyMap(@RequestBody DiagTestCompanyMapBean diagTestCompanyMap) {
		ResponseMessage message;
		DiagTestCompanyMap entity = new DiagTestCompanyMap();
		BeanUtils.copyProperties(diagTestCompanyMap, entity);

		try {
			diagTestCompanyMapManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("diagtestcompany removed");

		} catch (Exception e) {
			logger.error("error in removing diagtestcompany "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

/*----*/

	@RequestMapping(value = "/model/getall", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody String getAllEModels() {
		List<EModel> arrEModels = null;
		try {
			arrEModels = eModelManager.getAll();
			logger.info("returning all model "+arrEModels.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning model "+e.getMessage());
		}

		String json = new Gson().toJson(arrEModels);

		return json;

	}

	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public String ManageEModel() {

		logger.info("returning to manage model");
		return "ManageEModel";
	}

	@RequestMapping(value = "/model/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateeModel(@RequestBody EModelBean model) {
		ResponseMessage message;
		EModel entity = new EModel();
		BeanUtils.copyProperties(model, entity);

		try {
			eModelManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("model updated");

		} catch (Exception e) {
			logger.error("error in updating model "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/model/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveeModel(@RequestBody EModelBean emodel)	//,@RequestParam("deviceImage") MultipartFile deviceImage
	{
//		byte[] decodedByte = Base64.decode("");
		 byte[] buf = new byte[] { 0x12, 0x23 };
		 Blob b = null;
		    try {
				buf = new sun.misc.BASE64Decoder().decodeBuffer(emodel.getDeviceImage());
//				emodel.setDeviceImage(deviceImage);


		    b = new SerialBlob(buf);
		    } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SerialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		EModel entity = new EModel();
		BeanUtils.copyProperties(emodel, entity);
		entity.setDeviceImage(b);



		ResponseMessage message;
		try {
			eModelManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("model added");

		} catch (Exception e) {
			logger.error("error in saving model "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/model/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeeModel(@RequestBody EModelBean model) {
		ResponseMessage message;
		EModel entity = new EModel();
		BeanUtils.copyProperties(model, entity);

		try {
			eModelManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("model removed");

		} catch (Exception e) {
			logger.error("error in removing model "+e.getMessage());
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
	public @ResponseBody ValueType[] GetValueType() {
		logger.info("returning deduction types");

		return ValueType.values();

	}
	/*----*/

	@RequestMapping(value = "/manufacturer/getall", method = RequestMethod.GET)
	public @ResponseBody List<EManufacturer> getAllEManufacturers() {
		List<EManufacturer> arrEManufacturers = null;
		try {
			arrEManufacturers = eManufacturerManager.getAll();
			logger.info("returning all manufacturer "+arrEManufacturers.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning manufacturer "+e.getMessage());
		}

		return arrEManufacturers;

	}

	@RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
	public String manageeManufacturer() {

		logger.info("returning to manage manufacturer");
		return "ManageEManufacturer";
	}

	@RequestMapping(value = "/manufacturer/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateeManufacturer(@RequestBody EManufacturerBean manufacturer) {
		ResponseMessage message;
		EManufacturer entity = new EManufacturer();
		BeanUtils.copyProperties(manufacturer, entity);

		try {
			eManufacturerManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("manufacturer updated");

		} catch (Exception e) {
			logger.error("error in updating manufacturer "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/manufacturer/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveeManufacturer(@RequestBody EManufacturerBean eManufacturer) {
		EManufacturer entity = new EManufacturer();
		BeanUtils.copyProperties(eManufacturer, entity);
		ResponseMessage message;
		try {
			eManufacturerManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("manufacturer added");

		} catch (Exception e) {
			logger.error("error in saving manufacturer "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/manufacturer/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeeManufacturer(@RequestBody EManufacturerBean manufacturer) {
		ResponseMessage message;
		EManufacturer entity = new EManufacturer();
		BeanUtils.copyProperties(manufacturer, entity);

		try {
			eManufacturerManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("manufacturer removed");

		} catch (Exception e) {
			logger.error("error in removing manufacturer "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/company/getall", method = RequestMethod.GET)
	public @ResponseBody List<ECompany> getAll() {
		List<ECompany> arrECompanys = null;
		try {
			arrECompanys = eCompanyManager.getAll();
			logger.info("returning all ecompany "+arrECompanys.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning ecompany "+e.getMessage());
		}

		return arrECompanys;

	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String manageeCompany() {

		logger.info("returning to manage promotions");
		return "ManageECompany";
	}

	@RequestMapping(value = "/company/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateCompany(@RequestBody ECompanyBean company) {
		ResponseMessage message;
		ECompany entity = new ECompany();
		BeanUtils.copyProperties(company, entity);

		try {
			eCompanyManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("company updated");

		} catch (Exception e) {
			logger.error("error in updating company "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/company/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveeCompany(@RequestBody ECompanyBean eCompany) {
		ECompany entity = new ECompany();
		BeanUtils.copyProperties(eCompany, entity);
		ResponseMessage message;
		try {
			eCompanyManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("company added");

		} catch (Exception e) {
			logger.error("error in saving company "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/company/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeeCompany(@RequestBody ECompanyBean company) {
		ResponseMessage message;
		ECompany entity = new ECompany();
		BeanUtils.copyProperties(company, entity);

		try {
			eCompanyManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("company removed");

		} catch (Exception e) {
			logger.error("error in removing company "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}


	@RequestMapping(value = "/deviceattribute/getall", method = RequestMethod.GET)
	public @ResponseBody List<EDeviceAttribute> getAllEDeviceAttributes() {
		List<EDeviceAttribute> arrEDeviceAttributes = null;
		try {
			arrEDeviceAttributes = eDeviceAttributeManager.getAll();
			logger.info("returning all deviceattribute "+arrEDeviceAttributes.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning deviceattribute "+e.getMessage());
		}

		return arrEDeviceAttributes;

	}

	@RequestMapping(value = "/deviceattribute", method = RequestMethod.GET)
	public String manageeDeviceAttribute() {

		logger.info("returning to manage deviceattribute");
		return "ManageEDeviceAttribute";
	}

	@RequestMapping(value = "/deviceattribute/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateeDeviceAttribute(@RequestBody EDeviceAttributeBean deviceattribute) {
		ResponseMessage message;
		EDeviceAttribute entity = new EDeviceAttribute();
		BeanUtils.copyProperties(deviceattribute, entity);

		try {
			eDeviceAttributeManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("deviceattribute updated");

		} catch (Exception e) {
			logger.error("error in updating deviceattribute "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/deviceattribute/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveeDeviceAttribute(@RequestBody EDeviceAttributeBean eDeviceAttribute) {
		EDeviceAttribute entity = new EDeviceAttribute();
		BeanUtils.copyProperties(eDeviceAttribute, entity);
		ResponseMessage message;
		try {
			eDeviceAttributeManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("deviceattribute added");

		} catch (Exception e) {
			logger.error("error in saving deviceattribute "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/deviceattribute/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeeDeviceAttribute(@RequestBody EDeviceAttributeBean deviceattribute) {
		ResponseMessage message;
		EDeviceAttribute entity = new EDeviceAttribute();
		BeanUtils.copyProperties(deviceattribute, entity);

		try {
			eDeviceAttributeManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("deviceattribute removed");

		} catch (Exception e) {
			logger.error("error in removing deviceattribute "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}


	@RequestMapping(value = "/devicebaseprice/getall", method = RequestMethod.GET)
	public @ResponseBody List<EDeviceTradeInBasePrice> getAllEDeviceTradeInBasePrices() {
		List<EDeviceTradeInBasePrice> arrEDeviceTradeInBasePrices = null;
		try {
			arrEDeviceTradeInBasePrices = eDeviceTradeInBasePriceManager.getAll();
			logger.info("returning all devicebaseprice "+arrEDeviceTradeInBasePrices.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning devicebaseprice "+e.getMessage());
		}

		return arrEDeviceTradeInBasePrices;

	}

	@RequestMapping(value = "/devicebaseprice", method = RequestMethod.GET)
	public String manageeDeviceTradeInBasePrice() {

		logger.info("returning to manage devicebaseprice");
		return "ManageEDeviceTradeInBasePrice";
	}

	@RequestMapping(value = "/devicebaseprice/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateeDeviceTradeInBasePrice(@RequestBody EDeviceTradeInBasePriceBean devicebaseprice) {
		ResponseMessage message;
		EDeviceTradeInBasePrice entity = new EDeviceTradeInBasePrice();
		BeanUtils.copyProperties(devicebaseprice, entity);

		try {
			eDeviceTradeInBasePriceManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("devicebaseprice updated");

		} catch (Exception e) {
			logger.error("error in updating devicebaseprice "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/devicebaseprice/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveeDeviceTradeInBasePrice(@RequestBody EDeviceTradeInBasePriceBean eDeviceTradeInBasePrice) {
		EDeviceTradeInBasePrice entity = new EDeviceTradeInBasePrice();
		BeanUtils.copyProperties(eDeviceTradeInBasePrice, entity);
		ResponseMessage message;
		try {
			eDeviceTradeInBasePriceManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("devicebaseprice added");

		} catch (Exception e) {
			logger.error("error in saving devicebaseprice "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/devicebaseprice/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeeDeviceTradeInBasePrice(@RequestBody EDeviceTradeInBasePriceBean devicebaseprice) {
		ResponseMessage message;
		EDeviceTradeInBasePrice entity = new EDeviceTradeInBasePrice();
		BeanUtils.copyProperties(devicebaseprice, entity);

		try {
			eDeviceTradeInBasePriceManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("devicebaseprice removed");

		} catch (Exception e) {
			logger.error("error in removing devicebaseprice "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}
/*new*/

	@RequestMapping(value = "/eUser/getall", method = RequestMethod.GET)
	public @ResponseBody List<EUser> getAllEUsers() {
		//fetching app config details
		List<EUser> arrEUsers = null;
		try {
			arrEUsers = eUserManager.getAll();
			logger.info("get all EUsers called---- returning list "+arrEUsers.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning all EUsers "+e.getMessage());
		}

		return arrEUsers;

	}



	@RequestMapping(value = "/eUser", method = RequestMethod.GET)
	public String eUser() {

		logger.info("redirecting to manageAppConfig jsp");

		return "ManageEUser";
	}

	@RequestMapping(value = "/eUser/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateAppConfig(@RequestBody EUserBean eUserBean) {
		ResponseMessage message = null;
		EUser entity = new EUser();
		BeanUtils.copyProperties(eUserBean, entity);
		try {

			eUserManager.update(entity);
			logger.info("EUser updated");

			message = new ResponseMessage("success", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("error while updatingEUser "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/eUser/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveEUser(@RequestBody EUserBean eUser) {
		EUser entity = new EUser();
		BeanUtils.copyProperties(eUser, entity);
		ResponseMessage message = null;

		try {
			eUserManager.add(entity);
			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		// ResponseMessage message = new ResponseMessage("success", "200");
		return message;

	}

	@RequestMapping(value = "/eUser/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeEUsers(@RequestBody EUserBean eUser) {
		ResponseMessage message = null;
		EUser entity = new EUser();
		BeanUtils.copyProperties(eUser, entity);

		try {
			eUserManager.remove(entity);
			logger.info("AppConfig removed");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error while removing AppConfig "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

/*	@RequestMapping(value = "/appConfig/search", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<AppConfig> searchAppConfigs(@RequestBody String configKey) {

		List<AppConfig> arrDev = null;
		try {
			arrDev = appConfigManager.findByConfigKey(configKey);
			logger.info("search AppConfig  "+arrDev.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while searching AppConfig "+e.getMessage());

		}

		return arrDev;

	}
*/

	/*end*/


}


