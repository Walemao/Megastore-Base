package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.ProductType;
import com.walemao.megastore.repository.ProductTypeDao;

public class ProductTypeDaoImpl extends CommonDaoImpl implements ProductTypeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(ProductType p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_type(pd_productid,pd_name,pd_thumbnail,pd_amount,pd_createtime) values (?,?,?,?,now())";
		return this.addIntoDB(sql, new Object[] { p.getProductid(),
				p.getName(), p.getThumbnail(), p.getAmount() });
	}

	@Override
	public void delete(ProductType p) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_type where pd_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getId() });
	}

}
