package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.UserDetail;
import com.walemao.megastore.domain.mapper.UserDetailMapper;
import com.walemao.megastore.repository.UserDetailDao;

@Repository
public class UserDetailDaoImpl extends CommonDaoImpl implements UserDetailDao {

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
	public int insert(UserDetail u) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_detail(u_username,u_matrial_status,u_education,u_professional,u_industry,u_income,u_interests,u_selfdesc) values(?,?,?,?,?,?,?,?)";
		return this.addIntoDB(
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
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user_detail where u_username=?";
		this.jdbcTemplate.update(sql, new Object[] { username });
	}

}
