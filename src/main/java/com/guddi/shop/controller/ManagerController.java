package com.guddi.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guddi.shop.service.ManagerService;

@Controller
public class ManagerController {	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ManagerService service;
	
	@RequestMapping(value = "/productMain", method = RequestMethod.GET)
	public String productMain(Model model) {	
		logger.info("productMain 요청");	
		
		
		
		return "manager/productMain";
	}
	
	@RequestMapping(value = "/registProduct", method = RequestMethod.GET)
	public String registProduct(Model model) {	
		logger.info("productMain 요청");
		
		return "manager/registProduct";
	}
	

}
