package kr.ac.zebra.service;

import java.util.List;

import kr.ac.zebra.dao.WebProductDAO;
import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebProductService {

	private WebProductDAO webProductDAO;
	
	@Autowired
	public void setDAO(WebProductDAO webProductDAO){
		this.webProductDAO = webProductDAO;
	}
	
	//get All Products
	public List<Product> getAllProducts(){
		return webProductDAO.getAllProducts();
	}
	
	//get Products By category value (1~5)
	public List<Product> getProducts(String category){
		return webProductDAO.getProducts(category);
	}
	
	public List<Product> getPopularProducts(String category){
		return webProductDAO.getPopularProducts(category);
	}
	
	public List<Product> getReviewProducts(String category){
		return webProductDAO.getReviewProducts(category);
	}
	
	public List<Product> getScanProducts(String category){
		return webProductDAO.getScanProducts(category);
	}
	
}
