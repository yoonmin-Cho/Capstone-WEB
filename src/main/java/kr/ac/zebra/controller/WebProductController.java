package kr.ac.zebra.controller;

import kr.ac.zebra.service.WebProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebProductController {

	private WebProductService webProductService;
	
	@Autowired
	public void setService(WebProductService webProductService){
		this.webProductService = webProductService;
	}
	
	@RequestMapping(value="/product")
	public String showProductPage(){
		return "product";
	}
	
	/*
	@RequestMapping(value="/category")
	public String showCategory(){
		
	}
	*/
}
