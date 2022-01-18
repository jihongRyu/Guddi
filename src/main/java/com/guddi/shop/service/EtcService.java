package com.guddi.shop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guddi.shop.dao.EtcDao;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.MemberDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.dto.ReviewQnaDto;


@Service
public class EtcService {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired EtcDao dao;
	@Autowired ServletContext servletContext;
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 Start
	public ArrayList<EtcDto> getNewFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getNewFlgInfo();
	}

	public int doRegistNewFlg(String newname) {
		// TODO Auto-generated method stub
		int idx = dao.getNewFlgIdx();
		int newIdx = idx+1;
		return dao.doRegistNewFlg(newIdx ,newname);
	}

	public int doUpateUseFlg(int use_flg, int idx) {
		// TODO Auto-generated method stub
		return dao.doUpateUseFlg(use_flg,idx);
	}

	public ArrayList<EtcDto> getUseFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getUseFlgInfo();
	}

	// 신상여부 카테고리 관련  유지홍 2022.01.17 End
	


	public ArrayList<EtcDto> getSellFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getSellFlgInfo();
	}

	public int doRegistSellFlg(String sellname) {
		// TODO Auto-generated method stub
		int idx = dao.getSellFlgIdx();
		int newIdx = idx+1;
		return dao.doRegistSellFlg(newIdx, sellname);
	}

	public int doUpdateSellUseFlg(int use_flg, int idx) {
		// TODO Auto-generated method stub
		return dao.doUpdateSellUseFlg(use_flg, idx);
	}
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 End
	
	
	// 메인이미지 제어  유지홍 2022.01.18 Start
	public ArrayList<EtcDto> getMainImageList() {
		// TODO Auto-generated method stub
		return dao.getMainImageList();
	}

	public ArrayList<MemberDto> getUserInfo() {
		// TODO Auto-generated method stub
		return dao.getUserInfo();
	}

	public int getMainImageIdx() {
		// TODO Auto-generated method stub
		return dao.getMainImageIdx();
	}

	public int doAddMainImage(int idx, int u_idx, MultipartFile file) {
		// TODO Auto-generated method stub
		
		int result = 0;
		//저장 경로
		String realPath = servletContext.getRealPath("/resources/photo");
				
		String oriFileName = file.getOriginalFilename();
		if (oriFileName.lastIndexOf(".")>0) {
			String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
			String newFileName = System.currentTimeMillis() + ext;
			logger.info(oriFileName +" >>>> "+ newFileName);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			EtcDto pdto = new EtcDto();
			
			pdto.setNewFileName(newFileName);
			pdto.setOriFileName(oriFileName);
			pdto.setIdx((idx+1));
			pdto.setU_idx(u_idx);
			
			
			//이미지 DB에 등록
			result = dao.doRegistMainImage(pdto);
						
			if (result>0) {
				
				try {
					byte[] bytes = file.getBytes();
					Path path = Paths.get(realPath +"/"+ newFileName);
					Files.write(path, bytes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}	
		}
		
		return result;
		
	}

	public int getU_idx(String userId) {
		// TODO Auto-generated method stub
		return dao.getU_idx(userId);
	}

	public void delMainImage(int idx) {
		// TODO Auto-generated method stub
		dao.delMainImage(idx);
	}

	public int doUpdateImageUseFlg(int use_flg, int idx) {
		// TODO Auto-generated method stub
		return dao.doUpdateImageUseFlg(use_flg,idx);
	}

	public int updateImageOrder(String[] newOrder, String[] newFileName) {
		// TODO Auto-generated method stub
		int success = 0;
		for (int i = 0; i < newOrder.length; i++) {
			dao.updateImageOrder(Integer.parseInt(newOrder[i]), newFileName[i]);
			success++;
		}
		
		return success;
	}

	public int reviewSearchCount(String keyword, int answer_flg, String brandName, String bagName) {
		// TODO Auto-generated method stub
		EtcDto dto = new EtcDto();
		dto.setKeyword(keyword);
		dto.setAnswer_flg(answer_flg);
		dto.setBrand_name(brandName);
		dto.setType_name(bagName);
		
		return dao.reviewSearchCount(dto);
	}

	public ArrayList<ReviewQnaDto> reviewInfo(int displayPost, int postNum, String keyword, int answer_flg,
			String brandName, String bagName) {
		// TODO Auto-generated method stub
		PageDto dto = new PageDto();
		dto.setDisplayPost(displayPost);
		dto.setPostNum(postNum);
		dto.setKeyword(keyword);
		dto.setAnswer_flg(answer_flg);
		dto.setBrand_name(brandName);
		dto.setBag_name(bagName);
		return dao.reviewInfo(dto);
	}

	public ArrayList<EtcDto> getbagCategoryList() {
		// TODO Auto-generated method stub
		return dao.getbagCategoryList();
	}

	public ArrayList<EtcDto> getbrandCategoryList() {
		// TODO Auto-generated method stub
		return dao.getbrandCategoryList();
	}

	public ArrayList<EtcDto> getanswerList() {
		// TODO Auto-generated method stub
		return dao.getanswerList();
	}

	public ReviewQnaDto getReviewDetail(int idx) {
		// TODO Auto-generated method stub
		return dao.getReviewDetail(idx);
	}

	public ReviewQnaDto getReviewAnswer(int idx) {
		// TODO Auto-generated method stub
		return dao.getReviewAnswer(idx);
	}

	public int doReviewAnswer(ReviewQnaDto dto) {
		// TODO Auto-generated method stub
		return dao.doReviewAnswer(dto);
	}

	public void doDelReviewAnswer(int a_idx) {
		// TODO Auto-generated method stub
		dao.doDelReviewAnswer(a_idx);
	}

	public void doUpdateReviewAnswer(ReviewQnaDto dto) {
		// TODO Auto-generated method stub
		dao.doUpdateReviewAnswer(dto);
	}
	
	// 메인이미지 제어  유지홍 2022.01.18 End

}
