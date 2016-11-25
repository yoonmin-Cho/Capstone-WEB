package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppReviewDAO {

	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Review isExist(String email, String barcode){
		try{
			String sqlStatement = "select * from reviewtb where email=? and barcode=?";
		    Review review = (Review)this.jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { email, barcode }, new ReviewMapper());
		    return review;
		}catch (Exception e){
			e.printStackTrace();
		}    
		return null;
	}
	
	public List<Review> getReviewByBarcode(String barcode){
		try{  
			String sqlStatement = "select * from reviewtb where barcode= ?";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { barcode }, new ReviewMapper());
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	public List<Review> getReviewByEmail(String email){
		try{  
			String sqlStatement = "select * from reviewtb where email= ?";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { email }, new ReviewMapper());
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	public void setReview(String email, String barcode, String reviewText, int starPoint, String memberUrl, String productUrl, String level){
		 try{
			 String sqlStatement = "insert into reviewtb (email, barcode, reviewText, starPoint, level, memberUrl, productUrl) values (?, ?, ?, ?, ?, ?, ?)";
			 jdbcTemplateObject.update(sqlStatement, new Object[] { email, barcode, reviewText, starPoint, level, memberUrl, productUrl });
		 } catch (Exception e){
		      e.printStackTrace(); 
		 }
	}
	
	public void updateReview(String email, String barcode, String reviewText, int starPoint, String memberUrl, String productUrl, String level){
	    try{
	    	String sqlStatement = "update reviewtb set reviewText=?, starPoint=?, level=? where email=? and barcode=?";
	    	jdbcTemplateObject.update(sqlStatement, new Object[] { reviewText, starPoint, level, email, barcode });
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	}
}