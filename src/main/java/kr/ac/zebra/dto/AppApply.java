package kr.ac.zebra.dto;

import lombok.Data;

@Data
public class AppApply {
	
	private String barcode;
	private String email;
	private String productName;
	private String companyName;
	
	public AppApply(){
		
	}
	
	public AppApply(String barcode, String email, String productName, String companyName){
		this.barcode = barcode;
		this.email = email;
		this.productName = productName;
		this.companyName = companyName;
	}
}
