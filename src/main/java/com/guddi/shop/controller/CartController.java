package com.guddi.shop.controller;


import java.util.ArrayList;
import java.util.HashMap;

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

import com.guddi.shop.dao.CartDao;
import com.guddi.shop.dto.CartDto;
import com.guddi.shop.service.CartService;



@Controller
public class CartController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired CartService service;
	@Autowired CartDao dao;

	
	// =====cart controller 추가하기 수정 START YuSeonhwa===== 220112
	
	
	
//	@RequestMapping(value = "/cart", method = RequestMethod.GET)
//	public String doRegistQna(Model model, @RequestParam HashMap<String, String> params, HttpSession session) {		
//		
//		logger.info("cart 요청");
//		service.doRegistQna(params, session);
//		return "/cart/userCart";
//	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(Model model , HttpSession session) {
		logger.info("cart 페이지 요청");
		String userId = (String) session.getAttribute("userId");// 로그인 미완성으로 아이디를 session에 그냥 넣어줌 - 실행했는데 아이디가 넘어가지 않는다. 
		logger.info("userId : {}", userId);
		if (userId!=null) {
			ArrayList<CartDto> list = service.getCartInfo(userId);
			
			//ArrayList<CartDto> listImg = service.getCartInfoImg(userId);
			
			logger.info("상품코드 : {}",list.get(0).getProduct_name());
			model.addAttribute("list", list);
			//model.addAttribute("listImg", listImg);
			
			model.addAttribute("userId", userId);
		}
		return "cart/userCart";
	}

	@RequestMapping(value = "/delCart", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delCart(@RequestParam String idx, HttpSession session) {		
		
		logger.info("delCart 요청");
		CartDto dto = new CartDto();		
		String userId = (String) session.getAttribute("userId");
		dto.setUserId(userId);		
		dto.setIdx(idx);
		
		int result = service.delCart(dto);		
		HashMap<String, Object> map = new HashMap<String, Object>();
		logger.info("카트 담기 성공 유무 : {}", result);
		if (result>0) {			
			map.put("result", result);		
			int cartCnt = service.getCart(userId);//카트수 가져오기
			logger.info("카트 수 : {}", cartCnt);
		}else {
			map.put("result", 0);		
		}
				
		return map;
	}
	@RequestMapping(value = "cartupdate", method = RequestMethod.POST)
	public String cartupdate(Model model , HttpSession session,@RequestParam int quantity,@RequestParam String product_code,@RequestParam String userId) {
		logger.info("cart/update");
		
		CartDto dto = new CartDto();
		logger.info(quantity+"/"+product_code+"/"+userId);
		String userIdsession = (String) session.getAttribute("userId");
		//if(dto.getUserId() ==userIdsession) { // 세션에있는 id와 받아온 id가 같으면 서비스실행
			dto.setQuantity(quantity);
			dto.setProduct_code(product_code);
			dto.setUserId(userId);
			int cartCnt = service.cartupdate(dto);
			logger.info("변경여부 : {}", cartCnt);
		//}else {
			logger.info("세션에있는 아이디와 로그인한 아이디가 다름");
		//}
		
		
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/completeOrder", method = RequestMethod.GET)
	public String completeOrder(Model model, HttpSession session ) {

		logger.info("주문완료페이지 요청");


		return "cart/completeOrder";
	}
	
	

	@RequestMapping(value = "/chkdelete", method = RequestMethod.POST)
	@ResponseBody // 컨트롤러에서 요청을 받아와 반환된 값을 jsp에 넘겨줄때 언어가 달라 json라이브러리를 추가했고 @ResponseBody 어노테이션을 사용해 hashMAp데이터 타입으로 뷰에서 읽을수 있게 처리해 줬습니다.
	public HashMap<String,Object> chkdelete(
			@RequestParam (value="delList[]") ArrayList<String> delList 
			) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		
		logger.info("delList : {}",delList); 
		
		int delCnt = delList.size();// 1. 삭제할 갯수 확인 
		int row = service.chkdelete(delList);	// 2. 삭제 완료된 갯수 확인
		// 3. 1번과 2번이 같으면 완료
		map.put("msg", delCnt+"개 요청 중 "+row+"개 를 삭제 하였습니다.");
		
		return map;
	}
	
	//order 추가 21-01-14

	@RequestMapping(value = "toOrder", method = RequestMethod.GET)
	public String toOrder(Model model) {
		logger.info("toOrder Click");
		
		
		return "cart/toOrder";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public HashMap<String, Object> toOrder(Model model,HashMap<String, Object> checkoutmap,@RequestParam String userId, @RequestParam String checkoutPrice) {
		
		logger.info("checkout");
		String[] arrayInfo = null;
		String code = checkoutmap.get("arrayParam").toString();
		
		arrayInfo = code.split(",");
		int[] results= new int[arrayInfo.length];
        int result=1;

        HashMap<String, Object> resendMap = new HashMap<String, Object>();
        for(int i=0; i < arrayInfo.length; i++){
	         
            resendMap.put("code", arrayInfo[i]);  
            resendMap.put("no", checkoutmap.get("idx")); 
            resendMap.put("date", checkoutmap.get("item"));
	        
            results[i] = dao.checkout(resendMap); 
            result *= results[i];
        }
        CartDto dto = service.findInfo(userId);
		model.addAttribute("info", dto);
		model.addAttribute("checkoutPrice",checkoutPrice);
		
		return resendMap;
	}
	
	
	
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//주문하기 페이지로 이동 //////////////////////////////////////////////
//	@RequestMapping(value = "/order/${list.userId}", method = RequestMethod.GET)
//	public String order(Model model , HttpSession session) {
//		
//		return "order";
//	}
//	
//	
//	/////////////////
//	@RequestMapping(value = "/checkedDelete", method = RequestMethod.GET)
//	@ResponseBody // 컨트롤러에서 요청을 받아와 반환된 값을 jsp에 넘겨줄때 언어가 달라 json라이브러리를 추가했고 @ResponseBody 어노테이션을 사용해 hashMAp데이터 타입으로 뷰에서 읽을수 있게 처리해 줬습니다.
//	public HashMap<String,Object> checkedDelete(
//			@RequestParam (value="delList[]") ArrayList<String> delList 
//			) {
//		HashMap<String,Object> map = new HashMap<String, Object>();
//		
//		logger.info("delList : {}",delList); 
//		
//		int delCnt = delList.size();// 1. 삭제할 갯수 확인 
//		int row = service.checkedDelete(delList);	// 2. 삭제 완료된 갯수 확인
//		// 3. 1번과 2번이 같으면 완료
//		map.put("msg", delCnt+"개 요청 중 "+row+"개 를 삭제 하였습니다.");
//		
//		return map;
//	}
//	//////////////////////////////////////////////////////////////////
	
	// =====cart controller 추가하기 수정 END YuSeonhwa===== 220115
	
}
