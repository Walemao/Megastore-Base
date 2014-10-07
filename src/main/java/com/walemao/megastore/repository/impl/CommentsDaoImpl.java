package com.walemao.megastore.repository.impl;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Comments;
import com.walemao.megastore.repository.CommentsDao;

public class CommentsDaoImpl extends CommonDaoImpl implements CommentsDao {

	@Override
	public List<Comments> getComments(String parm, int type, Date startTime,
			Date endTime, int mark) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Comments c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Comments c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Comments c) {
		// TODO Auto-generated method stub

	}

}
