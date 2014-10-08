package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.repository.ProductInfoDao;

public class ProductInfoDaoImpl extends CommonDaoImpl implements ProductInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(ProductInfo p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_info(pd_name,pd_thumbnail,pd_thummd5,pd_weight,pd_price,pd_amount,pd_createtime) values (?,?,?,?,?,?,now())";
		return this.addIntoDB(sql, new Object[] { p.getName(),
				p.getThumbnail(), p.getThummd5(), p.getWeight(), p.getPrice(),
				p.getAmount() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_info where pd_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

}
