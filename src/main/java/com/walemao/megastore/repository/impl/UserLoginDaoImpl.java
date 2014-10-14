package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.UserLogin;
import com.walemao.megastore.domain.mapper.UserLoginMapper;
import com.walemao.megastore.repository.UserLoginDao;
import com.walemao.megastore.util.DateUtil;

@Repository
public class UserLoginDaoImpl extends CommonDaoImpl implements UserLoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(UserLogin userLogin) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_login(ul_username) values(?)";
		return this.addIntoDB(sql, new Object[] { userLogin.getUsername() });
	}

	@Override
	public List<UserLogin> getUserLogin(Date startTime, Date endTime,
			String username) {
		// TODO Auto-generated method stub
		String sql = "select ul_id,ul_username,ul_lastlogin from t_user_login where 1=1";
		List<String> list = new ArrayList<String>();
		if (startTime != null && endTime != null) {
			sql += " and (ul_lastlogin between ? and ? )";
			list.add(DateUtil.FormatToD(startTime));
			list.add(DateUtil.FormatToD(endTime));
		}
		if (username == null || username.equals("")) {

		} else {
			sql += " and a.ul_username like ?";
			list.add("%" + username + "%");
		}
		sql += " limit 20";
		return this.jdbcTemplate.query(sql, list.toArray(),
				new UserLoginMapper());
	}

}
