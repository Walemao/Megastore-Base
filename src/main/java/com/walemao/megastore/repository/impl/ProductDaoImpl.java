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
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductType;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.domain.mapper.ProductColorMapper;
import com.walemao.megastore.domain.mapper.ProductMapper;
import com.walemao.megastore.repository.ProductDao;

@Repository
public class ProductDaoImpl extends CommonDao implements ProductDao {
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
	public ProductInfo getProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "select p_id,p_number,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin,p_weight"
				+ ",p_materials,p_desc,p_price,p_discount,p_remark,p_creattime from t_product_info where p_id = ? limit 1";
		ProductInfo productInfo = this.jdbcTemplate.query(sql,
				new Object[] { id }, new ProductMapper()).get(0);
		sql = "select pd_id,pd_name,pd_amount,pd_createtime from t_prodcut_color where pd_productid = ? limit 1";
		productInfo.setProductColors(this.jdbcTemplate.query(sql,
				new Object[] { id }, new ProductColorMapper()));
		return productInfo;
	}

	@Override
	public List<ProductInfo> getProducts(String parm, int type, Date startTime,
			Date endTime, int mark) {
		// TODO Auto-generated method stub
		String args = mark == 0 ? "null" : "not null";
		String sql = "select p_id,p_number,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin,p_weight"
				+ ",p_materials,p_desc,p_price,p_discount,p_remark,p_creattime,pc_name from t_product_info a left join t_product_classification b"
				+ " on a.p_type = b.pc_id where a.deletemark is " + args;
		List<Object> list = new ArrayList<Object>();
		if (parm == null || parm.length() <= 0) {
		} else {
			sql += " and p_name like ? and p_type=?";
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
	public int insert(ProductInfo p) {
		// TODO Auto-generated method stub
		final List<ProductType> list = p.getProductColors();
		String sql = "insert into t_product_info(p_number,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin,p_weight,p_materials,p_desc,p_price,p_discount,p_remark) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int id = this.addIntoDB(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getImages(), p.getType(),
						p.getOrgin(), p.getWeight(), p.getMaterials(),
						p.getDesc(), p.getPrice(), p.getDiscount(),
						p.getRemark() });
		p.setId(id);

		sql = "insert into t_prodcut_color(pd_productid,pd_name,pd_amount,pd_createtime) values ("
				+ id + ",?,?,now())";
		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps, int i)
					throws SQLException {
				// TODO Auto-generated method stub
				String name = list.get(i).getName();
				int amount = list.get(i).getAmount();
				ps.setString(1, name);
				ps.setInt(2, amount);
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
		return id;
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
