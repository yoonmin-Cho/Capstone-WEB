package kr.ac.zebra.dao;

import javax.sql.DataSource;

import kr.ac.zebra.dto.CommonUser;
import kr.ac.zebra.dto.EnterpriseUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("enterpriseUserDAO")
public class EnterpriseUserDAO {
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public EnterpriseUser getUser(String email, String password){
		try{
			String sqlStatement = "select * from enterpriseusertb where email=? and password=?";
			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{email,password}, new EnterpriseUserMapper());
		}catch(Exception e){
			System.out.println("getEnterpriseUser Exception");
			e.printStackTrace();
		}
		return null;
	}
	
}
