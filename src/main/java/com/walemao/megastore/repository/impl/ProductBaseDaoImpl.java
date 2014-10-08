package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.mapper.ProductInfoMapper;
import com.walemao.megastore.domain.mapper.ProductBaseMapper;
import com.walemao.megastore.repository.ProductBaseDao;

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
		String sql = "select p_id,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin"
				+ ",p_materials,p_desc,p_price,p_discount,p_remark,p_creattime from t_product_base where p_id = ? limit 1";
		ProductBase productInfo = this.jdbcTemplate.query(sql,
				new Object[] { id }, new ProductBaseMapper()).get(0);
		sql = "select pd_id,pd_productid,pd_name,pd_thumbnail,pd_thummd5,pd_weight,pd_price,pd_amount,pd_createtime from t_product_info where pd_productid = ?";
		productInfo.setProductColors(this.jdbcTemplate.query(sql,
				new Object[] { id }, new ProductInfoMapper()));
		return productInfo;
	}

	@Override
	public List<ProductBase> getProducts(String parm, int type, Date startTime,
			Date endTime, int mark) {
		// TODO Auto-generated method stub
		String args = mark == 0 ? "null" : "not null";
		String sql = "select p_id,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin"
				+ ",p_materials,p_desc,p_discount,p_remark,p_creattime,pc_name from t_product_base a left join t_product_classification b"
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
		return this.jdbcTemplate.query(sql, list.toArray(),
				new ProductBaseMapper());
	}

	@Override
	public int insert(ProductBase p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_base(p_number,p_name,p_recommend,p_thumbnail,p_images,p_type,p_origin,p_materials,p_desc,p_discount,p_remark) values (?,?,?,?,?,?,?,?,?,?,?)";

		int id = this.addIntoDB(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getImages(), p.getType(),
						p.getOrgin(), p.getMaterials(), p.getDesc(),
						p.getDiscount(), p.getRemark() });
		p.setId(id);
		List<ProductInfo> list = p.getProductInfos();
		int length = list.size();
		if (length > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("(");
			for (int i = 0; i < length - 1; ++i) {
				sb.append(list.get(i).getId() + ",");
			}
			;
			sb.append(list.get(length - 1).getId() + ")");
			sql = "update t_product_info set pd_productid=? where pd_id in ?";
			this.jdbcTemplate.update(sql, new Object[] { id, sb.toString() });
		}
		return id;
	}

	@Override
	public void update(ProductBase p) {
		// TODO Auto-generated method stub
		String sql = "Update t_product_base set p_number=?,p_name=?,p_recommend=?,p_thumbnail=?,p_images=?,p_type=?,p_origin=?,p_materials=?,p_desc=?,p_discount=?,p_remark=? where p_id=?";
		this.jdbcTemplate.update(
				sql,
				new Object[] { p.getNumber(), p.getName(), p.isRecommend(),
						p.getThumbnail(), p.getImages(), p.getType(),
						p.getOrgin(), p.getMaterials(), p.getDesc(),
						p.getDiscount(), p.getRemark(), p.getId() });
	}

	@Override
	public void delete(ProductBase p) {
		// TODO Auto-generated method stub
		String sql = "Update t_product_base set deletemark=now() where p_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getId() });
	}

	@Override
	public void permanentlyDelete(ProductBase p) {
		// TODO Auto-generated method stub
		String sql = "delete from t_product_base where p_id=?";
		this.jdbcTemplate.update(sql, new Object[] { p.getId() });
	}

}
