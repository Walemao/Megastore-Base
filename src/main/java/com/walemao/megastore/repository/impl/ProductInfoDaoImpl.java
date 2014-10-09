package com.walemao.megastore.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.domain.mapper.ProductInfoMapper;
import com.walemao.megastore.repository.ProductInfoDao;
import com.walemao.megastore.util.ToolUtil;

@Repository
public class ProductInfoDaoImpl extends CommonDaoImpl implements ProductInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(ProductInfo p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_info(pd_name,pd_productid,pd_thumbnail,pd_thummd5,pd_weight,pd_price,pd_amount,pd_createtime) values (?,?,?,?,?,?,?,now())";
		return this.addIntoDB(
				sql,
				new Object[] { p.getName(), p.getProductid(), p.getThumbnail(),
						p.getThummd5(), p.getWeight(), p.getPrice(),
						p.getAmount() });
	}

	@Override
	public void update(ProductInfo p) {
		// TODO Auto-generated method stub
		String sql = "update t_product_info set pd_name=?,pd_thumbnail=?,pd_thummd5=?,pd_weight=?,pd_price=?,pd_amount=? where pd_id=?";
		this.jdbcTemplate
				.update(sql,
						new Object[] { p.getName(), p.getThumbnail(),
								p.getThummd5(), p.getWeight(), p.getPrice(),
								p.getAmount(), p.getId() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_info where pd_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public List<ProductInfo> getProductInfo(int productid) {
		// TODO Auto-generated method stub
		String sql = "SELECT pd_id,pd_productid,pd_name, "
				+ "	pd_thumbnail, pd_thummd5, pd_weight, "
				+ "	pd_price, pd_amount, pd_createtime "
				+ "FROM t_product_info where pd_productid = ?";
		return this.jdbcTemplate.query(sql, new Object[] { productid },
				new ProductInfoMapper());
	}

	@Override
	public ProductInfo getProductInfo(String md5) {
		// TODO Auto-generated method stub
		String sql = "SELECT pd_id,pd_productid,pd_name, "
				+ "	pd_thumbnail, pd_thummd5, pd_weight, "
				+ "	pd_price, pd_amount, pd_createtime "
				+ "FROM t_product_info where pd_thummd5 = ? limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { md5 },
				new ProductInfoMapper()).get(0);
	}

	@Override
	public void deleteUnused() {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_info where pd_productid = 0";
		this.jdbcTemplate.update(sql);
	}

	@Override
	public void update(int id, int[] ids) {
		// TODO Auto-generated method stub
		if (ids.length > 0) {
			String sql = "update t_product_info set pd_productid=? where pd_id in "
					+ ToolUtil.IntDataToString(ids);
			this.jdbcTemplate.update(sql, new Object[] { id });
		}
	}

}
