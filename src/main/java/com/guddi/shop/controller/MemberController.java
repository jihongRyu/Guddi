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

import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.MemberDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ReviewQnaDto;
import com.guddi.shop.service.MemberService;



@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MemberService service;
	
	//Q&A Start ryujihong 2022.01.10
	@RequestMapping(value = "/qnaPage", method = RequestMethod.GET)
	public String qnaPage(Model model, @RequestParam("qnaNum") int qnaNum, @RequestParam("answer_flg") int answer_flg, 
			@RequestParam(value = "keyword",required = false, defaultValue = "")String keyword ) {		
		
		logger.info("qnaPage 요청");		
		PageDto qnaPage = new PageDto();
		
		qnaPage.setNum(qnaNum);
		qnaPage.setCount(service.qnaSearchCount(keyword, answer_flg));				
		qnaPage.setKeyword(keyword);
		
		logger.info("qnaPage.getCount() : {}",qnaPage.getCount());
		
		ArrayList<ReviewQnaDto> qnaList = 
				service.qnaInfo(qnaPage.getDisplayPost(), qnaPage.getPostNum(), keyword, answer_flg);
		
		//문의타입 한글화
		ArrayList<ReviewQnaDto> getQnaTypeInfo = service.getQnaType();
				
		//숫자를 글자로 변경. ex) 1--->상품
		for (int i = 0; i < qnaList.size(); i++) {
			int type = Integer.parseInt(qnaList.get(i).getAnswer_type());
			for (int j = 0; j < getQnaTypeInfo.size(); j++) {
				if (getQnaTypeInfo.get(j).getIdx()==type) {
					qnaList.get(i).setAnswer_type(getQnaTypeInfo.get(j).getTypename());
				}
			}
		}
		
		//답변여부 한글화
		ArrayList<ReviewQnaDto> getAnswerTypeInfo = service.getAnswerType();
						
		//숫자를 글자로 변경. ex) 1--->답변
		for (int i = 0; i < qnaList.size(); i++) {
			int type = Integer.parseInt(qnaList.get(i).getAnswer_flg());
			for (int j = 0; j < getAnswerTypeInfo.size(); j++) {
				if (getAnswerTypeInfo.get(j).getIdx()==type) {
					qnaList.get(i).setAnswer_flg(getAnswerTypeInfo.get(j).getAnswername());
				}
			}	
		}		
		
		model.addAttribute("qnaList", qnaList); //리스트 보내기
		model.addAttribute("qnaPage", qnaPage); //페이징처리
		model.addAttribute("qnaSelect", qnaNum);//페이징처리		  
		model.addAttribute("qnaKeyword", keyword); //검색어
		model.addAttribute("qnaAnswer_flg", answer_flg); //검색어
		model.addAttribute("getAnswerTypeInfo", getAnswerTypeInfo); //답변여부정보
		
		return "member/qnaPage";
	}
	
	@RequestMapping(value = "/registQna", method = RequestMethod.GET)
	public String registQna(Model model) {		
		
		logger.info("registQna 요청");
		//문의타입 리스트
		ArrayList<ReviewQnaDto> getQnaTypeInfo = service.getQnaType();
		
		model.addAttribute("getQnaTypeInfo", getQnaTypeInfo); //답변여부정보
		
		return "member/registQna";
	}
	
	@RequestMapping(value = "/doRegistQna", method = RequestMethod.POST)
	public String doRegistQna(Model model, @RequestParam HashMap<String, String> params, HttpSession session) {		
		
		logger.info("doRegistQna 요청");
		
		service.doRegistQna(params, session);		
		
		return "redirect:/qnaPage?qnaNum=1&answer_flg=2";
	}
	
	@RequestMapping(value = "/qnaDetail", method = RequestMethod.GET)
	public String qnaDetail(Model model, @RequestParam String idx) {		
		
		logger.info("registQna 요청 idx : {}",idx);
		
		ReviewQnaDto dto = service.getQnaDetail(idx);
		ReviewQnaDto aDto = service.getQnaAnswerDetail(idx);
		
		//문의타입 한글화
		ArrayList<ReviewQnaDto> getQnaTypeInfo = service.getQnaType();
		
		//숫자를 글자로 변경. ex) 1--->상품
		int type = Integer.parseInt(dto.getAnswer_type());
		for (int i = 0; i < getQnaTypeInfo.size(); i++) {
			if (getQnaTypeInfo.get(i).getIdx()==type) {
				dto.setAnswer_type(getQnaTypeInfo.get(i).getTypename());
			}
		}		
		model.addAttribute("dto", dto);
		model.addAttribute("qDto", aDto);
		
		return "member/qnaDetail";
	}
	
	@RequestMapping(value = "/deleteQna", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> deleteQna(@RequestParam String idx) {		
		
		logger.info("deleteQna 요청");;

		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = service.deleteQna(idx);
		if (result>0) {
			map.put("result", result);		
		}else {
			map.put("result", 0);		
		}		
		return map;
	}
	
	@RequestMapping(value = "/updateQna", method = RequestMethod.GET)
	public String updateQna(Model model, @RequestParam String idx) {		
		
		logger.info("updateQna 요청 idx : {}",idx);
		
		ReviewQnaDto dto = service.getQnaDetail(idx);
		ReviewQnaDto aDto = service.getQnaAnswerDetail(idx);
		
		//문의타입 한글화
		ArrayList<ReviewQnaDto> getQnaTypeInfo = service.getQnaType();
		
		//숫자를 글자로 변경. ex) 1--->상품
		int type = Integer.parseInt(dto.getAnswer_type());
		for (int i = 0; i < getQnaTypeInfo.size(); i++) {
			if (getQnaTypeInfo.get(i).getIdx()==type) {
				dto.setAnswer_type(getQnaTypeInfo.get(i).getTypename());
			}
		}		
		model.addAttribute("dto", dto);
		model.addAttribute("qDto", aDto);
		
		return "member/updateQna";
	}
	
	@RequestMapping(value = "/checkAnswer", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> checkAnswer(@RequestParam String idx) {		
		
		logger.info("checkAnswer 요청");;

		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = service.checkAnswer(idx);
		
		map.put("result", result);		
		
		return map;
	}
	
	@RequestMapping(value = "/doUpdateQna", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doUpdateQna(@RequestParam HashMap<String, String> params) {		
		
		logger.info("checkAnswer 요청");

		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = service.doUpdateQna(params);
		
		map.put("result", result);		
		
		return map;
	}
	//Q&A end ryujihong 2022.01.10
	//고객정보수정,탈퇴관련, 마이페이지내 리뷰관련 Start ryujihong 2022.01.10
	//마이페이지 관련
		@RequestMapping(value = "/myPage", method = RequestMethod.GET)
		public String myPage(Model model, HttpSession session, 
				@RequestParam(value="orderNum") int orderNum, @RequestParam(value="reviewNum") int reviewNum,
				@RequestParam(value="orderSearchType",required=false) String orderSearchType,
				@RequestParam(value="orderKeyword",required=false) String orderKeyword,
				@RequestParam(value="reviewSearchType",required=false) String reviewSearchType,
				@RequestParam(value="reviewKeyword",required=false) String reviewKeyword			
				) {
			
			logger.info("myPage 요청");
			logger.info("reviewNum : {}",reviewNum);
			logger.info("orderKeyword : {}",orderKeyword);
			String userId = (String) session.getAttribute("userId");
			
							
			//마이페이지 내정보 관련
			MemberDto dto = service.findInfo(userId);		
			model.addAttribute("info", dto);
			
			//마이페이지 주문정보 관련
			PageDto orderPage = new PageDto();		
			orderPage.setNum(orderNum);
			orderPage.setCount(service.orderSearchCount(orderSearchType, orderKeyword, userId));		
			orderPage.setSearchType(orderSearchType);
			orderPage.setKeyword(orderKeyword);
			
			ArrayList<CartDto> orderList = 
					service.myPageOrderInfo(orderPage.getDisplayPost(), orderPage.getPostNum(), orderSearchType, orderKeyword, userId);
			
			//총가격 계산
			int totalPrice = 0;
			for (int i = 0; i < orderList.size(); i++) {			
				int price = Integer.parseInt(orderList.get(i).getPrice());
				int quantity = orderList.get(i).getQuantity();			
				totalPrice += price*quantity;
			}				
			
			model.addAttribute("totalPrice", totalPrice); //총가격
			model.addAttribute("orderList", orderList); //리스트 보내기
			model.addAttribute("orderPage", orderPage); //페이징처리
			model.addAttribute("orderSelect", orderNum);//페이징처리		  
			model.addAttribute("orderKeyword", orderKeyword); //검색어
			
			//마이페이지 리뷰정보관련
			PageDto reviewPage = new PageDto();
			reviewPage.setNum(reviewNum);
			reviewPage.setCount(service.reviewSearchCount(reviewSearchType, reviewKeyword, userId));		
			reviewPage.setSearchType(orderSearchType);
			reviewPage.setKeyword(orderKeyword);
			
			ArrayList<ReviewQnaDto> reviewList = 
					service.myPageReviewInfo(reviewPage.getDisplayPost(), reviewPage.getPostNum(), reviewSearchType, reviewKeyword, userId);
					
			model.addAttribute("reviewList", reviewList); //리스트 보내기
			model.addAttribute("reviewPage", reviewPage); //페이징처리
			model.addAttribute("reviewSelect", reviewNum);//페이징처리		  
			model.addAttribute("reviewKeyword", reviewKeyword); //검색어
			
			return "member/myPage";
		}
		
		@RequestMapping(value = "/checkPassword", method = RequestMethod.GET)
		public String checkPassword(Model model, @RequestParam String userId) {		
			
			logger.info("checkPassword 요청");		
			MemberDto dto = service.findInfo(userId);
			model.addAttribute("info", dto);
			
			return "member/checkPassword";
		}
		
		@RequestMapping(value = "/doPwCheck", method = RequestMethod.POST)
		@ResponseBody
		public HashMap<String, Object> doPwCheck(Model model, @RequestParam String userId, String password) {		
			
			logger.info("doPwCheck 요청");
			
			return service.doPwCheck(userId, password);
		}
			
		@RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
		public String changeInfo(Model model,@RequestParam String userId ) {		
			
			logger.info("changeInfo 요청");

			MemberDto dto = service.findInfo(userId);
			model.addAttribute("info", dto);
			
			return "member/changeInfo";
		}
		
		@RequestMapping(value = "/doChangeInfo", method = RequestMethod.POST)
		public String doChangeInfo(Model model, @RequestParam HashMap<String, String> params) {		
			
			logger.info("doMemberWrite 요청");
			
			service.updateInfo(params);
			
			return "redirect:/myPage?userId="+params.get("userId");
		}
			
		@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
		@ResponseBody
		public HashMap<String, Object> deleteUser(Model model, @RequestParam String userId) {
		
			HashMap<String, Object> map = new HashMap<String, Object>();
			logger.info("회원탈퇴 요청");
			int result = service.delete(userId);
			
			boolean check = result > 0? true:false;
			map.put("result", check);
			
			return map;
		}	
		
		@RequestMapping(value = "/reviewDetail", method = RequestMethod.GET)
		public String reviewDetail(Model model, @RequestParam String idx) {		
			
			logger.info("reviewDetail 요청");
			
			ReviewQnaDto dto = service.getReviewDetail(idx);
			ReviewQnaDto aDto = service.getReviewAnswerDetail(idx);
			
			model.addAttribute("dto", dto);
			model.addAttribute("aDto", aDto);
			
			return "member/reviewDetail";
		}
		
		@RequestMapping(value = "/delReview", method = RequestMethod.GET)
		public String delReview(Model model, @RequestParam String idx, HttpSession session) {		
			
			logger.info("reviewDetail 요청");
			
			service.delReview(idx);		
			
			return "redirect:/myPage?userId="+session.getAttribute("userId")+"&orderNum=1&reviewNum=1";
		}	
	//고객정보수정,탈퇴관련, 마이페이지내 리뷰관련 End ryujihong 2022.01.10

}
