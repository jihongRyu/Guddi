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
	
	@RequestMapping(value = "/toReviewPage", method = RequestMethod.GET)
	public String toReviewPage(Model model, @RequestParam("num") int num, @RequestParam("answer_flg") int answer_flg, 
			@RequestParam(value="brandName",required=false,defaultValue = "") String brandName, 
			@RequestParam(value="bagName",required=false,defaultValue = "") String bagName, 
			@RequestParam(value="keyword",required=false,defaultValue="")String keyword) {
		
		logger.info("qnaPage 요청");		
		PageDto reviewPage = new PageDto();
		
		reviewPage.setNum(num);
		reviewPage.setCount(service.reviewSearchCount(keyword, answer_flg, brandName, bagName));				
		reviewPage.setKeyword(keyword);
		
		logger.info("review.getCount() : {}",reviewPage.getCount());
		
		ArrayList<ReviewQnaDto> reviewList = 
				service.reviewInfo(reviewPage.getDisplayPost(), reviewPage.getPostNum(), keyword, answer_flg, brandName, bagName);
		ArrayList<EtcDto> brandCategoryList = service.getbrandCategoryList();
		ArrayList<EtcDto> answerList = service.getanswerList();
		ArrayList<EtcDto> bagCategoryList = service.getbagCategoryList();
	
		model.addAttribute("reviewList", reviewList); //리스트 보내기
		model.addAttribute("reviewPage", reviewPage); //페이징처리
		model.addAttribute("select", num);//페이징처리		  
		model.addAttribute("keyword", keyword); //검색어
		model.addAttribute("answer_flg", answer_flg); //검색어
		model.addAttribute("brandName", brandName); //검색어
		model.addAttribute("bagName", bagName); //검색어
		model.addAttribute("answerList", answerList); //답변여부정보
		model.addAttribute("bagCategoryList", bagCategoryList); 
		model.addAttribute("brandCategoryList", brandCategoryList); 
	
		return "etc/reviewPage";
	}
	
	@RequestMapping(value = "/toReviewDetail", method = RequestMethod.GET)
	public String toReviewDetail(Model model, @RequestParam int idx, @RequestParam String product_name) {
		logger.info("toReviewDetail 요청");
		
		ReviewQnaDto dto = service.getReviewDetail(idx);
		ReviewQnaDto answer = service.getReviewAnswer(idx);
		
		model.addAttribute("product_name", product_name);
		model.addAttribute("review", dto);
		model.addAttribute("answer", answer);
		
		return "etc/managerReviewDetail";
	}
	@RequestMapping(value = "/doReviewAnswer", method = RequestMethod.POST)
	public String doReviewAnswer(Model model, HttpSession session,
			@RequestParam int idx, @RequestParam String answer, @RequestParam String product_name) {
		logger.info("toReviewDetail 요청");
		
		String managerId = (String) session.getAttribute("userId");
		ReviewQnaDto dto = new ReviewQnaDto();
		dto.setR_idx(idx);
		dto.setContent(answer);
		dto.setManagerId(managerId);
		
		int result = service.doReviewAnswer(dto);
		
		ReviewQnaDto review = service.getReviewDetail(idx);
		ReviewQnaDto reviewAnswer = service.getReviewAnswer(idx);
			
		model.addAttribute("product_name", product_name);
		model.addAttribute("review", review);
		model.addAttribute("answer", reviewAnswer);		
		
		return "etc/managerReviewDetail";
	}
	
	@RequestMapping(value = "/doDelReviewAnswer", method = RequestMethod.GET)
	public String doDelReviewAnswer(Model model, @RequestParam int a_idx, @RequestParam int r_idx,@RequestParam String product_name) {
		logger.info("doDelReviewAnswer 요청");
		
		service.doDelReviewAnswer(a_idx);
		
		ReviewQnaDto review = service.getReviewDetail(r_idx);
		ReviewQnaDto reviewAnswer = service.getReviewAnswer(r_idx);
			
		model.addAttribute("product_name", product_name);
		model.addAttribute("review", review);
		model.addAttribute("answer", reviewAnswer);	
		
		
		return "etc/managerReviewDetail";
	}
	@RequestMapping(value = "/updateReviewAnswer", method = RequestMethod.GET)
	public String updateReviewAnswer(Model model, @RequestParam int r_idx, 
			@RequestParam int a_idx, @RequestParam String product_name) {
		logger.info("updateReviewAnswer 요청");
		
		ReviewQnaDto review = service.getReviewDetail(r_idx);
		ReviewQnaDto reviewAnswer = service.getReviewAnswer(r_idx);
			
		model.addAttribute("product_name", product_name);
		model.addAttribute("review", review);
		model.addAttribute("answer", reviewAnswer);
		
		return "etc/updateReviewAnswer";
	}
	
	@RequestMapping(value = "/doUpdateReviewAnswer", method = RequestMethod.POST)
	public String doUpdateReviewAnswer(Model model, HttpSession session,
			@RequestParam int idx, @RequestParam int a_idx, @RequestParam String answer, @RequestParam String product_name) {
		logger.info("doUpdateReviewAnswer 요청");
	
		ReviewQnaDto dto = new ReviewQnaDto();
		dto.setIdx(a_idx);
		dto.setContent(answer);
		
		logger.info("dto.getContent():{}", dto.getContent());
		logger.info("dto.getIdx():{}", dto.getIdx());
			
		service.doUpdateReviewAnswer(dto);
		
		ReviewQnaDto review = service.getReviewDetail(idx);
		ReviewQnaDto reviewAnswer = service.getReviewAnswer(idx);
			
		model.addAttribute("product_name", product_name);
		model.addAttribute("review", review);
		model.addAttribute("answer", reviewAnswer);		
		
		return "etc/managerReviewDetail";
	}
	
	
	
}
