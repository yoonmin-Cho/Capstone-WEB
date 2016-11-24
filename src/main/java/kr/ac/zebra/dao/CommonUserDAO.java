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
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public CommonUser getUser(String email, String password) {
		try {
			String sqlStatement = "select * from commonusertb where email=? and password=?";
			return jdbcTemplateObject.queryForObject(sqlStatement,
					new Object[] { email, password }, new CommonUserMapper());
		} catch (Exception e) {
			System.out.println("getCommonUser Exception");
			e.printStackTrace();
		}
		return null;
	}

	public boolean increaseMemberPoint(String email) {
		try {
			String sqlStatement = "update commonusertb set point = point + 5000 where email = ?";
			return jdbcTemplateObject.update(sqlStatement, new Object[] { email }) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean decreaseMemberPoint(String email) {
		try {
			String sqlStatement = "update commonusertb set point = point - 1 where email = ?";
			return this.jdbcTemplateObject.update(sqlStatement, new Object[] { email }) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}