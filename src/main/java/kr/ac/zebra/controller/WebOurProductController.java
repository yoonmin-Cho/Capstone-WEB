package kr.ac.zebra.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;
import kr.ac.zebra.service.WebManageService;

@Controller
public class WebManageController {

	private WebManageService webManagerSerivce;
	
	@Autowired
	public void setService(WebManageService webManagerSerivce){
		this.webManagerSerivce = webManagerSerivce;
	}
	
	@RequestMapping(value="/management")
	public String showManagement(HttpSession session, Model model){
		
		String companyName = (String)session.getAttribute("userName");
		
		List<AppApply> applyList = webManagerSerivce.getApplyList(companyName);
		model.addAttribute("applyList", applyList);
		
		return "management";
	}
	
	@RequestMapping(value="/confirm")
	public String showConfirm(){
		return "confirm";
	}
	
	
	@RequestMapping(value="/doConfirm")
	public String showDoConfirm(HttpServletRequest request,HttpSession session){
	
		String allow = request.getParameter("allow");
		
		if(allow.equals("okay")){
			Product product = new Product();
			
			product.setBarcode(request.getParameter("barcode"));
			product.setCategory(request.getParameter("category_radio"));
			product.setCompanyName((String)session.getAttribute("userName"));
			product.setDescription(request.getParameter("description"));
			product.setProductName(request.getParameter("productName"));
			product.setProductUrl(request.getParameter("productUrl"));
			product.setScanCount(1);
			product.setStarPoint(0);
			product.setTotalReviewCount(1);
			
			if(webManagerSerivce.insertProduct(product)){
				webManagerSerivce.increasePoint(request.getParameter("email"));
				webManagerSerivce.DeleteApplyTable(request.getParameter("barcode"));
			}
			else{
				System.out.println("fail insert Product");
			}
		}
		else if(allow.equals("reject")){
			webManagerSerivce.DeleteApplyTable(request.getParameter("barcode"));
			webManagerSerivce.decreasePoint(request.getParameter("email"));
			
			return "management";
		}
		
		return "doConfirm";
	}	
}
