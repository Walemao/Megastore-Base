package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Proposal;

public interface ProposalDao {
	public List<Proposal> getProposals(String parm, int subject,
			Date startTime, Date endTime);
	
}
