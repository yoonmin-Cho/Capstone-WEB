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
		
		if(user.equals("common")){
			CommonUser commonUser = webLoginService.getCommonUser(email,password);
			if(commonUser == null)
				return "failLogin";
			model.addAttribute("loginUser", commonUser);
			session.setAttribute("name", commonUser.getName());
			session.setAttribute("user", user);
		}
		else if(user.equals("enterprise")){
			EnterpriseUser enterUser = webLoginService.getEnterUser(email,password);
			if(enterUser == null)
				return "failLogin";
			model.addAttribute("loginUser", enterUser);
			session.setAttribute("name", enterUser.getName());
			session.setAttribute("user", user);
		}
		else
			return "failLogin";
			
		return "home";
	}
	
	@RequestMapping(value="/logout")
	public String doLogout(){
		
		return "logout";
	}
}