package kr.ac.zebra.dao;

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
