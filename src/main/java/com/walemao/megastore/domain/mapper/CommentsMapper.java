package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.Comments;

public class CommentsMapper implements RowMapper<Comments> {

	@Override
	public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Comments c = new Comments();
		
		return c;
	}

}
