package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.Comments;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductInfo;

public class CommentsMapper implements ParameterizedRowMapper<Comments> {

	@Override
	public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Comments c = new Comments();
		c.setId(rs.getInt("c_id"));
		c.setUsername(rs.getString("c_username"));
		c.setContent(rs.getString("c_content"));
		c.setType(rs.getInt("c_type"));
		c.setProductid(rs.getInt("c_productid"));
		ProductBase pb = new ProductBase();
		pb.setName(rs.getString("p_name"));
		c.setProductBase(pb);
		ProductInfo productInfo = new ProductInfo();
		productInfo.setName(rs.getString("pd_name"));
		c.setProductInfo(productInfo);
		c.setCreatetime(rs.getDate("c_createtime"));
		return c;
	}

}
