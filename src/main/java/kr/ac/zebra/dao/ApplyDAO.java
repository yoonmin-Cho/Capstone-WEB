package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.AppApply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("applyDAO")
public class ApplyDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<AppApply> getApplys(String companyName) {
		String sqlStatement = "select * from applytb where companyName = ?";
		return jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new AppApplyMapper());
	}

	public boolean DeleteApplyTb(String barcode) {
		try {
			String sqlstatement = "delete from applytb where barcode=?";
			return this.jdbcTemplateObject.update(sqlstatement,new Object[] { barcode }) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}