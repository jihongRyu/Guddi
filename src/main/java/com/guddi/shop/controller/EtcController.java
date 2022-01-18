package com.guddi.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guddi.shop.dao.CartDao;
import com.guddi.shop.dao.EtcDao;
import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.MemberDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ReviewQnaDto;
import com.guddi.shop.service.CartService;
import com.guddi.shop.service.EtcService;

@Controller
public class EtcController {


	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired EtcService service;
	
	// 신상여부, 판매여부 카테고리 관련  유지홍 2022.01.17 Start
	@RequestMapping(value = "/toNewFlgCategory", method = RequestMethod.GET)
	public String toNewFlgCategory(Model model , HttpSession session) {
		logger.info("toNewFlgCategory 요청");
		
		ArrayList<EtcDto> dto = service.getNewFlgInfo();//신상여부 리스트를 가져옮		
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		model.addAttribute("newFlgList", dto);
		model.addAttribute("useFlgList", uDto);
		

		return "etc/newFlgCategory";
	}	
	
	@RequestMapping(value = "/registNewflg", method = RequestMethod.GET)
	public String registNewflg(Model model , HttpSession session) {
		logger.info("registNewflg 요청");
		

		return "etc/registNewflg";
	}
	
	@RequestMapping(value = "/doRegistNewFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doRegistNewFlg(Model model , @RequestParam String newname) {
		logger.info("doRegistNewFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		
		int result = service.doRegistNewFlg(newname);
		
		if (result>0) {
			map.put("result", result);
		}
		return map;
	}
	
	@RequestMapping(value = "/doUpdateUseFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doUpdateUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flg) {

		
		logger.info("doUpdateUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		logger.info("use_flg : {}",use_flg);
		logger.info("idx :  {}",idx);
				
		int result = service.doUpateUseFlg(Integer.parseInt(use_flg) , Integer.parseInt(idx));
		map.put("result", result);
		
		return map;
	}
	
	@RequestMapping(value = "/toSellFlgCategory", method = RequestMethod.GET)
	public String toSellFlgCategory(Model model , HttpSession session) {
		logger.info("toSellFlgCategory 요청");
		
		ArrayList<EtcDto> dto = service.getSellFlgInfo();//신상여부 리스트를 가져옮		
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		model.addAttribute("sellFlgList", dto);
		model.addAttribute("useFlgList", uDto);
		

		return "etc/sellFlgCategory";
	}
	
	@RequestMapping(value = "/registSellflg", method = RequestMethod.GET)
	public String registSellflg(Model model , HttpSession session) {
		logger.info("registNewflg 요청");
		

		return "etc/registSellflg";
	}
	
	@RequestMapping(value = "/doRegistSellFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doRegistSellFlg(Model model , @RequestParam String sellname) {
		logger.info("doRegistSellFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		int result = service.doRegistSellFlg(sellname);
		
		if (result>0) {
			map.put("result", result);
		}
		return map;
	}
	
	@RequestMapping(value = "/doUpdateSellUseFlg", method = RequestMethod.POST)
	@ResponseBody            
	public HashMap<String, Object> doUpdateSellUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flg) {
		
		logger.info("doUpdateSellUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		
		logger.info("use_flg : {}",use_flg);
		logger.info("idx :  {}",idx);
	
		int result = service.doUpdateSellUseFlg(Integer.parseInt(use_flg) , Integer.parseInt(idx));
		map.put("result", result);
		
		
	
		return map;
	}
	// 신상여부, 판매여부 카테고리 관련  유지홍 2022.01.17 End
	
	// 메인이미지 제어  유지홍 2022.01.18 Start
	@RequestMapping(value = "/toMainImage", method = RequestMethod.GET)
	public String toMainImage(Model model) {
		logger.info("toMainImage 요청");
		
		ArrayList<EtcDto> dto = service.getMainImageList();//메인이미지정보를 가져오는 함수
		ArrayList<MemberDto> userLists = service.getUserInfo();//유저정보를 가져오는 함수
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		model.addAttribute("userLists", userLists);
		model.addAttribute("useFlgList", uDto);		
		model.addAttribute("imageDto", dto);
		
		
		return "etc/mainImageControl";
	}
	
	@RequestMapping(value = "/addMainimage", method = RequestMethod.GET)
	public String addMainimage(Model model, HttpSession session) {
		logger.info("addMainimage 요청");
		
		return "etc/addMainImage";
	}
	
	@RequestMapping(value = "/doAddMainImage", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doAddMainImage(Model model, @RequestParam MultipartFile file, HttpSession session) {	
		logger.info("doAddMainImage 요청");	
		HashMap<String, Object> map = new HashMap<String, Object>();
		int idx = service.getMainImageIdx();
		String userId = (String) session.getAttribute("userId");
		int u_idx = service.getU_idx(userId);
		logger.info("u_idx : {}",u_idx);
		int result = service.doAddMainImage(idx, u_idx, file);
		
		map.put("result", result);
		
		return map;
	}	
	@RequestMapping(value = "/delMainImage", method = RequestMethod.GET)
	public String delMainImage(Model model, @RequestParam int idx) {
		logger.info("delMainImage 요청");
		
		service.delMainImage(idx);
		
		return "redirect:/toMainImage";
	}
	
	@RequestMapping(value = "/doUpdateImageUseFlg", method = RequestMethod.POST)
	@ResponseBody            
	public HashMap<String, Object> doUpdateImageUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flg) {
		
		logger.info("doUpdateImageUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		
		logger.info("use_flg : {}",use_flg);
		logger.info("idx :  {}",idx);
	
		int result = service.doUpdateImageUseFlg(Integer.parseInt(use_flg) , Integer.parseInt(idx));
		map.put("result", result);

		return map;
	}
	
	@RequestMapping(value = "/updateMainImageOrder")
	@ResponseBody
	public HashMap<String, Object>  updateMainImageOrder(HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
	        
	    String[] newOrder = request.getParameterValues("newOrder");
	    String[] newFileName = request.getParameterValues("newFileName");
	    
	    for (int i = 0; i < newFileName.length; i++) {
	    	logger.info("newOrder:{}", newOrder[i]);
		}
	    
	    int result = service.updateImageOrder(newOrder,newFileName);
	    if (result>0) {
	    	String resultMsg = "순서변경 성공!";
	  	    map.put("result", resultMsg);
	  	    System.out.println("Controller에서 보낸 MSG : "+ resultMsg);
		}	  
	        
	    return map;
	}
	// 메인이미지 제어  유지홍 2022.01.18 End
	
	//브랜드 카테고리 김도연 start 2022.01.17
	@RequestMapping(value = "/toBrandCategory", method = RequestMethod.GET)
	public String toBrandCategory(Model model , HttpSession session) {
		logger.info("toBrandCategory 이동요청");
		
		ArrayList<EtcDto> dto = service.getBrand();
		ArrayList<EtcDto> udto = service.getUseFlgInfo();
		
		model.addAttribute("brandList", dto);
		model.addAttribute("useFlgList", udto);
		
		return "etc/brandCategory";
	}
	
	@RequestMapping(value = "/doRegistBrand", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doRegistBrand(Model model 
			, @RequestParam String name, @RequestParam String code) {
		logger.info("doRegistBrand 요청");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = service.doRegistBrand(name,code);
		
		if(result>0) {
			map.put("result", result);
		}
		
		return map;
	}
	
	@RequestMapping(value = "/doUpdateBrandUse", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doUpdateBrandUse(Model model 
			, @RequestParam String brand_idx, @RequestParam String use_flgName) {
		logger.info("doUpdateBrandUse 요청");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int useflg = 100;
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();
		
		for (int i = 0; i < uDto.size(); i++) {
			if(uDto.get(i).getUseFlg_name().equals(use_flgName)) {
				useflg = uDto.get(i).getIdx();
			}
		}
		
		if(useflg != 100) {
			int result = service.doUpdateBrandUse(useflg, Integer.parseInt(brand_idx));
			map.put("result", result);
		}
	
		
		return map;
	}
	//브랜드 카테고리 김도연 start 2022.01.17 End
	
	
}
