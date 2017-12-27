package com.pervacio.adminportal.controller;

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
import com.pervacio.adminportal.model.ResponseMessage;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.DevicePrice;
import com.pervacio.adminportal.tradein.entities.Grade;
import com.pervacio.adminportal.tradein.entities.Promotion;
import com.pervacio.adminportal.tradein.model.DeviceBean;
import com.pervacio.adminportal.tradein.model.DevicePriceBean;
import com.pervacio.adminportal.tradein.model.GradeBean;
import com.pervacio.adminportal.tradein.model.PromotionBean;
import com.pervacio.adminportal.tradein.service.DeviceManager;
import com.pervacio.adminportal.tradein.service.DevicePriceManager;
import com.pervacio.adminportal.tradein.service.GradeManager;
import com.pervacio.adminportal.tradein.service.PromotionManager;

@Controller
@RequestMapping("/tradein")
public class TradeInController {
	private static final Logger logger = Logger.getLogger(TradeInController.class);

	@Autowired
	private DeviceManager deviceManager;
	@Autowired
	private GradeManager gradeManager;
	@Autowired
	private DevicePriceManager devicePriceManager;
	@Autowired
	private PromotionManager promotionManager;

	@RequestMapping(value = "/device/getall", method = RequestMethod.GET)
	public @ResponseBody List<Device> getAllDevices() {
		List<Device> arrDevices = null;
		try {
			arrDevices = deviceManager.getAll();
			logger.info("get all devices called---- returning list "+arrDevices.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning all devices "+e.getMessage());
		}

		return arrDevices;

	}



	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public String device() {

		logger.info("redirecting to managedevice jsp");

		return "ManageDevice";
	}

	@RequestMapping(value = "/device/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateDevices(@RequestBody DeviceBean device) {
		ResponseMessage message = null;
		Device entity = new Device();
		BeanUtils.copyProperties(device, entity);
		try {

			deviceManager.update(entity);
			logger.info("device updated");

			message = new ResponseMessage("success", "200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("error while updating device "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/device/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveDevices(@RequestBody DeviceBean device) {
		Device entity = new Device();
		BeanUtils.copyProperties(device, entity);
		ResponseMessage message = null;

		try {
			deviceManager.add(entity);
			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		// ResponseMessage message = new ResponseMessage("success", "200");
		return message;

	}

	@RequestMapping(value = "/device/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeDevices(@RequestBody DeviceBean device) {
		ResponseMessage message = null;
		Device entity = new Device();
		BeanUtils.copyProperties(device, entity);

		try {
			deviceManager.remove(entity);
			logger.info("device removed");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error while removing device "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/device/search", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<Device> searchDevices(@RequestBody String model) {

		List<Device> arrDev = null;
		try {
			arrDev = deviceManager.getDeviceByModel(model);
			logger.info("search device  "+arrDev.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while searching device "+e.getMessage());

		}

		return arrDev;

	}

	@RequestMapping(value = "/grade/getall", method = RequestMethod.GET)
	public @ResponseBody List<Grade> getAllGrades() {
		List<Grade> arrGrades = null;
		try {
			arrGrades = gradeManager.getAll();
			logger.info("returning all grades "+arrGrades.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error while fetching grades "+e.getMessage());
		}

		return arrGrades;

	}

	@RequestMapping(value = "/grade", method = RequestMethod.GET)
	public String grade() {

		logger.info("redirecting to manage grade jsp");
		return "ManageGrade";
	}

	@RequestMapping(value = "/grade/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateGrades(@RequestBody Grade entity) {
		ResponseMessage message = null;
		try {
			gradeManager.update(entity);
			logger.info("updated grade");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			logger.error("error in updating grade "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/grade/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveGrades(@RequestBody GradeBean grade) {
		Grade entity = new Grade();
		BeanUtils.copyProperties(grade, entity);
		ResponseMessage message = null;

		try {
			gradeManager.add(entity);
			logger.info("grade added");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			logger.error("error in saving grade "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/grade/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeGrades(@RequestBody Grade grade) {
		ResponseMessage message = null;
		Grade entity = new Grade();
		BeanUtils.copyProperties(grade, entity);

		try {
			gradeManager.remove(entity);
			logger.info("grade removed");

			message = new ResponseMessage("success: ", "200");

		} catch (Exception e) {
			 			logger.error("error in updating grade "+e.getMessage());

			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/deviceprice/getall", method = RequestMethod.GET)
	public @ResponseBody List<DevicePrice> getAllDevPrice() {
		List<DevicePrice> arrDevPrice = null;
		try {

			arrDevPrice = devicePriceManager.getAll();

			logger.info("returning all dev prices "+arrDevPrice.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in fetching device price "+e.getMessage());
		}

		return arrDevPrice;

	}

	@RequestMapping(value = "/GetBasePrice", method = RequestMethod.POST)
	public @ResponseBody List<DevicePrice> getBasePrice(@RequestBody Device device) {
		List<DevicePrice> arrDevPrice = null;
		Device entity = new Device();
		BeanUtils.copyProperties(device, entity);

		try {
			arrDevPrice =  devicePriceManager.getDevicePriceByDevice(entity);
			logger.info("returning base price");

		} catch (Exception e) {
			logger.error("error in getting base price "+e.getMessage());
		}

		return arrDevPrice;

	}

	@RequestMapping(value = "/deviceprice", method = RequestMethod.GET)
	public String deviceprice() {

		logger.info("redirecting to manage device price");
		return "ManageDevicePrice";
	}

	@RequestMapping(value = "/deviceprice/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateDevPrice(@RequestBody DevicePrice entity) {
		ResponseMessage message = null;

		try {
			devicePriceManager.update(entity);
			logger.info("device price updated");

			message = new ResponseMessage("success", "200");

		} catch (Exception e) {
			logger.error("error in updating dev price "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "200");
		}

		return message;

	}

	@RequestMapping(value = "/deviceprice/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveDevPrice(@RequestBody DevicePriceBean devicePrice) {
		DevicePrice entity = new DevicePrice();
		BeanUtils.copyProperties(devicePrice, entity);
		ResponseMessage message = null;

		try {
			devicePriceManager.add(entity);
			message = new ResponseMessage("success", "200");
			logger.info("device price added");


		} catch (Exception e) {
			logger.error("error in saving dev price "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "200");
		}
		return message;

	}

	@RequestMapping(value = "/deviceprice/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeDevPrice(@RequestBody DevicePriceBean device) {
		ResponseMessage message = null;
		DevicePrice entity = new DevicePrice();
		BeanUtils.copyProperties(device, entity);

		try {
			devicePriceManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("dev price removed");

		} catch (Exception e) {
			logger.error("error in removing dev price "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/promotion/getall", method = RequestMethod.GET)
	public @ResponseBody List<Promotion> getAllPromotions() {
		List<Promotion> arrPromotions = null;
		try {
			arrPromotions = promotionManager.getAll();
			logger.info("returning all promotions "+arrPromotions.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in returning promotions "+e.getMessage());
		}

		return arrPromotions;

	}

	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String promotion() {

		logger.info("returning to manage promotions");
		return "ManagePromotions";
	}

	@RequestMapping(value = "/promotion/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage updateProm(@RequestBody PromotionBean prom) {
		ResponseMessage message;
		Promotion entity = new Promotion();
		BeanUtils.copyProperties(prom, entity);

		try {
			promotionManager.update(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("promotion updated");

		} catch (Exception e) {
			logger.error("error in updating promotion "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}

		return message;

	}

	@RequestMapping(value = "/promotion/save", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage saveProm(@RequestBody PromotionBean promotion) {
		Promotion entity = new Promotion();
		BeanUtils.copyProperties(promotion, entity);
		ResponseMessage message;
		try {
			promotionManager.add(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("promotion added");

		} catch (Exception e) {
			logger.error("error in saving promotion "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/promotion/remove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseMessage removeProm(@RequestBody PromotionBean prom) {
		ResponseMessage message;
		Promotion entity = new Promotion();
		BeanUtils.copyProperties(prom, entity);

		try {
			promotionManager.remove(entity);
			message = new ResponseMessage("success: ", "200");
			logger.info("promotion removed");

		} catch (Exception e) {
			logger.error("error in removing promotion "+e.getMessage());
			message = new ResponseMessage("error: " + e.getMessage(), "400");
		}
		return message;

	}

	@RequestMapping(value = "/promotion/search", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody List<Promotion> SearchProm(@RequestBody String promoCode) {

		List<Promotion> arrProm = null;
		try {
			arrProm = promotionManager.findAllByPromotionKeyPromoCode(promoCode);
			logger.info("searching prom");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error in searching promotions "+e.getMessage());
		}

		return arrProm;

	}

	@RequestMapping(value = "/GetDeductionType", method = RequestMethod.GET)
	public @ResponseBody DeductionType[] getDeductionType() {
		logger.info("returning deduction types");

		return DeductionType.values();

	}

}