package kr.ac.zebra.dto;

import lombok.Data;

@Data
public class Review {

	private String email;
	private String barcode;
	private String reviewText;
	private double starPoint;
	private String level;
	private String memberUrl;
	private String productUrl;

	public Review() {

	}

	public Review(String email, String barcode, String reviewText,
			double starPoint, String level, String memberUrl, String productUrl) {
		this.email = email;
		this.barcode = barcode;
		this.reviewText = reviewText;
		this.starPoint = starPoint;
		this.level = level;
		this.memberUrl = memberUrl;
		this.productUrl = productUrl;
	}
}