package com.walemao.megastore.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductClassification;
import com.walemao.megastore.domain.mapper.ProductClassificationMapper;
import com.walemao.megastore.repository.ProductClassficationDao;

@Repository
public class ProductClassficationDaoImpl extends CommonDaoImpl implements
		ProductClassficationDao {
	private Logger logger = LoggerFactory
			.getLogger(ProductClassficationDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductClassification> getProductClassifications() {
		// TODO Auto-generated method stub
		String sql = "select * from t_product_classification order by pc_id";
		return this.jdbcTemplate.query(sql, new ProductClassificationMapper());
	}

	@Override
	public int insert(ProductClassification p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_classification(pc_name) values (?)";
		return this.addIntoDB(sql, new Object[] { p.getName() });
	}

	@Override
	public void update(ProductClassification p) {
		// TODO Auto-generated method stub
		String sql = "update t_product_classification set pc_name=? where pc_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getName(), p.getId() });
	}

}
