package com.guddi.shop.dto;

import java.sql.Date;

//각종 카테고리 관련 Dto
public class EtcDto {
	
	
//	brand_idx int(20) 브랜드번호
//	use_flg int(3) 사용여부
//	regdate date default current_date 등록일
//	brand_name varchar(30) 브랜드명
//	type_idx int(20) 종류번호
//	type_name varchar(30) 종류명

	private int brand_idx;
	private int use_flg;
	private Date regdate;
	private String brand_name;
	private int type_idx;
	private String type_name;
	private String answername;
	private int idx;
	private String sellname;
	
	
	public int getBrand_idx() {
		return brand_idx;
	}
	public void setBrand_idx(int brand_idx) {
		this.brand_idx = brand_idx;
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
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public int getType_idx() {
		return type_idx;
	}
	public void setType_idx(int type_idx) {
		this.type_idx = type_idx;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getAnswername() {
		return answername;
	}
	public void setAnswername(String answername) {
		this.answername = answername;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSellname() {
		return sellname;
	}
	public void setSellname(String sellname) {
		this.sellname = sellname;
	}
	
	
	
	
	
	

}
