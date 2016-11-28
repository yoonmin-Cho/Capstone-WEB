package kr.ac.zebra.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.zebra.dto.Enterprise;
import kr.ac.zebra.dto.Member;
import kr.ac.zebra.service.AppLoginService;
import kr.ac.zebra.service.WebLoginService;

@Controller
public class LoginController {

	private WebLoginService webLoginService;
	private AppLoginService appLoginService;
	
	@Autowired
	public void setService(WebLoginService webLoginService, AppLoginService appLoginService){
		this.webLoginService = webLoginService;
		this.appLoginService = appLoginService;
	}
	
	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request, HttpSession session){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userKind = request.getParameter("userKind");
			
		System.out.println("email: " + email + "/  password: " + password + " / userKind: " + userKind);
		
		if(userKind.equals("common")){
			Member member = new Member();
			member = webLoginService.getMember(email,password);

			if(member == null)
				return "failLogin";
			else{
				String userName = member.getName();
				
				System.out.println("userName : " + userName);
				
				session.setAttribute("isLogin", "yes");
				session.setAttribute("userKind", "common");
				session.setAttribute("userName", userName);
			}
				
		}else if(userKind.equals("enterprise")){
			Enterprise enterprise = new Enterprise();
			enterprise = webLoginService.getEnterprise(email, password);
			
			if(enterprise == null)
				return "failLogin";
			else{
				String userName = enterprise.getCompanyName();
				
				session.setAttribute("isLogin", "yes");
				session.setAttribute("userKind", "enterprise");
				session.setAttribute("userName", userName);
			}
			
		}else
			return "failLogin";
		
		return "home";
	}
	
	@RequestMapping(value="/appLogin")
	public String appLogin(HttpServletRequest request){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Member member = appLoginService.getMember(email, password);
		
		System.out.println("member: " + member);
		
		if(member!=null){
			request.setAttribute("member", member);
		}else{
			
		}
		
		return "appLogin";
	}
}
