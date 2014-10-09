package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Proposal;

public interface ProposalDao {
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
	 * @return 所有建议留言列表
	 */
	public List<Proposal> getProposals(String parm, int subject,
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
	 *            用户名，为null默认获取全部
	 * @return 所有建议留言列表
	 */
	public List<Proposal> getProposals(String parm, int subject,
			Date startTime, Date endTime,String username);

	public int insert(Proposal p);

	public void delete(int id);

}
