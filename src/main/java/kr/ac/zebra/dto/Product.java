package kr.ac.zebra.dto;

import lombok.Data;

@Data
public class Product {

	private String barcode;
	private String productName;
	private String description;
	private String category;
	private String productUrl;
	private String companyName;
	private int scanCount;
	private int totalReviewCount;
	private int starPoint;
	
	public Product() {

	}

	public Product(String barcode, String productName, String description,
			String category, String productUrl, String companyName,
			int scanCount, int totalReviewCount, int starPoint) {
		this.barcode = barcode;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.productUrl = productUrl;
		this.companyName = companyName;
		this.scanCount = scanCount;
		this.totalReviewCount = totalReviewCount;
		this.starPoint = starPoint;
	}
}