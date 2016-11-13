package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.zebra.dto.CommonUser;
import kr.ac.zebra.dto.EnterpriseUser;
import kr.ac.zebra.service.WebLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebLoginController {

	private WebLoginService webLoginService;
	
	@Autowired
	public void setService(WebLoginService webLoginService){
		this.webLoginService = webLoginService;
	}
	
	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request, HttpSession session, Model model){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String user = request.getParameter("user");
		
		
	
	@RequestMapping(value="/logout")
	public String doLogout(){
		
		return "logout";
	}
}