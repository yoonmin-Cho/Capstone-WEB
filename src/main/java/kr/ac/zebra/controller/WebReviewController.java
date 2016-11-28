package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.WebProductService;
import kr.ac.zebra.service.WebReviewService;

@Controller
public class WebReviewController {

	private WebReviewService webReviewService;
	private WebProductService webProductService;
	
	@Autowired
	public void setService(WebReviewService webReviewService, WebProductService webProductService){
		this.webReviewService = webReviewService;
		this.webProductService = webProductService;
	}
	
	@RequestMapping(value="/review")
	public String showReviewPage(HttpServletRequest request, Model model, HttpSession session){
		
		String barcode = request.getParameter("barcode");
		
		List<Review> reviews = webReviewService.getReviews(barcode);
		request.setAttribute("reviews", reviews);	
		model.addAttribute("reviews", reviews);
		
		Product productInfo = webProductService.getProduct(barcode);
		model.addAttribute("productInfo", productInfo);
		
		int productStarPoint = webReviewService.getStarPoint(barcode);
		request.setAttribute("productStarPoint", productStarPoint);
		
		List<Integer> starPoints = webReviewService.getStarPoints(barcode);
		request.setAttribute("starPoints", starPoints);
		
		//side product 
		String category = (String)session.getAttribute("category");
		List<Product> similarProducts = webProductService.getPopularProduct(category);
		request.setAttribute("similarProducts", similarProducts);
		model.addAttribute("similarProducts", similarProducts);
			
		return "review";
	}
	
	@RequestMapping(value="/reviewPurchase")
	public String showReviewPurchase(HttpServletRequest request, Model model, HttpSession session){
		
		String barcode = request.getParameter("barcode");
		
		List<Review> reviews = webReviewService.getReviews(barcode);
		request.setAttribute("reviews", reviews);	
		model.addAttribute("reviews", reviews);
		
		Product productInfo = webProductService.getProduct(barcode);
		model.addAttribute("productInfo", productInfo);
		
		session.setAttribute("productName", productInfo.getProductName());
		
		int productStarPoint = webReviewService.getStarPoint(barcode);
		request.setAttribute("productStarPoint", productStarPoint);
		
		List<Integer> starPoints = webReviewService.getStarPoints(barcode);
		request.setAttribute("starPoints", starPoints);
		
		//side product 
		String category = (String)session.getAttribute("category");
		List<Product> similarProducts = webProductService.getPopularProduct(category);
		request.setAttribute("similarProducts", similarProducts);
		model.addAttribute("similarProducts", similarProducts);
		
		return "reviewPurchase";
	}
	
}
