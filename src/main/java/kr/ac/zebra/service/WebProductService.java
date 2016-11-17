package kr.ac.zebra.service;

import kr.ac.zebra.dao.WebProductDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebProductService {

	private WebProductDAO webProductDAO;
	
	@Autowired
	public void setDAO(WebProductDAO webProductDAO){
		this.webProductDAO = webProductDAO;
	}
	
}
