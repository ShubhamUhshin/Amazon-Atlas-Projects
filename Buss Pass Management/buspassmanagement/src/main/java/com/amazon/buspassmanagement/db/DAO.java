package com.amazon.buspassmanagement.db;

import java.util.List;

public interface DAO<T>{

	int insert (T object);
	int delete (T object);
	int update (T object);
	List<T> retrieve();	
	// To Retrieve Custom Data by passing select * query...
	List<T> retrieve(String sql);
}
