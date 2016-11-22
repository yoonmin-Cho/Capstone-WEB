package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.PurchaseService;
import kr.ac.zebra.service.WebProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PurchaseController {

	private WebProductService webProductService;
	private PurchaseService purchaseService;
	
	@Autowired
	public void setService(PurchaseService purchaseService, WebProductService webProductService){
		this.purchaseService = purchaseService;
		this.webProductService = webProductService;
	}
	
	@RequestMapping(value="/purchase", method=RequestMethod.GET)
	public String showPurchasePage(HttpServletRequest request, Model model, HttpSession session){
		
		String barcode = request.getParameter("barcode");
		
		Product product = webProductService.getProduct(barcode);
		model.addAttribute("productInfo", product);
		
		session.setAttribute("productName", product.getProductName());
		
		return "purchase";
	}
	
}
