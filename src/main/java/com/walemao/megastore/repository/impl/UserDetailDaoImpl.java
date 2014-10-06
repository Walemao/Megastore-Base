package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.walemao.megastore.domain.UserDetail;
import com.walemao.megastore.domain.mapper.UserDetailMapper;
import com.walemao.megastore.repository.UserDetailDao;

public class UserDetailDaoImpl implements UserDetailDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserDetail getUserDetail(String username) {
		// TODO Auto-generated method stub
		String sql = "select u_id,u_username,u_matrial_status,u_education,u_professional,u_industry,u_income,u_interests,u_selfdesc from t_user_detail where u_username = ? limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { username },
				new UserDetailMapper()).get(0);
	}

	@Override
	public void insert(UserDetail u) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_detail(u_username,u_matrial_status,u_education,u_professional,u_industry,u_income,u_interests,u_selfdesc) values(?,?,?,?,?,?,?,?)";
		this.jdbcTemplate.update(
				sql,
				new Object[] { u.getUsername(), u.getMaterial_status(),
						u.getEducation(), u.getProfessional(), u.getIndustry(),
						u.getIncome(), u.getInterests(), u.getSelfdesc() });
	}

	@Override
	public void update(UserDetail u) {
		// TODO Auto-generated method stub
		String sql = "update t_user_detail set u_matrial_status=?,u_education=?,u_professional=?,u_industry=?,u_income=?,u_interests=?,u_selfdesc=? where u_username=?";
		this.jdbcTemplate.update(
				sql,
				new Object[] { u.getMaterial_status(), u.getEducation(),
						u.getProfessional(), u.getIndustry(), u.getIncome(),
						u.getInterests(), u.getSelfdesc(), u.getUsername() });
	}

	@Override
	public void delete(UserDetail u) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user_detail where u_username=?";
		this.jdbcTemplate.update(sql, new Object[] { u.getUsername() });
	}

}
