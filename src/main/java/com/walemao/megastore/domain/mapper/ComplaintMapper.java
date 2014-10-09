package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.Complaint;

public class ComplaintMapper implements RowMapper<Complaint> {

	@Override
	public Complaint mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Complaint cp = new Complaint();
		cp.setId(rs.getInt("c_id"));
		cp.setSubject(rs.getInt("c_subject"));
		cp.setName(rs.getString("c_name"));
		cp.setProvince(rs.getInt("c_province"));
		cp.setCity(rs.getInt("c_city"));
		cp.setContact(rs.getString("c_contact"));
		cp.setEmail(rs.getString("c_email"));
		cp.setOrderId(rs.getInt("c_orderid"));
		cp.setContent(rs.getString("c_content"));
		cp.setCreateTime(rs.getTimestamp("c_createtime"));
		return cp;
	}

}
