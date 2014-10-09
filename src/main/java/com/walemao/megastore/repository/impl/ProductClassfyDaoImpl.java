package com.walemao.megastore.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.mapper.ProductClassifyMapper;
import com.walemao.megastore.repository.ProductClassfyDao;

@Repository
public class ProductClassfyDaoImpl extends CommonDaoImpl implements
		ProductClassfyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductClassify> getProductClassifies() {
		// TODO Auto-generated method stub
		String sql = "select pc_id,pc_name from t_product_classify order by pc_id";
		return this.jdbcTemplate.query(sql, new ProductClassifyMapper());
	}

	@Override
	public int insert(ProductClassify p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_classification(pc_name) values (?)";
		return this.addIntoDB(sql, new Object[] { p.getName() });
	}

	@Override
	public void update(ProductClassify p) {
		// TODO Auto-generated method stub
		String sql = "update t_product_classification set pc_name=? where pc_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getName(), p.getId() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_classification where pc_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

}
