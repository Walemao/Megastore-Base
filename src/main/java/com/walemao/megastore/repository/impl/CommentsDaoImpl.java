package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.Comments;
import com.walemao.megastore.domain.mapper.CommentsMapper;
import com.walemao.megastore.repository.CommentsDao;

@Repository
public class CommentsDaoImpl extends CommonDaoImpl implements CommentsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Comments> getComments(Date startTime, Date endTime, int mark) {
		// TODO Auto-generated method stub
		String args = mark == 0 ? "null" : "not null";
		String sql = "select c_id,c_username,c_content,c_type,c_productid,c_orderdetailid,c_createtime from t_comments where deletemark is " + args;
		List<Object> list = new ArrayList<Object>();
		if (startTime != null && endTime != null) {
			sql += " and c_createtime between ? and ?";
			list.add(startTime);
			list.add(endTime);
		}
		sql += " order by c_createtime desc";
		return this.jdbcTemplate.query(sql, list.toArray(),
				new CommentsMapper());
	}

	@Override
	public int insert(Comments c) {
		// TODO Auto-generated method stub
		String sql = "insert into t_comments(c_username,c_content,c_type,c_productid,c_orderdetailid,c_createtime) values(?,?,?,?,?,now())";
		return this.addIntoDB(
				sql,
				new Object[] { c.getUsername(), c.getContent(), c.getType(),
						c.getProductid(), c.getOrderdetailid() });
	}

	@Override
	public void update(Comments c) {
		// TODO Auto-generated method stub
		String sql = "update t_comments set c_content=?,c_type=? where c_id=?";
		this.jdbcTemplate.update(sql,
				new Object[] { c.getContent(), c.getType() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "update t_comments set deletemark=now() where c_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void permanentlyDelete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_comments where c_id=?";
		this.jdbcTemplate.update(sql, new Object[] { id });
	}

}
