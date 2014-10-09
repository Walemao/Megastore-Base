package com.walemao.megastore.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.Complaint;
import com.walemao.megastore.domain.mapper.ComplaintMapper;
import com.walemao.megastore.repository.ComplaintDao;
import com.walemao.megastore.util.DateUtil;

@Repository
public class ComplaintDaoImpl extends CommonDaoImpl implements ComplaintDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;

	@Override
	public List<Complaint> getComplaints(String parm, int subject,
			Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return this.getComplaints(parm, subject, startTime, endTime, null);
	}

	@Override
	public List<Complaint> getComplaints(String parm, int subject,
			Date startTime, Date endTime, String username) {
		// TODO Auto-generated method stub
		String sql = "select c_id,c_username,c_subject,c_name,c_province,c_city,c_contact,c_email,c_orderid,c_content,c_createtime from t_complaints where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (parm == null || parm.length() <= 0) {
		} else {
			sql += " and c_content like ?";
			list.add("%" + parm + "%");
		}
		if (subject != 0) {
			sql += " and c_subject = ?";
			list.add(subject);
		}
		if (username == null || parm.length() <= 0) {
		} else {
			sql += " and c_username = ?";
			list.add(username);
		}
		if (startTime != null && endTime != null) {
			sql += " and c_createtime between ? and ?";
			list.add(DateUtil.FormatToD(startTime));
			list.add(DateUtil.FormatToD(endTime));
		}
		sql += " order by c_createtime desc";
		return this.JdbcTemplate.query(sql, list.toArray(),
				new ComplaintMapper());
	}

	@Override
	public int insert(Complaint c) {
		// TODO Auto-generated method stub
		String sql = "insert into t_complaints(c_username,c_subject,c_name,c_province,c_city,c_contact,c_email,c_orderid,c_content,c_createtime) values"
				+ "(?,?,?,?,?,?,?,?,?,now())";
		return this.addIntoDB(
				sql,
				new Object[] { c.getUsername(), c.getSubject(), c.getName(),
						c.getProvince(), c.getCity(), c.getContact(),
						c.getEmail(), c.getOrderId(), c.getContent() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_complaints where c_id = ?";
		this.JdbcTemplate.update(sql, new Object[] { id });
	}

}
