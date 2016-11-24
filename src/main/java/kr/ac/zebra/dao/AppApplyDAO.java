package kr.ac.zebra.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.AppApply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("appApplyDAO")
public class AppApplyDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public AppApply getApply(String barcode) {
		try {
			String sqlStatement = "select * from applytb where barcode="+ barcode;
			AppApply apply = (AppApply) this.jdbcTemplateObject.queryForObject(sqlStatement, new AppApplyMapper());
			if (apply.getBarcode().isEmpty()) 
				return null;
			return apply;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<AppApply> getApplys() {
		try {
			String sqlStatement = "select * from applytb";
			return this.jdbcTemplateObject.query(sqlStatement,
					new AppApplyMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertProduct(String email, String barcode,
			String productName, String companyName) {
		try {
			String sqlStatement = "insert into applytb (barcode, email, productName, companyName) values (?,?,?,?)";
			return this.jdbcTemplateObject.update(sqlStatement, new Object[] {
					barcode, email, productName, companyName }) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}