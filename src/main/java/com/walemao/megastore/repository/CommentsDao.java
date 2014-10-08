package com.walemao.megastore.repository;

import java.util.Date;
import java.util.List;

import com.walemao.megastore.domain.Comments;

public interface CommentsDao {
	public List<Comments> getComments(Date startTime,Date endTime,int mark);
	public int insert(Comments c);
	public void update(Comments c);
	/**
	 * 删除评论非永久
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 永久删除评论
	 * @param id
	 */
	public void permanentlyDelete(int id);
}
