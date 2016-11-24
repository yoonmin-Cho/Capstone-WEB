package kr.ac.zebra.service;

import java.util.List;

import kr.ac.zebra.dao.ApplyDAO;
import kr.ac.zebra.dao.CommonUserDAO;
import kr.ac.zebra.dao.WebEnterpriseProductDAO;
import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebEnterpriseService {

	private WebEnterpriseProductDAO webEnterpriseProductDAO;
	private ApplyDAO applyDAO;
	private CommonUserDAO commonUserDAO;
	
	@Autowired
	public void setDAO(WebEnterpriseProductDAO webEnterpriseProductDAO, ApplyDAO applyDAO, CommonUserDAO commonUserDAO){
		this.webEnterpriseProductDAO = webEnterpriseProductDAO;
		this.applyDAO = applyDAO;
		this.commonUserDAO = commonUserDAO;
	}

	public List<Integer> getCompanyCount(String companyName) {
		return webEnterpriseProductDAO.getCompanyCount(companyName);
	}

	public List<Product> getOurAllProducts(String companyName) {
		return webEnterpriseProductDAO.getOurAllProducts(companyName);
	}

	public List<Product> getOurPopularityProducts(String companyName) {
		return webEnterpriseProductDAO.getOurPopularityProducts(companyName);
	}

	public List<Product> getOurMostReviewProducts(String companyName) {
		return webEnterpriseProductDAO.getOurMostReviewProducts(companyName);
	}

	public boolean insertProduct(Product product) {
		if (webEnterpriseProductDAO.insert(product))
			return true;
		return false;
	}
	
	public List<Product> getOurMostScanProducts(String companyName) {
		return webEnterpriseProductDAO.getOurMostScanProducts(companyName);
	}

	public List<AppApply> getApplyList(String companyName) {
		return applyDAO.getApplys(companyName);
	}

	public boolean DeleteApplyTb(String barcode){
		if (applyDAO.DeleteApplyTb(barcode))
			return true;
		return false;
	}
	
	public boolean increasePoint(String email){
		if (commonUserDAO.increaseMemberPoint(email))
			return true;
		return false;
	}

	public boolean decreasePoint(String email){
		if (commonUserDAO.decreaseMemberPoint(email))
			return true;
		return false;
	}	
}