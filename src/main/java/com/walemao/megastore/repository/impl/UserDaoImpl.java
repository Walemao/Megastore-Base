package com.walemao.megastore.repository.impl;

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
import com.walemao.megastore.util.PaginationHelper;

@Repository
public class UserDaoImpl extends CommonDaoImpl implements UserDao {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String queryCount = "select count(1)"
			+ " from t_user a left join t_user_base b on a.u_username = b.u_username";
	private String querySql = "select a.u_id as u_id,a.u_username as u_username,u_password,u_mobilephone,"
			+ "u_email,u_createtime,u_remark,u_type,u_level,u_head_portrait"
			+ " from t_user a left join t_user_base b on a.u_username = b.u_username";

	public CurrentPage<User> getUsers(String username)
			throws DataAccessException {
		PaginationHelper<User> ph = new PaginationHelper<User>();
		if (username == null || username.equals("")) {
			String appendSql = " where deletemark is null order by u_createtime desc";
			return ph.fetchPage(jdbcTemplate, queryCount + appendSql, querySql
					+ appendSql, new Object[] {}, CurrentPage.getPageNubmer(),
					CurrentPage.getPageLength(), new UserMapper());
		} else {
			String appendSql = " where deletemark is null and a.u_username like ? order by u_createtime desc";
			return ph.fetchPage(jdbcTemplate, queryCount + appendSql, querySql
					+ appendSql, new Object[] { "%" + username + "%" },
					CurrentPage.getPageNubmer(), CurrentPage.getPageLength(),
					new UserMapper());
		}
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		String sql = querySql
				+ " where u_id = ? and deletemark is null limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { id },
				new UserMapper()).get(0);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		String sql = querySql
				+ " where u_username = ? and deletemark is null limit 1";
		return this.jdbcTemplate.query(sql, new Object[] { username },
				new UserMapper()).get(0);
	}

	@Override
	public void updatePasswd(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set u_password =? where u_username = ? and deletemark is null";
		this.jdbcTemplate.update(sql,
				new Object[] { user.getPassword(), user.getUserName() });
	}

	@Override
	public void updateEmail(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set u_email =? where u_username = ? and deletemark is null";
		this.jdbcTemplate.update(sql,
				new Object[] { user.getEmail(), user.getUserName() });

	}

	@Override
	public void updateMobilephone(User user) {
		// TODO Auto-generated method stub
		String sql = "update t_user set u_mobilephone =? where u_username = ? and deletemark is null";
		this.jdbcTemplate.update(sql, new Object[] { user.getMobilephone(),
				user.getUserName() });

	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user(u_username,u_password,u_mobilephone,u_email,u_createtime) values(?,?,?,?,now())";
		return this.addIntoDB(
				sql,
				new Object[] { user.getUserName(), user.getPassword(),
						user.getMobilephone(), user.getEmail() });
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean CheckUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select 1 from t_user where u_username=? and deletemark is null limit 1";
		return this.jdbcTemplate.queryForInt(sql, new Object[] { username }) == 1 ? true
				: false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean CheckMobilephone(String mobilephone) {
		// TODO Auto-generated method stub
		String sql = "select 1 from t_user where u_mobilephone=? and deletemark is null limit 1";
		return this.jdbcTemplate.queryForInt(sql, new Object[] { mobilephone }) == 1 ? true
				: false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean CheckEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "select 1 from t_user where u_email=? and deletemark is null limit 1";
		return this.jdbcTemplate.queryForInt(sql, new Object[] { email }) == 1 ? true
				: false;
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		String sql = "update t_user set deletemark=now() where u_username=? and deletemark is null";
		this.jdbcTemplate.update(sql, new Object[] { username });
	}

}
