package com.walemao.megastore.repository.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.ProductColor;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.domain.mapper.ProductMapper;
import com.walemao.megastore.repository.ProductDao;

public class ProductDaoImpl implements ProductDao {
	private Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.walemao.megastore.repository.ProductDao#getProducts(java.lang.String)
	 */
	@Override
	public List<ProductInfo> getProducts(String parm, int type, Date startTime,
			Date endTime, int mark) {
		// TODO Auto-generated method stub
		String args = mark == 0 ? "null" : "not null";
		String sql = "select p_id,p_number,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin,p_weight"
				+ ",p_materials,p_desc,p_price,p_discount,p_remark,p_creattime from t_product_info"
				+ " where deletemark is " + args;
		List<Object> list = new ArrayList<Object>();
		if (parm == null || parm.length() <= 0) {
		} else {
			sql += " and p_name like ? and type=?";
			list.add("%" + parm + "%");
			list.add(type);
		}
		if (startTime != null && endTime != null) {
			sql += " and p_creattime between ? and ?";
			list.add(startTime);
			list.add(endTime);
		}
		sql += " order by p_creattime desc";
		return this.jdbcTemplate
				.query(sql, list.toArray(), new ProductMapper());
	}

	@Override
	public void insert(ProductInfo p) {
		// TODO Auto-generated method stub
		final List<ProductColor> list = p.getProductColors();
		String sql = "insert into t_product_info(p_number,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin,p_weight,p_materials,p_desc,p_price,p_discount,p_remark) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int id = this.jdbcTemplate.update(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getImages(), p.getType(),
						p.getOrgin(), p.getWeight(), p.getMaterials(),
						p.getDesc(), p.getPrice(), p.getDiscount(),
						p.getRemark() });
		sql = "insert into t_prodcut_color(pd_productid,pd_name,pd_createtime) values ("
				+ id + ",?,now())";
		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps, int i)
					throws SQLException {
				// TODO Auto-generated method stub
				String name = list.get(i).getName();
				ps.setString(1, name);
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
	}

	@Override
	public void update(ProductInfo p) {
		// TODO Auto-generated method stub
		String sql = "Update t_product_info set p_number=?,p_name=?,p_recommend=?,p_thumbnail=?,p_images=?,p_type=?,p_origin=?,p_weight=?,p_materials=?,p_desc=?,p_price=?,p_discount=?,p_remark=? where p_id=?";
		this.jdbcTemplate.update(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getImages(), p.getType(),
						p.getOrgin(), p.getWeight(), p.getMaterials(),
						p.getDesc(), p.getPrice(), p.getDiscount(),
						p.getRemark(), p.getId() });
	}

	@Override
	public void delete(ProductInfo p) {
		// TODO Auto-generated method stub
		String sql = "Update t_product_info set deletemark=now() where p_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getId() });
	}

	@Override
	public void permanentlyDelete(ProductInfo p) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_info where p_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getId() });
	}
}
