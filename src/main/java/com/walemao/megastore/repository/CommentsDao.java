package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Comments;

public interface CommentsDao {
	public List<Comments> getComments(String parm,int type,Date startTime,Date endTime,int mark);
	public int insert(Comments c);
	public void update(Comments c);
	public void delete(Comments c);
}
