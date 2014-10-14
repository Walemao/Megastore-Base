package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.UserLogin;

public interface UserLoginDao {
	/**
	 * 查询某一用户登陆情况
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @param username	用户名
	 * @return	返回20条记录
	 */
	public List<UserLogin> getUserLogin(Date startTime,Date endTime,String username);
	public int insert(UserLogin userLogin);
}
