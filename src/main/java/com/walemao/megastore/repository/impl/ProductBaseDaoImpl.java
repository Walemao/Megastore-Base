package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.mapper.ProductInfoMapper;
import com.walemao.megastore.domain.mapper.ProductBaseMapper;
import com.walemao.megastore.repository.ProductBaseDao;
import com.walemao.megastore.util.DateUtil;
import com.walemao.megastore.util.PaginationHelper;

@Repository
public class ProductBaseDaoImpl extends CommonDaoImpl implements ProductBaseDao {
	private Logger logger = LoggerFactory.getLogger(ProductBaseDaoImpl.class);
			
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.walemao.megastore.repository.ProductDao#getProducts(java.lang.String)
	 */

	@Override
	public ProductBase getProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "select p_id,p_number,p_name,p_recommend,p_thumbnail,p_classify,p_origin"
				+ ",p_materials,p_desc,p_discount,p_remark,p_createtime,pc_name from t_product_base a left join t_product_classify b"
				+ " on a.p_classify = b.pc_id where p_id = ? limit 1";
		ProductBase productInfo = this.jdbcTemplate.query(sql,
				new Object[] { id }, new ProductBaseMapper()).get(0);
		sql = "select pd_id,pd_productid,pd_name,pd_thumbnail,pd_thummd5,pd_weight,pd_price,pd_amount,pd_createtime from t_product_info where pd_productid = ?";
		productInfo.setProductColors(this.jdbcTemplate.query(sql,
				new Object[] { id }, new ProductInfoMapper()));
		return productInfo;
	}

	@Override
	public CurrentPage<ProductBase> getProducts(String parm, int classify,
			Date startTime, Date endTime, int mark) throws DataAccessException {
		// TODO Auto-generated method stub
		PaginationHelper<ProductBase> ph = new PaginationHelper<ProductBase>();

		String args = mark == 0 ? "null" : "not null";
		String queryArgs = "p_id,p_number,p_name,p_recommend,p_thumbnail,p_classify,p_origin"
				+ ",p_materials,p_desc,p_discount,p_remark,p_createtime,pc_name";
		String sql = "select "
				+ queryArgs
				+ " from t_product_base a left join t_product_classify b"
				+ " on a.p_classify = b.pc_id where a.p_id <> 0 and a.deletemark is "
				+ args;
		List<Object> list = new ArrayList<Object>();
		if (parm == null || parm.length() <= 0) {
		} else {
			sql += " and p_name like ?";
			list.add("%" + parm + "%");
		}
		if (classify != 0) {
			sql += " and p_classify = ?";
			list.add(classify);
		}
		if (startTime != null && endTime != null) {
			sql += " and (p_createtime between ? and ? )";
			list.add(DateUtil.FormatToD(startTime));
			list.add(DateUtil.FormatToD(endTime));
		}
		sql += " order by p_createtime desc";
		
		return ph.fetchPage(jdbcTemplate,
				sql.replace(queryArgs, "count(1)"), sql, list.toArray(),
				CurrentPage.getPageNubmer(), CurrentPage.getPageLength(), new ProductBaseMapper());
	}

	@Override
	public int insert(ProductBase p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_base(p_number,p_name,p_recommend,p_thumbnail,p_classify,p_origin,p_materials,p_desc,p_discount,p_remark,p_createtime) values (?,?,?,?,?,?,?,?,?,?,now())";

		int id = this.addIntoDB(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getClassify(), p.getOrgin(),
						p.getMaterials(), p.getDesc(), p.getDiscount(),
						p.getRemark() });
		p.setId(id);
		return id;
	}

	@Override
	public void update(ProductBase p) {
		// TODO Auto-generated method stub
		String sql = "Update t_product_base set p_number=?,p_name=?,p_recommend=?,p_thumbnail=?,p_classify=?,p_origin=?,p_materials=?,p_desc=?,p_discount=?,p_remark=? where p_id=?";
		this.jdbcTemplate.update(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getClassify(), p.getOrgin(),
						p.getMaterials(), p.getDesc(), p.getDiscount(),
						p.getRemark(), p.getId() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "Update t_product_base set deletemark=now() where p_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void permanentlyDelete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_base where p_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

}
