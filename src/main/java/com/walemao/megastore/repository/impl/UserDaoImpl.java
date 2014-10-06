package com.walemao.megastore.repository.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.User;
import com.walemao.megastore.domain.mapper.UserMapper;
import com.walemao.megastore.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> getUsers() {
		String sql = "select u_id,u_username,u_password,u_mobilephone,u_email,u_createtime,u_remark,u_type,u_level from t_user where deletemark is null order by u_createtime desc";
		return this.jdbcTemplate.query(sql, new UserMapper());
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		String sql = "select u_id,u_username,u_password,u_mobilephone,u_email,u_createtime,u_remark,u_type,u_level from t_user where u_id = ? limit 1" ;
		return this.jdbcTemplate.query(sql, new Object[]{ id }, new UserMapper()).get(0);
	}
}
