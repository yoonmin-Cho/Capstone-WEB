package kr.ac.zebra.dto;

import lombok.Data;

@Data
public class EnterpriseUser {
	
	private String companyName;
	private String email;
	private String password;
	
	public EnterpriseUser(){
	
	}
	
	public EnterpriseUser(String companyName, String email, String password){
		this.companyName = companyName;
		this.email = email;
		this.password = password;
	}
	
	public String toString()
	  {
	    return "Enterprise [companyName=" + this.companyName + ", email=" + this.email + ", password=" + this.password + "]";
	  }
}
