package com.guddi.shop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.dto.ReviewQnaDto;
import com.guddi.shop.service.ManagerService;

@Controller
public class ManagerController {	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ManagerService service;
	@Autowired ServletContext servletContext;
	
	//관리자페이지 제품 리스트, 수정 관련 Start ryujihong 2022.01.12
	@RequestMapping(value = "/productMain", method = RequestMethod.GET)
	public String productMain(Model model, HttpSession session, @RequestParam("num") int num,  
			@RequestParam(value="brand_type",required=false,defaultValue = "0") int brand_type, 
			@RequestParam(value="bag_type",required=false,defaultValue = "0") int bag_type, 
			@RequestParam(value="keyword",required=false,defaultValue="")String keyword) {	
		
		logger.info("productMain 요청");	
		
		getCategory(session);
		ArrayList<EtcDto> brandtypeInfo = (ArrayList<EtcDto>) session.getAttribute("brandcategory");
		ArrayList<EtcDto> bagtypeInfo = (ArrayList<EtcDto>) session.getAttribute("bagtype");
		String brand_name = null;
		String bag_name = null;
		
		if (brand_type!=0) {
			for (int i = 0; i < brandtypeInfo.size(); i++) {
				if (brandtypeInfo.get(i).getBrand_idx()==brand_type) {
					brand_name = brandtypeInfo.get(i).getBrand_name();
				}
			}			
		}
		if (bag_type!=0) {
			for (int i = 0; i < bagtypeInfo.size(); i++) {
				if (bagtypeInfo.get(i).getType_idx()==bag_type) {
					bag_name = bagtypeInfo.get(i).getType_name();
				}
			}			
		}	

		PageDto Page = new PageDto();
		
		Page.setNum(num);
		Page.setCount(service.productSearchCount(keyword, brand_name,bag_name));				
		Page.setKeyword(keyword);
		
		logger.info("Page.getCount() : {}",Page.getCount());
		
		ArrayList<ProductDto> productList = 
				service.productList(Page.getDisplayPost(), Page.getPostNum(), keyword, brand_name, bag_name);
				
		model.addAttribute("productList", productList); //리스트 보내기
		model.addAttribute("page", Page); //페이징처리
		model.addAttribute("select", num);//페이징처리		  
		model.addAttribute("keyword", keyword); //검색어
		model.addAttribute("bag_type", bag_type); 
		model.addAttribute("brand_type", brand_type); //검색어		
		
		return "manager/productMain";
	}
	
