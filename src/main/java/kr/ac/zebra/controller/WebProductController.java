package kr.ac.zebra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.WebProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebProductController {

	private WebProductService webProductService;
	
	@Autowired
	public void setService(WebProductService webProductService){
		this.webProductService = webProductService;
	}
	
	/*
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearchResult(){
		
		return 
	}
	*/
	
	@RequestMapping(value="/product")
	public String showProductPage(Model model, HttpSession session, HttpServletRequest request){
		//Initial category / subCategory value
		session.setAttribute("category", "0");
		session.setAttribute("subCategory", "0");
	
		return "product";
	}
	
	
}