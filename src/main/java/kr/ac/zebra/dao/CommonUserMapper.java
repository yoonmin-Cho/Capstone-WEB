package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.zebra.dto.CommonUser;

public class CommonUserMapper implements RowMapper<CommonUser>{
	public CommonUser mapRow(ResultSet rs, int rowNum)throws SQLException{
		CommonUser commonUser = new CommonUser();
		
		commonUser.setEmail(rs.getString("email"));
		commonUser.setName(rs.getString("name"));
		commonUser.setPassword(rs.getString("password"));
	    commonUser.setPhoneNumber(rs.getString("phoneNumber"));
		commonUser.setLastReviewDate(rs.getString("lastReviewDate"));
		commonUser.setLevel(rs.getString("level"));
		commonUser.setMemberUrl(rs.getString("memberUrl"));
	
	    commonUser.setPoint(rs.getInt("point"));
	    commonUser.setReviewCount(rs.getInt("reviewCount"));
	    commonUser.setTotalReviewCount(rs.getInt("totalReviewCount"));
		
		return commonUser;
	}
}