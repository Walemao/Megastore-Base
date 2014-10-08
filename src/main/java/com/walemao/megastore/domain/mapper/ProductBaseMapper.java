package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.google.gson.Gson;
import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.ProductBase;

public class ProductBaseMapper implements RowMapper<ProductBase>{

	@SuppressWarnings("unchecked")
	@Override
	public ProductBase mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductBase pro = new ProductBase();
		pro.setId(rs.getInt("p_id"));
		pro.setNumber(rs.getString("p_number"));
		pro.setName(rs.getString("p_name"));
		pro.setRecommend(rs.getBoolean("p_recommend"));
		pro.setThumbnail(rs.getString("p_thumbnail"));
		Gson gson = new Gson(); 
		pro.setImages(gson.fromJson(rs.getString("p_images"), ArrayList.class));
		ProductClassify productClassification = new ProductClassify();
		productClassification.setName(rs.getString("pc_name"));
		pro.setProductClassification(productClassification);
		pro.setType(rs.getInt("p_type"));
		pro.setOrgin(rs.getString("p_origin"));
		pro.setMaterials(rs.getString("p_materials"));
		pro.setDesc(rs.getString("p_desc"));
		pro.setDiscount(rs.getDouble("p_discount"));
		pro.setRemark(rs.getString("p_remark"));
		pro.setCreattime(rs.getDate("p_creattime"));
		return pro;
	}

}
