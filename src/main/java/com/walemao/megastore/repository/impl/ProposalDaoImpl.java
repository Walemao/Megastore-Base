package com.walemao.megastore.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.Proposal;
import com.walemao.megastore.repository.ProposalDao;

@Repository
public class ProposalDaoImpl extends CommonDaoImpl implements ProposalDao {

	@Override
	public List<Proposal> getProposals(String parm, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		String sql = "select p_id,p_username,p_subject,p_name,p_province,p_city,p_contact,p_email,p_content,p_creattime from t_proposal where 1=1";
		return null;
	}

}
