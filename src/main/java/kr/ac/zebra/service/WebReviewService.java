package kr.ac.zebra.service;

import java.util.List;

import kr.ac.zebra.dao.WebReviewDAO;
import kr.ac.zebra.dto.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebReviewService {

	private WebReviewDAO webReviewDAO;
	
	@Autowired
	public void setDAO(WebReviewDAO webReviewDAO){
		this.webReviewDAO = webReviewDAO;
	}
	
	public List<Review> getReviews(String barcode){
		return webReviewDAO.getReviews(barcode);
	}
	
	public List<Integer> getStarPoints(String barcode){
		return webReviewDAO.getStarPoints(barcode);
	}
}