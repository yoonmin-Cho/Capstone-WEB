package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.AppProductService;
import kr.ac.zebra.service.AppReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppReviewController {

	private AppReviewService appReviewService;
	private AppProductService appProductService;
	
	@Autowired 
	public void setService(AppReviewService appReviewService){
		this.appReviewService = appReviewService;
	}
	
	@RequestMapping(value="/appReviewRegister")
	public String productReviewRegister(HttpServletRequest request){
		
		String email = request.getParameter("eamil");
		String barcode = request.getParameter("barcode");
		String reviewText = request.getParameter("reviewText");
		int starPoint = Integer.parseInt(request.getParameter("starPoint"));
		String memberUrl = request.getParameter("memberUrl");
		String productUrl = request.getParameter("productUrl");
		String level = request.getParameter("level");
		
		if(appReviewService.checkAvailable(email,barcode)){
			appReviewService.setReview(email, barcode, reviewText, starPoint, memberUrl, productUrl, level);
			List<Review> reviews = appReviewService.getReviewByBarcode(barcode);
			Product product = appProductService.getProductByBarcode(barcode);
			
			request.setAttribute("reviews", reviews);
			request.setAttribute("product", product);
			
			return "appScan";
		}
		
		request.setAttribute("result", "reviewRegisterFail");
		return "appError";
	}
	
	@RequestMapping(value="/appShowMyReview")
	public String showMyReview(HttpServletRequest request){
		
		String email = request.getParameter("email");
		
		List<Review> myReviewList = appReviewService.getReviewOfUser(email);
		request.setAttribute("reviews", myReviewList);
		
		return "appShowMyReview";
	}
}
