package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.ProductBase;

public class ProductBaseMapper implements ParameterizedRowMapper<ProductBase>{

	@Override
	public ProductBase mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductBase pro = new ProductBase();
		pro.setId(rs.getInt("p_id"));
		pro.setNumber(rs.getString("p_number"));
		pro.setName(rs.getString("p_name"));
		pro.setRecommend(rs.getBoolean("p_recommend"));
		pro.setThumbnail(rs.getString("p_thumbnail"));
		ProductClassify productClassification = new ProductClassify();
		productClassification.setName(rs.getString("pc_name"));
		pro.setProductClassification(productClassification);
		pro.setClassify(rs.getInt("p_classify"));
		pro.setOrgin(rs.getString("p_origin"));
		pro.setMaterials(rs.getString("p_materials"));
		pro.setDesc(rs.getString("p_desc"));
		pro.setDiscount(rs.getDouble("p_discount"));
		pro.setRemark(rs.getString("p_remark"));
		pro.setCreatetime(rs.getTimestamp("p_createtime"));
		return pro;
	}

}
