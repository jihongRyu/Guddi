package com.guddi.shop.dto;

import java.sql.Date;

public class CartDto {
	

	
//	idx int(100) auto_increment primary key 순서
//	u_idx int(100) 회원번호
//	userId varchar(20) 주문자 아이디
//	product_name varchar(20)  제품명
//	product_code varchar(20) 제품코드
//	price int(20)  가격
//	quantity  int(10) 수량
//	username varchar(10) 이름
//	phone varchar(20) 전화번호
//	email varchar(20) 이메일
//	zipcode varchar(10) 우편번호
//	address varchar(30) 주소
//	address_detail varchar(30) 상세주소
//	regdate date default current_date 주문 날짜
//	order_num varchar(30) 주문번호
	
	
	private String idx;
	private String userId;
	private String username;
	private String product_name;
	private String product_code;
	private String price;
	private String totalPrice;
	private int quantity ;
	private String newFileName;
	private String phone;
	private String email;
	private String zipcode;
	private String address;
	private String address_detail;
	private Date regdate;
	private String order_num;
	
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	

}
