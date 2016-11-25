package kr.ac.zebra.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import kr.ac.zebra.dao.AppProductDAO;
import kr.ac.zebra.dao.AppReviewDAO;
import kr.ac.zebra.dao.CommonUserDAO;
import kr.ac.zebra.dto.CommonUser;
import kr.ac.zebra.dto.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppReviewService {

	private AppReviewDAO appReviewDAO;
	private CommonUserDAO commonUserDAO;
	private AppProductDAO appProductDAO;
	
	@Autowired
	public void setDAO(AppReviewDAO appReviewDAO, CommonUserDAO commonUserDAO, AppProductDAO appProductDAO){
		this.appReviewDAO = appReviewDAO;
		this.commonUserDAO = commonUserDAO;
		this.appProductDAO = appProductDAO;
	}
	
	public boolean checkAvailable(String email, String barcode){
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    
	    String nowDate = df.format(cal.getTime());
	    
	    CommonUser user = commonUserDAO.getUserByEmail(email);
	    if (user.getLastReviewDate().equals(nowDate)){ 
	    	if (user.getReviewCount() > 0){
	    		commonUserDAO.setting(email, user.getReviewCount(), user.getPoint(), user.getTotalReviewCount());
	    		appProductDAO.setAvarageStarPoint(barcode);       
	    		return true;
	    	}
	    	return false;
	    }
	    commonUserDAO.setting2(email, user.getReviewCount(), user.getPoint(), nowDate, user.getTotalReviewCount());
	    this.appProductDAO.setAvarageStarPoint(barcode);
	    return true;
	}
	
	public void setReview(String email, String barcode, String reviewText, int starPoint, String memberUrl, String productUrl, String level){

	    
	    if (this.appReviewDAO.isExist(email, barcode) == null){
	    	appReviewDAO.setReview(email, barcode, reviewText, starPoint, memberUrl, productUrl, level);
	    }else{
	      appReviewDAO.updateReview(email, barcode, reviewText, starPoint, memberUrl, productUrl, level);
	    }
	}

	public List<Review> getReviewByBarcode(String barcode){
		return appReviewDAO.getReviewByBarcode(barcode);
	}
	
	public List<Review> getReviewOfUser(String email){
		return appReviewDAO.getReviewByEmail(email);
	}
}