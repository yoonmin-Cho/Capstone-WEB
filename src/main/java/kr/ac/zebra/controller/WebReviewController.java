package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.WebProductService;
import kr.ac.zebra.service.WebReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebReviewController {

	private WebReviewService webReviewService;
	private WebProductService webProductService;
	
	@Autowired
	public void setService(WebReviewService webReviewService,WebProductService webProductService){
		this.webReviewService = webReviewService;
		this.webProductService = webProductService;
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String showReviewPage(Model model, HttpServletRequest request, HttpSession session){
		
		String barcode = request.getParameter("barcode");

		//Get Product Star Point 
		int productStarPoint = webReviewService.getStarPoint(barcode);
		request.setAttribute("productStarPoint", productStarPoint);
		
		Product productInfo = webProductService.getProduct(barcode);
		model.addAttribute("productInfo", productInfo);
		
		//Get Review List by review table - use barcode 
		List<Review> reviews = webReviewService.getReviews(barcode);
		request.setAttribute("reviews", reviews);	
		model.addAttribute("reviews", reviews);
		
		//Get Star point List by review table
		List<Integer> starPoints = webReviewService.getStarPoints(barcode);
		request.setAttribute("starPoints", starPoints);
		
		//side product 
		String category = (String)session.getAttribute("category");
		List<Product> similarProducts = webProductService.getPopularProducts(category);
		request.setAttribute("similarProducts", similarProducts);
		model.addAttribute("similarProducts", similarProducts);
		
		return "review";
	}
}