package com.guddi.shop.dto;

import java.sql.Date;

public class EtcDto {
	//메인 베너 이미지 등록
	
	//	idx int(100) auto_increment primary key 게시물 번호
	// idx int(100) auto_increment primary key 인덱스
	//u_idx int(100) 회원번호
	//newFileName varchar(50) 저장명
	//oriFileName varchar(50) 원본명
	//use_flg int(2) 사용여부 (0=사용안함 1=사용)
	//regdate date date default current_date 등록일자
	
	private int idx;
	private int u_idx;
	private String oriFileName;
	private String newFileName;
	private int use_flg;
	private Date regdate;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public String getOriFileName() {
		return oriFileName;
	}
	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public int getUse_flg() {
		return use_flg;
	}
	public void setUse_flg(int use_flg) {
		this.use_flg = use_flg;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	//메인 베너 이미지 등록
}
