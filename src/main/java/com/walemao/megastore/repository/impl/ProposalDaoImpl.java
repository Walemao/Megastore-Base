package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.Proposal;
import com.walemao.megastore.domain.mapper.ProposalMapper;
import com.walemao.megastore.repository.ProposalDao;
import com.walemao.megastore.util.DateUtil;

@Repository
public class ProposalDaoImpl extends CommonDaoImpl implements ProposalDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public List<Proposal> getProposals(String parm, int subject,
			Date startTime, Date endTime, String username) {
		// TODO Auto-generated method stub
		String sql = "select p_id,p_username,p_subject,p_name,p_province,p_city,p_contact,p_email,p_content,p_createtime from t_proposal where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (parm == null || parm.length() <= 0) {
		} else {
			sql += " and p_content like ?";
			list.add("%" + parm + "%");
		}
		if (subject != 0) {
			sql += " and p_subject = ?";
			list.add(subject);
		}
		if (username == null || parm.length() <= 0) {
		} else {
			sql += " and p_username = ?";
			list.add(username);
		}
		if (startTime != null && endTime != null) {
			sql += " and p_createtime between ? and ?";
			list.add(DateUtil.FormatToD(startTime));
			list.add(DateUtil.FormatToD(endTime));
		}
		sql += " order by p_createtime desc";
		return this.JdbcTemplate.query(sql, list.toArray(),
				new ProposalMapper());
	}

	@Override
	public List<Proposal> getProposals(String parm, int subject,
			Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return this.getProposals(parm, subject, startTime, endTime, null);
	}

	@Override
	public int insert(Proposal p) {
		// TODO Auto-generated method stub
		String sql = "insert into t_proposal(p_username,p_subject,p_name,p_province,p_city,p_contact,p_email,p_content,p_createtime) values"
				+ "(?,?,?,?,?,?,?,?,now())";
		return this.addIntoDB(
				sql,
				new Object[] { p.getUsername(), p.getSubject(), p.getName(),
						p.getProvince(), p.getCity(), p.getContact(),
						p.getEmail(), p.getContent() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_proposal where p_id=?";
		this.JdbcTemplate.update(sql, new Object[] { id });
	}

}
