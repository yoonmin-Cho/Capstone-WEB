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
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public String showProductPage(Model model, HttpSession session, HttpServletRequest request){
		
		//Initial category / subCategory value
		String category = request.getParameter("category");
		String subCategory = request.getParameter("sub");
	
		session.setAttribute("category", category);
		session.setAttribute("subCategory", subCategory);
	
		return "product";
	}
	
	@RequestMapping(value="/mostPopular")
	public String showPopularProduct(Model model, HttpServletRequest request){
	
		String category = request.getParameter("category");
		List<Product> popularProducts = webProductService.getPopularProducts(category);
		
		model.addAttribute("popularProducts", popularProducts);
		
		return "mostPopular";
	}
	
	@RequestMapping(value="/mostReview")
	public String showReviewProduct(Model model, HttpServletRequest request){
	
		String category = request.getParameter("category");
		List<Product> reviewProducts = webProductService.getReviewProducts(category);
		
		model.addAttribute("reviewProducts", reviewProducts);
		
		return "mostReview";
	}
	
	@RequestMapping(value="/mostScan")
	public String showScanProduct(Model model, HttpServletRequest request){
		
		String category = request.getParameter("category");
		List<Product> scanProducts = webProductService.getScanProducts(category);
		
		model.addAttribute("scanProducts", scanProducts);
		
		return "mostScan";
	}
	/*
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String showSearchResult(){
		
		return 
	}
	*/
	
	
}