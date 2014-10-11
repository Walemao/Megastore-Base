package com.walemao.megastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InsertUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 3000; ++i) {
			String name = UUID.randomUUID().toString();
			list.add(name);
			System.out.println("insert into t_user(u_username) values ('" + name + "');");
		}
		//t.Insert(list);
	}

}