	@RequestMapping(value = "/registProduct", method = RequestMethod.GET)
	public String registProduct(Model model, HttpSession session) {	
		logger.info("registProduct 요청");
		
		getCategory(session);
		
		return "manager/registProduct";
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public String updateProduct(Model model, HttpSession session, @RequestParam int idx) {	
		logger.info("updateProduct 요청");
		
		getCategory(session);
		//제품에 대한 정보를 가져오는 함수
		ProductDto dto = service.productInfo(idx);
		//제품 이미지 정보를 가져오는 함수
		ArrayList<ProductDto> imageDto = service.productImageInfo(idx);
		
		model.addAttribute("dto", dto);
		model.addAttribute("imageDto", imageDto);
		
		return "manager/updateProduct";
	}
	
	@RequestMapping(value = "/updateProductImage", method = RequestMethod.GET)
	public String updateProductImage(Model model, @RequestParam int idx) {	
		logger.info("updateProductImage 요청");
				
		//제품 이미지 정보를 가져오는 함수
		ArrayList<ProductDto> imageDto = service.productImageInfo(idx);		
		
		model.addAttribute("imageDto", imageDto);
		model.addAttribute("idx", idx);
		
		return "manager/updateProductImage";
	}
	
	@RequestMapping(value = "/makeProductCode", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> makeProductCode() {		
		
		logger.info("makeProductCode 요청");;

		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<EtcDto> brandType = service.getBrandcategory();
		ArrayList<EtcDto> bagType = service.getBagtype();
		String idx = service.getNewIdx();
		if (idx==null) {
			idx="0";
		} 
		int newIdx = Integer.parseInt(idx)+1;
		
		map.put("brandType", brandType);
		map.put("bagType", bagType);
		map.put("newIdx", newIdx);
		
		return map;
	}
	
	@RequestMapping(value = "/addimage", method = RequestMethod.GET)
	public String addimage(Model model) {	
		logger.info("addimage 요청");		
		
		return "manager/addImage";
	}	
	
	//관리자페이지 제품 리스트, 수정 관련 End ryujihong 2022.01.12
	
	//관리자페이지 제품  정보 수정 관련 Start ryujihong 2022.01.14
	@RequestMapping(value = "/doUpdateProduct", method = RequestMethod.POST)
	public String doUpdateProduct(Model model,  @RequestParam HashMap<String, String> params, HttpSession session) {	
		logger.info("doUpdateProduct 요청");		
		getCategory(session);
		ArrayList<EtcDto> brandtypeInfo = (ArrayList<EtcDto>) session.getAttribute("brandcategory");
		ArrayList<EtcDto> bagtypeInfo = (ArrayList<EtcDto>) session.getAttribute("bagtype");
		int u_idx =(int) session.getAttribute("u_idx");
		service.doUpdateProduct(params, session, brandtypeInfo, bagtypeInfo, u_idx);
		
		
		return "redirect:/productMain?num=1&brand_idx=0";
	}
	
	//이미지 삭제처리
	@RequestMapping(value = "/delImage", method = RequestMethod.GET)
	public String delImage(Model model,  @RequestParam int photoNum, @RequestParam int idx, @RequestParam String newFileName) {	
		logger.info("delImage 요청");	
		//Db에서 이미지정보삭제처리
		int result = service.delImage(photoNum, idx);
		
		//실제 저장된 이미지 삭제처리
		if (result>0) {			
			String realPath = servletContext.getRealPath("/resources/photo");
			
			try {				
				Path path = Paths.get(realPath +"/"+ newFileName);
				logger.info("실제 경로 : {}",path);
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//photo_num재설정
			ArrayList<ProductDto> dto = service.productImageInfo(idx);
			for (int i = 0; i < dto.size(); i++) {
				int newPhotoNum = i+1;
				int oriPhotoNum = dto.get(i).getPhoto_num();
				service.updatePhotoNum(newPhotoNum,oriPhotoNum) ;				
			}
		}		
		return "redirect:/updateProductImage?idx="+idx;
	}
		
	@RequestMapping(value = "/doAddImage", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doAddImage(Model model, @RequestParam int idx, 
			@RequestParam MultipartFile file, HttpSession session) {	
		logger.info("doAddImage 요청");	
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String userId = (String) session.getAttribute("userId");
		int result = service.doAddImage(idx, file, userId);
		
		map.put("result", result);
		
		return map;
		
	}	
	
	@RequestMapping(value = "/updateImageOrder")
	@ResponseBody
	public HashMap<String, Object>  updateImageOrder(HttpServletRequest request) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
	        
	    String[] newOrder = request.getParameterValues("newOrder");
	    String[] newFileName = request.getParameterValues("newFileName");
	    
	    int result = service.updateImageOrder(newOrder,newFileName);
	    if (result>0) {
	    	String resultMsg = "순서변경 성공!";
	  	    map.put("result", resultMsg);
	  	    System.out.println("Controller에서 보낸 MSG : "+ resultMsg);
		}	  
	        
	    return map;
	}
	
	//관리자페이지 제품  정보 수정 관련 End ryujihong 2022.01.14
	
	//2022.01.14 유지홍 제품 등록 관련 소스 Start
	@RequestMapping(value = "/doRegistProduct", method = RequestMethod.POST)
	public String doRegistProduct(Model model, @RequestParam HashMap<String, String> params
			,@RequestParam MultipartFile[] files, HttpSession session) {
		
		getCategory(session);
		ArrayList<EtcDto> brandtypeInfo = (ArrayList<EtcDto>) session.getAttribute("brandcategory");
		ArrayList<EtcDto> bagtypeInfo = (ArrayList<EtcDto>) session.getAttribute("bagtype");
		String userId = (String) session.getAttribute("userId");
		int brand_idx = Integer.parseInt(params.get("brand_type"));
		int bag_type = Integer.parseInt(params.get("bag_type"));
		String brand_name = null;
		String bag_name = null;
		
		
			for (int i = 0; i < brandtypeInfo.size(); i++) {
				if (brandtypeInfo.get(i).getBrand_idx()==brand_idx) {
					brand_name = brandtypeInfo.get(i).getBrand_name();
				}
			}				
			for (int i = 0; i < bagtypeInfo.size(); i++) {
				if (bagtypeInfo.get(i).getType_idx()==bag_type) {
					bag_name = bagtypeInfo.get(i).getType_name();
				}
			}		
		
		int idx = service.doRegistProduct(params, files, userId, brand_name, bag_name);		
	
		return "redirect:/productMain?num=1&brand_idx=0";
	}
	
	//2022.01.14 유지홍 제품 등록 관련 소스 End
	//각종  카테고리 정보를 가져오는 메서드 Start ryujihong 2022.01.12
	public void getCategory(HttpSession session){
		
		//각종 카테고리를 가져와 세션에 저장
		ArrayList<EtcDto> brandcategory = service.getBrandcategory();
		ArrayList<EtcDto> bagtype = service.getBagtype();
		ArrayList<EtcDto> sellflg = service.getSellflg();
		ArrayList<EtcDto> answertype = service.getAnswertype();
		ArrayList<EtcDto> newflg = service.getNewflg();
				
		session.setAttribute("newflg", newflg);
		session.setAttribute("brandcategory", brandcategory);
		session.setAttribute("bagtype", bagtype);
		session.setAttribute("sellflg", sellflg);
		session.setAttribute("answertype", answertype);	
		
	}
	//각종  카테고리 정보를 가져오는 메서드 End ryujihong 2022.01.11

}
