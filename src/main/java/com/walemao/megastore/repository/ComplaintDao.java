package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Complaint;

public interface ComplaintDao {
	/**
	 * 
	 * @param parm
	 *            查询内容
	 * @param subject
	 *            查询主题 0是所有主题
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 所有投诉咨询列表
	 */
	public List<Complaint> getComplaints(String parm, int subject,
			Date startTime, Date endTime);

	/**
	 * 
	 * @param parm
	 *            查询内容
	 * @param subject
	 *            查询主题 0是所有主题
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param username
	 *            用户名
	 * @return 所有投诉咨询列表
	 */
	public List<Complaint> getComplaints(String parm, int subject,
			Date startTime, Date endTime, String username);

	/**
	 * 插入
	 * 
	 * @param c
	 */
	public int insert(Complaint c);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delete(int id);

}
