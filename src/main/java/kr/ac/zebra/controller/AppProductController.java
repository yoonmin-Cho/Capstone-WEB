package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.AppProductService;

@Controller
public class AppProductController {

	private AppProductService appProductService;
	
	@Autowired
	public void setService(AppProductService appProductService){
		this.appProductService = appProductService;
	}
	
	@RequestMapping(value="/appCategory")
	public String showCategory(HttpServletRequest request){
		
		String category = request.getParameter("category");
		
		List<Product> products = appProductService.getCategoryProduct(category);
		request.setAttribute("products", products);
		
		return "appCategory";
	}
	
	@RequestMapping(value="/appProductSearch")
	public String showSearchProduct(HttpServletRequest request){
		
		String keyword = request.getParameter("keyword");
		
		List<Product> products  = appProductService.getSearchProduct(keyword);
		request.setAttribute("products", products);
		
		return "appSearchProduct";
	}
	
	@RequestMapping(value="/appProductRegister")
	public String showProductRegister(HttpServletRequest request){
		
		String email = request.getParameter("email");
		String barcode = request.getParameter("barcode");
		String productName = request.getParameter("productName");
		String companyName = request.getParameter("companyName");
		
		if(appProductService.isExist(barcode)){
			request.setAttribute("result", "");
			return "appRegisterProduct";
		}
			
		if(appProductService.insertProduct(email, barcode, productName, companyName))
			request.setAttribute("result", "{\"1\"}");
		else
			request.setAttribute("result", "{\"0\"}");
	
		return "appRegisterProduct";
	}
}
