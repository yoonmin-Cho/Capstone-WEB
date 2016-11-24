package kr.ac.zebra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.ac.zebra.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("webEnterpriseProductDAO")
public class WebEnterpriseProductDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from producttb";
		return ((Integer)jdbcTemplateObject.queryForObject(sqlStatement,Integer.class)).intValue();
	}

	public List<Product> getOurAllProducts(String companyName) {
		try {
			String sqlStatement = "select * from producttb  where companyName = ?";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper());
		} catch (Exception e) {
			System.out.println("WebEnterpriseProductDAO - getAllProducts Exception ");
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getOurPopularityProducts(String companyName) {
		try {
			String sqlStatement = "select * from producttb where ( companyName = ? ) and ( starPoint >= 2 ) order by starPoint DESC";
			return this.jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper());
		} catch (Exception e) {
			System.out.println("WebEnterpriseProductDAO - getOurPopularityProducts Exception  ");
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getOurMostReviewProducts(String companyName) {
		try {
			String sqlStatement = "select * from producttb where companyName = ? and totalReviewCount > 0 order by totalReviewCount DESC";
			return this.jdbcTemplateObject.query(sqlStatement, new Object[] { companyName }, new ProductMapper());
		} catch (Exception e) {
			System.out.println("WebEnterpriseProductDAO - getOurMostReviewProducts Exception");
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getOurMostScanProducts(String companyName) {
		try {
			String sqlStatement = "select * from producttb where companyName = ? order by scanCount DESC";
			return this.jdbcTemplateObject.query(sqlStatement,new Object[] { companyName }, new ProductMapper());
		} catch (Exception e) {
			System.out.println("WebEnterpriseProductDAO - getOurMostScanProducts Exception");
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getCompanyCount(String companyName) {
		List<Integer> count = new ArrayList();
		int percentage = 0;

		String sqlStatMent = "select sum(totalReviewCount) from producttb where companyName = ?";
		count.add((Integer) this.jdbcTemplateObject.queryForObject(sqlStatMent, new Object[] { companyName }, Integer.class));

		sqlStatMent = "select sum(scanCount) from producttb where companyName = ?";
		count.add((Integer) this.jdbcTemplateObject.queryForObject(sqlStatMent, new Object[] { companyName }, Integer.class));

		percentage = ((Integer) count.get(0)).intValue() * 100 / ((Integer) count.get(1)).intValue();
		count.add(Integer.valueOf(percentage));

		System.out.println("company=" + count);

		return count;
	}
}
