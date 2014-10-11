package com.walemao.megastore;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	ApplicationContext ac = new FileSystemXmlApplicationContext("/WEB-INF/spring/spring-context.xml");
	JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");

	public List<String> Insert(final List<String> mList) {
		System.out.println("#########################");
		String sql0 = "select 1 from t_user where u_username='abc' limit 1";
		int key = this.jdbcTemplate.update(sql0);
		System.out.println(key);
		String sql = "insert into t_user(u_username) values(?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				// TODO Auto-generated method stub
				String name = mList.get(i);
				ps.setString(1, name);
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return mList.size();
			}
		});
		return mList;
	}
}
