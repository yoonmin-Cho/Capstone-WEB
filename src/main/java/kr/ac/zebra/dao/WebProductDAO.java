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
