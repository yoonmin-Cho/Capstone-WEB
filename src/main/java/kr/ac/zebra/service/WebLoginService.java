package kr.ac.zebra.service;

import kr.ac.zebra.dao.CommonUserDAO;
import kr.ac.zebra.dao.EnterpriseUserDAO;
import kr.ac.zebra.dto.CommonUser;
import kr.ac.zebra.dto.EnterpriseUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebLoginService {

	private CommonUserDAO commonUserDAO;
	private EnterpriseUserDAO enterUserDAO;
	
	@Autowired
	public void setDAO(CommonUserDAO commonUserDAO, EnterpriseUserDAO enterpriseUserDAO){
		this.commonUserDAO = commonUserDAO;
		this.enterUserDAO = enterpriseUserDAO;
	}
	
	public CommonUser getCommonUser(String email, String password){
		return commonUserDAO.getUser(email,password);
	}
	
	public EnterpriseUser getEnterUser(String email, String password){
		return enterUserDAO.getUser(email,password);
	}
}