package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.zebra.dto.AppApply;

public class AppApplyMapper implements RowMapper<AppApply>{
	public AppApply mapRow(ResultSet rs, int rowNum)throws SQLException{

	    AppApply applyProduct = new AppApply();
	    
	    applyProduct.setBarcode(rs.getString("barcode"));
	    applyProduct.setEmail(rs.getString("email"));
	    applyProduct.setProductName(rs.getString("productName"));
	    applyProduct.setCompanyName(rs.getString("companyName"));
	    
	    return applyProduct;
	}
}
