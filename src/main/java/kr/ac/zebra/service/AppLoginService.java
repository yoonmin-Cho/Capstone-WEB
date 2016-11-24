package kr.ac.zebra.service;

import kr.ac.zebra.dao.CommonUserDAO;
import kr.ac.zebra.dto.CommonUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppLoginService {

	private CommonUserDAO commonUserDAO;
	
	@Autowired
	public void setDAO(CommonUserDAO commonUserDAO){
		this.commonUserDAO = commonUserDAO;
	}
	
	public CommonUser checkUser(String email, String password){
		CommonUser user = commonUserDAO.getUser(email, password);
		
		if(user == null)
			return null;
		String dbpassword = user.getPassword();
		if(dbpassword.equals(password))
			return user;
		return null;
	}
}
