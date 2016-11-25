package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.dto.Review;
import kr.ac.zebra.service.AppProductService;
import kr.ac.zebra.service.AppReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppScanController {

	private AppProductService appProductService;
	private AppReviewService appReviewService;
	
	@Autowired
	public void setService(AppProductService appProductService, AppReviewService appReviewService){
		this.appProductService = appProductService;
		this.appReviewService = appReviewService;
	}
	
	@RequestMapping(value="/appScan")
	public String showScanPage(HttpServletRequest request){
		
		String barcode = request.getParameter("barcode");
		      
		Product product = appProductService.getProductByBarcode(barcode);
		List<Review> reviews = appReviewService.getReviewByBarcode(barcode);
		    
		if (product == null){
			AppApply apply = appProductService.getApply(barcode);
		      String result = "";
		      if (apply == null){		       
		    	  result = "null";
		    	  request.setAttribute("result", result);
		      }else{
		        result = "existApply";
		        request.setAttribute("result", result);
		      }		    
		}   
		else{
			appProductService.scanCounting(barcode);

			request.setAttribute("product", product);		      
			request.setAttribute("reviews", reviews);	
		}   
		return "appScan";	  
	}
}