package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.zebra.service.WebProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebProductController {

	private WebProductService webProductService;
	
	@Autowired
	public void setService(WebProductService webProductService){
		this.webProductService = webProductService;
	}
	
	@RequestMapping(value="/product")
	public String showProductPage(HttpSession session, HttpServletRequest request){
		//get category value and save in the session
		String category = request.getParameter("category");
		session.setAttribute("currentCategory", category);
		
		return "product";
	}
	
	/*
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearchResult(){
		
		return 
	}
	*/
}
