package kr.ac.zebra.dao;

import javax.sql.DataSource;

import kr.ac.zebra.dto.CommonUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("commonUserDAO")
public class CommonUserDAO {
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public CommonUser getUser(String email, String password){
		try{
			String sqlStatement = "select * from commonusertb where email=? and password=?";
			return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{email, password}, new CommonUserMapper());
		}catch(Exception e){
			System.out.println("getCommonUser Exception");
			e.printStackTrace();
		}
		return null;
	}
}