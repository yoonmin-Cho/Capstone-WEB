package kr.ac.zebra.dto;

import lombok.Data;

@Data
public class CommonUser {

	private String email;
	private String password;
	private String name;
	private String memberUrl;
	private String lastReviewDate;
	private String phoneNumber;
	private int point;
	private String level;
	private int reviewCount;
	private int totalReviewCount;

	public CommonUser(){
		
	}
	
	public CommonUser(String email, String pw, String name, String memberUrl, String lastRD, String pN, int point, String level, int rC, int tRC){
		this.email = email;
		this.password = pw;
		this.name = name;
		this.memberUrl = memberUrl;
		this.lastReviewDate = lastRD;
		this.phoneNumber = pN;
		this.point = point;
		this.level = level;
		this.reviewCount = rC;
		this.totalReviewCount = tRC;
		
	}
}
