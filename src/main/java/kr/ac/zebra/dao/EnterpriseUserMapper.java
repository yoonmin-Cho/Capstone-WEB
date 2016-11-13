package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.zebra.dto.EnterpriseUser;

import org.springframework.jdbc.core.RowMapper;

public class EnterpriseUserMapper implements RowMapper<EnterpriseUser>{
	public EnterpriseUser mapRow(ResultSet rs, int rowNum)throws SQLException{
		EnterpriseUser enterUser = new EnterpriseUser();
		
		enterUser.setCompanyName(rs.getString("companyName"));
		enterUser.setEmail(rs.getString("email"));
		enterUser.setPassword(rs.getString("password"));
		
		return enterUser;
	}
}