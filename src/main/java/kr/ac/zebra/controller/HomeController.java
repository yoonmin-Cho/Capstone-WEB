package kr.ac.zebra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		
		String isLogin = (String)session.getAttribute("logOk");
		if(isLogin == null)
			session.setAttribute("logOk", "notLogin");
		return "home";
	}
}