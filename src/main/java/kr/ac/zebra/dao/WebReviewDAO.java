package kr.ac.zebra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("webReviewDAO")
public class WebReviewDAO {

	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	//get product Reviews 
	public List<Review> getReviews(String barcode){
		try{
			String sqlStatement = "select * from reviewtb where barcode=?";
			return jdbcTemplateObject.query(sqlStatement, new Object[]{barcode}, new ReviewMapper());
		}catch(Exception e){
			System.out.println("WebReviewDAO - getReviews Exception");
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Integer> getStarPoints(String barcode){
		try{
			String sqlStatement = "select COUNT(IF(starPoint=?, starPoint, null)) from reviewtb where barcode=?";
			
			int sum = 0;
			int count = 0;
			int i = 0;
		
			List<Integer> starList = new ArrayList<Integer>();
			
			for(i=0; i<5; i++){
				count = jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{i+1, barcode}, Integer.class);
				System.out.println("i: " + i +"count"+count);
				sum += count;
				starList.add(i, count);
			}
			starList.add(i, sum);
			
			System.out.println("star List: " + starList);
			
			return starList;
		}catch(Exception e){
			System.out.println("WebReviewDAO - getStarPoints Exception");
			e.printStackTrace();
			return null;
		}
	}
}