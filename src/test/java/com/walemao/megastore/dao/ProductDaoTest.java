package com.walemao.megastore.dao;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.repository.ProductBaseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/bean-test.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class ProductDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	
	@Before
	public void testBefore() {
		this.executeSqlScript("/com/walemao/megastore/sql/add_product_test_data.sql", false);
	}

	@After
	public void testAfter() {
		this.executeSqlScript("/com/walemao/megastore/sql/delete_product_test_data.sql", false);
	}

	@Autowired
	private ProductBaseDao productBaseDao;

	/****** 以下开始编写测试用例 *******/

	@Test
	public void t_02_addProduct() {
		ProductBase pb = new ProductBase();
		pb.setName("飞机模型");
		int i = productBaseDao.insert(pb);
		ProductBase pbDB =  productBaseDao.getProduct(i);
		
		//预测结果和实际结果对比
		Assert.assertEquals("飞机模型", pbDB.getName());
	}
	
	@Test
	public void t_01_findProductById() {
		ProductBase pb = new ProductBase();
		pb.setName("飞机模型");
		int i = productBaseDao.insert(pb);
		ProductBase pbDB =  productBaseDao.getProduct(i);
		
		//预测结果和实际结果对比
		Assert.assertEquals("飞机模型", pbDB.getName());
	}

}
