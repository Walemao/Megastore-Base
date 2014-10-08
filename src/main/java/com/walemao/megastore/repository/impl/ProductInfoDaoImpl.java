package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.domain.mapper.ProductInfoMapper;
import com.walemao.megastore.repository.ProductInfoDao;

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
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_info where pd_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
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
		String sql = "delete from t_product_info where pd_productid = -1";
		this.jdbcTemplate.update(sql);
	}

}
