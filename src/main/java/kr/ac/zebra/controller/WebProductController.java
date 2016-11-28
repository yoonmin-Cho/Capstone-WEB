package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.WebProductService;

@Controller
public class WebProductController {

	private WebProductService webProductService;
	
	@Autowired
	public void setService(WebProductService webProductService){
		this.webProductService = webProductService;
	}
	
	@RequestMapping(value="/mostPopularProduct")
	public String showPopularProduct(HttpServletRequest request, HttpSession session, Model model){
		
		String category = request.getParameter("category");
		session.setAttribute("category", category);
		
		List<Product> products = webProductService.getPopularProduct(category);
		model.addAttribute("popularProductModel", products);
		
		return "mostPopularProduct";
	}

	@RequestMapping(value="/mostReviewProduct")
	public String showMostReviewProduct(HttpServletRequest request, HttpSession session, Model model){
		
		String category = request.getParameter("category");
		session.setAttribute("category", category);
		
		List<Product> products = webProductService.getMostReviewProduct(category);
		model.addAttribute("mostReviewProductModel", products);
		
		return "mostReviewProduct";
	}
	
	@RequestMapping(value="/mostScanProduct")
	public String showMostScanProduct(HttpServletRequest request, HttpSession session, Model model){
		
		String category = request.getParameter("category");
		session.setAttribute("category", category);
		
		List<Product> products = webProductService.getMostScanProduct(category);
		model.addAttribute("mostScanProductModel", products);
		
		return "mostScanProduct";
	}
	
	@RequestMapping(value="/search")
	public String showSearchProduct(HttpServletRequest request, Model model){
		
		String keyword = request.getParameter("keyword");
		List<Product> products = webProductService.getSearchProduct(keyword);
		
		model.addAttribute("popularProductModel", products);
		
		return "mostPopularProduct";
	}
}
