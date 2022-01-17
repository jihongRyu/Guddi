package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.MemberDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ReviewQnaDto;


public interface MemberDao {
	
	//Q&A관련 start ryujihong 2022.01.10
	int qnaSearchCount(PageDto dto);	

	ArrayList<ReviewQnaDto> qnaInfo(PageDto dto);

	int doRegistQna(ReviewQnaDto dto);

	ReviewQnaDto getQnaDetail(String idx);

	ReviewQnaDto getQnaAnswerDetail(String idx);

	ArrayList<ReviewQnaDto> getQnaType();

	ArrayList<ReviewQnaDto> getAnswerType();

	int deleteQna(String idx);

	int doUpdateQna(ReviewQnaDto dto);	

	int checkAnswer(String idx);
	//Q&A관련 end ryujihong 2022.01.10
	//정보수정, 마이페이지 관련 start ryujihong 2022.01.10
	MemberDto findInfo(String userId);

	String doPwCheck(String userId, String password);

	void updateInfo(MemberDto dto);	

	int delete(String userId);
	
	int orderSearchCount(PageDto dto);	

	int reviewSearchCount(PageDto dto);

	ArrayList<CartDto> myPageOrderInfo(PageDto dto);

	ArrayList<ReviewQnaDto> myPageReviewInfo(PageDto dto);

	ReviewQnaDto getReviewDetail(String idx);

	ReviewQnaDto getReviewAnswerDetail(String idx);

	void delReview(String idx);	
	//로그인 관련 end ryujihong 2022.01.10
	//cart장바구니 제품목록 select --ysh 
	
	MemberDto toLogin(MemberDto sdto);
	
	//회원가입 start 2022.01.10	
	void write(MemberDto dto);

	String idCheck(String param);
	//회원가입 end 2022.01.12


	String doFindMemberId(String name, String email);

	String temppasslogin(String userId, String email);

	void temppassloginPw(String userId, String temppw);

	String tempPass(String userpass);

	int HeadergetCart(String userId);

	ArrayList<CartDto> getTotalPrice(String userId);


}
