package com.amazon.dmataccountmanager.db;

import java.util.List;

//Database Access Object
//CRUD operations on a Table 
public interface DAO<T> {

	int insert(T object);
	int update(T object);
	int delete(T object);
	List<T> retrieve();
	
	// To retrieve custom data by passing Select * query...
	List<T> retrieve(String sql);
	
}
