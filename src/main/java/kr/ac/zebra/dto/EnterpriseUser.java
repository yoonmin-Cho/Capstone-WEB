package kr.ac.zebra.dto;

import lombok.Data;

@Data
public class EnterpriseUser {
	
	private String name;
	private String email;
	private String password;
	
	public EnterpriseUser(){
	
	}
	
	public EnterpriseUser(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String toString()
	  {
	    return "Enterprise [name=" + this.name + ", email=" + this.email + ", password=" + this.password + "]";
	  }
}
