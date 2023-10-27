package com.amazaon.atlas22.crm.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazaon.atlas22.crm.model.Customer;

public class CustomerDAO implements DAO<Customer> {
	
	DB db = DB.getDB();

	@Override
	public int insert(Customer object) {
		
		//String sql = "INSERT INTO Customer(name, phone, email, cashback) VALUES ('"+object.getName()+"', '"+object.getPhone()+"', '"+object.getEmail()+"', "+object.getCashBack()+")";
		
        String sql = "INSERT INTO Customer(name, phone, email, cashback) VALUES (?, ?, ?, ?)"; 
		
		System.out.println("SQL Statement: "+sql);
		
		// executeSQL here uses Statement API
		//int result = db.executeSQL(sql);
		
		// executeSQL here uses PrearedStatement API
		int result = db.executeSQL(sql, object);
		
		return result;
	}

	@Override
	public int update(Customer object) {
		
		String sql = "UPDATE Customer SET name = '"+object.getName()+"', phone = '"+object.getPhone()+"', email = '"+object.getEmail()+"', cashBack = "+object.getCashBack()+" WHERE cid = "+object.getCid();
		System.out.println("SQL Statement: "+sql);
		
		int result = db.executeSQL(sql);
		
		return result;
	}

	@Override
	public int delete(Customer object) {
		
		String sql = "DELETE FROM Customer WHERE cid = "+object.getCid();
		System.out.println("SQL Statement: "+sql);
		
		int result = db.executeSQL(sql);
		
		return result;
	}

	@Override
	public List<Customer> query() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			
			String sql = "SELECT * from Customer";
			ResultSet set = db.executeRetrieveQuery(sql);
			
			while(set.next()) {
				
				Customer customer = new Customer();
				customer.cid = set.getInt("cid");
				customer.name = set.getString("name");
				customer.phone = set.getString("phone");
				customer.email = set.getString("email");
				customer.cashBack = set.getInt("cashBack");
				
				customers.add(customer);
			}
			
		} catch (Exception e) {
			System.out.println("Something Went Wrong: "+e);
		}
		
		return customers;
		
	}
	
}
