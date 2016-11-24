package kr.ac.zebra.service;

import java.util.List;

import kr.ac.zebra.dao.WebEnterpriseProductDAO;
import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebEnterpriseService {

	private WebEnterpriseProductDAO webEnterpriseProductDAO;
	
	@Autowired
	public void setDAO(WebEnterpriseProductDAO webEnterpriseProductDAO){
		this.webEnterpriseProductDAO = webEnterpriseProductDAO;
	}
	
	public List<Integer> getCompanyCount(String companyName){
		return webEnterpriseProductDAO.getCompanyCount(companyName);
	}
	
	public List<Product> getOurAllProducts(String companyName){
		return webEnterpriseProductDAO.getOurAllProducts(companyName);
	}
	
	public List<Product> getOurPopularityProducts(String companyName){
		return webEnterpriseProductDAO.getOurPopularityProducts(companyName);
	}
	
	public List<Product> getOurMostReviewProducts(String companyName){
		return webEnterpriseProductDAO.getOurMostReviewProducts(companyName);
	}

	public List<Product> getOurMostScanProducts(String companyName){
		return webEnterpriseProductDAO.getOurMostScanProducts(companyName);
	}
}
