package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.zebra.dto.CommonUser;
import kr.ac.zebra.service.AppLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppLoginController {

	private AppLoginService appLoginService;
	
	@Autowired
	public void setService(AppLoginService appLoginService){
		this.appLoginService = appLoginService;
	}
	
	@RequestMapping(value="/appLogin")
	public String showLoginPage(HttpServletRequest request){
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//String tokenId = request.getParameter("tokenId");
		
		CommonUser user = appLoginService.checkUser(email, password);
		request.setAttribute("user", user);
		
		return "appLogin";
	}
}