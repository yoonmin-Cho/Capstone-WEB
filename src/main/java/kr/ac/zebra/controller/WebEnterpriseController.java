package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.WebEnterpriseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebEnterpriseController {

	private WebEnterpriseService webEnterpriseService;

	@Autowired
	public void setService(WebEnterpriseService webEnterpriseService){
		this.webEnterpriseService = webEnterpriseService;
	}
	
	@RequestMapping(value="/ourProduct", method=RequestMethod.GET)
	public String showOurProductPage(HttpSession session, Model model, HttpServletRequest request){
		
		String companyName = (String)session.getAttribute("userName");
		String filter = request.getParameter("filter");
	
		List<Integer> listCount = webEnterpriseService.getCompanyCount(companyName);
		request.setAttribute("listCount", listCount);
		
		if (filter.equals("All")) {
			List<Product> allProductList = webEnterpriseService.getOurAllProducts(companyName);
			model.addAttribute("ourProductsModel", allProductList);
		}
		if (filter.equals("Popularity")) {
			List<Product> popularityProductList = webEnterpriseService.getOurPopularityProducts(companyName);
			model.addAttribute("ourProductsModel", popularityProductList);
		}
		if (filter.equals("MostReview")) {
			List<Product> mostReviewProductList = webEnterpriseService.getOurMostReviewProducts(companyName);
			model.addAttribute("ourProductsModel", mostReviewProductList);
		}
		if (filter.equals("MostScan")) {
			List<Product> mostScanProductList = webEnterpriseService.getOurMostScanProducts(companyName);
			model.addAttribute("ourProductsModel", mostScanProductList);
		}
		return "ourProduct";
	}
	
	@RequestMapping(value="/management")
	public String showManagementPage(){
		
		
		
		
		return "management";
	}
}