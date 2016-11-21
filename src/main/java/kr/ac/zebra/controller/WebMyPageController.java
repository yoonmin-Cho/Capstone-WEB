package kr.ac.zebra.controller;

import javax.servlet.http.HttpSession;

import kr.ac.zebra.dto.CommonUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebMyPageController {

	@RequestMapping(value="/myPage")
	public String showMyPage(Model model, HttpSession session){
		
		CommonUser user= (CommonUser)session.getAttribute("userInfo");
		model.addAttribute("userInfo", user);
		
		return "myPage";
	}	
}