package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.walemao.megastore.domain.Proposal;

public class ProposalMapper implements ParameterizedRowMapper<Proposal> {

	@Override
	public Proposal mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Proposal proposal = new Proposal();
		proposal.setId(rs.getInt("p_id"));
		proposal.setUsername(rs.getString("p_username"));
		proposal.setSubject(rs.getInt("p_subject"));
		proposal.setName(rs.getString("p_name"));
		proposal.setProvince(rs.getInt("p_province"));
		proposal.setCity(rs.getInt("p_city"));
		proposal.setContact(rs.getString("p_contact"));
		proposal.setEmail(rs.getString("p_email"));
		proposal.setContent(rs.getString("p_content"));
		proposal.setCreateTime(rs.getTimestamp("p_creattime"));
		return proposal;
	}

}
