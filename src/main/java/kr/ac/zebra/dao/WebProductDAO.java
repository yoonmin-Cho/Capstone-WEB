package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("webProductDAO")
public class WebProductDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	//Get one Product
	public Product getProduct(String barcode){
		try{
			String sqlStatement = "select * from producttb where barcode=?";
			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{barcode}, new ProductMapper());
		}catch(Exception e){
			System.out.println("WebProductDAO - getProduct Exception");
			e.printStackTrace();
			return null;
		}
	}
	
	//Get All Products
	public List<Product> getAllProducts(){
		try{
			String sqlStatement = "select * from producttb";
			return jdbcTemplateObject.query(sqlStatement, new ProductMapper());
		}catch(Exception e){
			System.out.println("ProductDAO getAllProductss Exception");
			e.printStackTrace();
			return null;
		}
	}
	
	//Get Products by category 
	public List<Product> getProducts(String category){
		try{
			String sqlStatement = "select * from producttb where category=?";
			return jdbcTemplateObject.query(sqlStatement, new Object[]{category} ,new ProductMapper());
		}catch(Exception e){
			System.out.println("ProductDAO getProducts Exception");
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> getPopularProducts(String category) {
		try{ 
			if (category.equals("0")){
				String sqlStatement = "select * from producttb where starPoint >= 2 order by starPoint DESC LIMIT 0, 12";	 
				return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());
			}
			String sqlStatement = "select * from producttb where starPoint >= 2 and category =" + category + " order by starPoint DESC LIMIT 0, 12"; 			 
			return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());
		    
		}catch (Exception e){	
			System.out.println("getPopularProducts DAO  ");	
			e.printStackTrace(); 
		}  
		return null;
	}

	public List<Product> getReviewProducts(String category){
		try{
			if (category.equals("0")){
				String sqlStatement = "select * from producttb where totalReviewCount > 0 order by totalReviewCount DESC LIMIT 0, 12";
				return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());
			}	      
			String sqlStatement = "select * from producttb where totalReviewCount > 0 and category =" + category + " order by totalReviewCount DESC LIMIT 0, 12";
			return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());   
		}catch (Exception e){	     
			System.out.println("getMostReviewProducts DAO");
			e.printStackTrace();    
		}
		    return null;
	}
	

	public List<Product> getScanProducts(String category) {
		try{
			if (category.equals("0")){
				String sqlStatement = "select * from producttb  order by scanCount DESC LIMIT 0, 12;";
				return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());
			}	     
			String sqlStatement = "select * from producttb  where  category =" + category + " order by scanCount DESC LIMIT 0, 20;";
			return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());
		}catch (Exception e){
			System.out.println("getMostScanProducts DAO ");
			e.printStackTrace();
		}
	    return null;
	}


	
	/*
	public Product getProduct(String barcode) {
		try {
			String sqlStatement = "";
			return jdbcTemplateObject.queryForObject(sqlStatement,
					new Object[] { barcode }, new ProductMapper());
		} catch (Exception e) {
			System.out.println("getProduct Exception");
			e.printStackTrace();
		}
	}
	*/
}
