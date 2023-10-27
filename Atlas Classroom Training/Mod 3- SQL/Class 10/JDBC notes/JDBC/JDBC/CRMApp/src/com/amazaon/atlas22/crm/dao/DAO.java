package com.amazaon.atlas22.crm.dao;

import java.util.List;

// DAO -> Design Pattern
// 		  Database Access Object :)
public interface DAO<T> {

	int insert(T object); // eg: return 1 i.e. record inserted and return 0 means record not inserted
	int update(T object);
	int delete(T object);
	List<T> query();	  // eg return ArrayList of Objects
	
}
