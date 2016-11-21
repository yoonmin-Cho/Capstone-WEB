package kr.ac.zebra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.zebra.dto.Review;

import org.springframework.jdbc.core.RowMapper;

public class ReviewMapper implements RowMapper<Review>{
	public Review mapRow(ResultSet rs, int rowNum)throws SQLException{
		Review review = new Review();
		
		review.setEmail(rs.getString("email"));
		review.setBarcode(rs.getString("barcode"));
		review.setReviewText(rs.getString("reviewText"));
		review.setStarPoint(rs.getInt("starPoint"));
		review.setMemberUrl(rs.getString("memberUrl"));
		review.setProductUrl(rs.getString("productUrl"));
		review.setLevel(rs.getString("level"));
		
		return review;
	}
}