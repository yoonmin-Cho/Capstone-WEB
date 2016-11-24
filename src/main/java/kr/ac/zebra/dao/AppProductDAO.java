package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.AppApply;
import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("appProductDAO")
public class AppProductDAO {

	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<Product> getProductByCategory(String category){
		try{	
			String sqlStatement = "select * from producttb where category= ?";
			return this.jdbcTemplateObject.query(sqlStatement, new Object[] { category }, new ProductMapper());
		    
		} catch (Exception e){
		      e.printStackTrace();	    
		}  
		return null;
	}
	
	public List<Product> getProductBySearch(String keyword){
		try{
			String sqlStatement = "select * from producttb where productName like '%" + keyword + "%'"; 
			return this.jdbcTemplateObject.query(sqlStatement, new ProductMapper());
		    
		}catch (Exception e){
			 e.printStackTrace();
		} 
		return null;
	}
	
	public boolean isExist(String barcode){
		try {      
			String sqlStatement = "select * from applytb where barcode=?";
			AppApply apply = jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { barcode }, new AppApplyMapper());
	      return true;
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return false;
	}

}