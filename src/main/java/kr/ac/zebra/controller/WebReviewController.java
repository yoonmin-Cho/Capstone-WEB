package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.WebReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebReviewController {

	private WebReviewService webReviewService;
	
	@Autowired
	public void setService(WebReviewService webReviewService){
		this.webReviewService = webReviewService;
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String showReviewPage(Model model, HttpServletRequest request){
		
		String barcode = request.getParameter("barcode");

		//Get Review List by review table - use product barcode 
		List<Review> reviews = webReviewService.getReviews(barcode);
		model.addAttribute("reviews", reviews);
		
		//Get Star point List by review table
		List<Integer> starPoints = webReviewService.getStarPoints(barcode);
		model.addAttribute("starPoints", starPoints);
		
		return "review";
	}
}