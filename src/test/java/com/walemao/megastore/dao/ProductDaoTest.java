package com.walemao.megastore.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.walemao.megastore.repository.ProductBaseDao;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = "/bean-test.xml")  
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class ProductDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Before
	public void testBefore(){
		
	}
	
	@After
	public void testAfter(){
		
	}
	
	@Autowired
	private ProductBaseDao productBaseDao;
	
	@Test
	public void t_01_addProduct(){
		
	}

}
