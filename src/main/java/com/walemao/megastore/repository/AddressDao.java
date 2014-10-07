package com.walemao.megastore.repository;

import java.util.List;

import com.walemao.megastore.domain.Address;

public interface AddressDao {
	public List<Address> getAddresses(String username);
	public int insert(Address a);
	public void update(Address a);
	public void changeDefault(Address a);
	public void delete(int id);
}
