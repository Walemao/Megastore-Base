package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.User;
import com.walemao.megastore.domain.mapper.UserMapper;
import com.walemao.megastore.repository.UserDao;
import com.walemao.megastore.util.DateUtil;
import com.walemao.megastore.util.PaginationHelper;

@Repository
public class UserDaoImpl extends CommonDaoImpl implements UserDao {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String queryAgrs = "a.u_id as u_id,a.u_username as u_username,u_password,u_mobilephone,"
			+ "u_email,u_createtime,u_remark,u_type,u_level,u_enabled,u_head_portrait";
	private String querySql = "select " + queryAgrs
			+ " from t_user a left join t_user_base b"
			+ " on a.u_username = b.u_username where 1=1 and u_type<> 1 ";

	public CurrentPage<User> getUsers(String username, Date startTime,
			Date endTime, int type) throws DataAccessException {
		PaginationHelper<User> ph = new PaginationHelper<User>();
		String code = "";
		String sql1 = querySql;
		List<String> list = new ArrayList<String>();
		switch (type) {
		case 0:
			code = " and u_enabled = 0";
			sql1 += code;
			break;
		case 1:
			code = " and u_enabled = 1";
			sql1 += code;
			break;
		case 2:
			break;
		}
		if (startTime != null && endTime != null) {
			sql1 += " and (u_createtime between ? and ? )";
			list.add(DateUtil.FormatToD(startTime));
			list.add(DateUtil.FormatToD(endTime));
		}
		if (username == null || username.equals("")) {

		} else {
			sql1 += " and a.u_username like ?";
			list.add("%" + username + "%");
		}
		sql1 += " order by u_createtime desc";
		return ph.fetchPage(jdbcTemplate, sql1.replace(queryAgrs, "count(1)"),
				sql1, list.toArray(), CurrentPage.getPageNubmer(),
				CurrentPage.getPageLength(), new UserMapper());
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		String sql = querySql
				+ " and a.u_id = ? and u_enabled<> 0 limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { id },
				new UserMapper()).get(0);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		String sql = querySql
				+ " and a.u_username = ? and u_enabled<> 0 limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { username },
				new UserMapper()).get(0);
	}

	@Override
	public void updatePasswd(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "update t_user set u_password =? where u_username = ? and u_enabled<> 0";
		this.jdbcTemplate.update(sql,
				new Object[] { username, password });
	}

	@Override
	public void updateEmail(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set u_email =? where u_username = ? and u_enabled<> 0";
		this.jdbcTemplate.update(sql,
				new Object[] { user.getEmail(), user.getUsername() });

	}

	@Override
	public void updateMobilephone(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set u_mobilephone =? where u_username = ? and u_enabled<> 0";
		this.jdbcTemplate.update(sql, new Object[] { user.getMobilephone(),
				user.getUsername() });

	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user(u_username,u_password,u_salt) values(?,?,?)";
		return this.addIntoDB(
				sql,
				new Object[] { user.getUsername(), user.getPassword(),
						user.getSalt() });
	}

	
	@Override
	public boolean CheckUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select 1 from t_user where u_username=? and u_enabled<> 0 limit 1";
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql, new Object[] { username });
		return list.size() == 1 ? true : false;
	}

	@Override
	public boolean CheckMobilephone(String mobilephone) {
		// TODO Auto-generated method stub
		String sql = "select 1 from t_user where u_mobilephone=? and u_enabled<> 0 limit 1";
		List<Map<String, Object>> list =  this.jdbcTemplate.queryForList(sql, new Object[] { mobilephone });
		return list.size() == 1 ? true : false;
	}

	@Override
	public boolean CheckEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select 1 from t_user where u_email=? and u_enabled<> 0 limit 1";
		List<Map<String, Object>> list =  this.jdbcTemplate.queryForList(sql, new Object[] { email });
		return list.size() == 1 ? true : false;
	}

	@Override
	public void delete(String username, boolean flag) {
		// TODO Auto-generated method stub
		String args = flag ? "null" : "now()";
		String sql = "update t_user set deletemark=" + args
				+ ",u_enabled=? where u_username=?";
		this.jdbcTemplate.update(sql, new Object[] { flag, username });
	}

}
