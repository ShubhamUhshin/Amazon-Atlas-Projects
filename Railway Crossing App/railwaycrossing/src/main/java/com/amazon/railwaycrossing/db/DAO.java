package com.amazon.railwaycrossing.db;

import java.util.List;

public interface DAO<T> {
	
	int insert (T Object);
	int delete (T Object);
	int update (T Object);
	List<T> retrieve();
	List<T> retrieve (String sql);

}
