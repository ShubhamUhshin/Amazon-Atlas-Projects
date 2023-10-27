package com.amazon.atlas22.railwaycrossingapp.db;

import java.util.Map;
//Database Access Object  ->Design pattern .
public interface DAO{
	boolean set(Object object);
    boolean delete(Object object);
    Map <String,?> retrieveFromDB(Object object);
    //boolean exists(Object object);
    Object retrieve(String key);
}
