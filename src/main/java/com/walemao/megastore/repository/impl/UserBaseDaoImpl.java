package com.walemao.megastore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.UserBase;
import com.walemao.megastore.domain.mapper.UserBaseMapper;
import com.walemao.megastore.repository.UserBaseDao;

@Repository
public class UserBaseDaoImpl extends CommonDaoImpl implements UserBaseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserBase getUserBase(String username) {
		// TODO Auto-generated method stub
		String sql = "select u_id,u_username,u_head_portrait,u_nickname,u_realname,u_sex,u_birth,u_isval_email,u_provices,u_cities,u_districts,u_address,u_zipcode,u_isval_mobilephone,u_telphone from t_user_base where u_username = ? limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { username },
				new UserBaseMapper()).get(0);
	}

	@Override
	public int insert(UserBase u) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user_base(u_username,u_head_portrait,u_nickname,u_realname,u_sex,u_birth,u_isval_email,u_provices,u_cities,u_districts,u_address,u_zipcode,u_isval_mobilephone,u_telphone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return this.addIntoDB(
				sql,
				new Object[] { u.getUsername(), u.getHead_portrait(),
						u.getNickname(), u.getRealname(), u.getSex(),
						u.getBirth(), u.getIsval_email(), u.getProvices(),
						u.getCities(), u.getDistricts(), u.getAddress(),
						u.getAddress(), u.getZipcode(),
						u.getIsval_mobilephone(), u.getTelphone() });
	}

	@Override
	public void update(UserBase u) {
		// TODO Auto-generated method stub
		String sql = "update t_user_base set u_head_portrait=?,u_nickname=?,u_realname=?,u_sex=?,u_birth=?,u_isval_email=?,u_provices=?,u_cities=?,u_districts=?,u_address=?,u_zipcode=?,u_isval_mobilephone=?,u_telphone=? where u_username=?";
		this.jdbcTemplate.update(
				sql,
				new Object[] { u.getHead_portrait(), u.getNickname(),
						u.getRealname(), u.getSex(), u.getBirth(),
						u.getIsval_email(), u.getProvices(), u.getCities(),
						u.getDistricts(), u.getAddress(), u.getAddress(),
						u.getZipcode(), u.getIsval_mobilephone(),
						u.getTelphone(), u.getUsername() });
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete from t_user_base where u_username=?";
		this.jdbcTemplate.update(sql, new Object[] { username });
	}

}
