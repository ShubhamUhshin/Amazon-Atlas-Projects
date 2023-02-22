package com.amazon.buspassmanagement.db;

import java.security.MessageDigest;
import java.math.BigInteger;

public class passwordEncryptor {
	
	// Using singleton design pattern to create object
	private static passwordEncryptor passEncryptor = new passwordEncryptor();
	public static passwordEncryptor getInstance() {
		return passEncryptor;
	}
	
	// Encrypting Password
	public String encryptor (String password){
		try {
			// Encrypting using SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(password.getBytes());
			// Converting into big Integer
			BigInteger bigInt = new BigInteger(1,messageDigest);
			// Converting into string
			return bigInt.toString(16);
		}
		catch(Exception e) {
			System.err.println("Exception occured:"+e);
		}
		
		return password; 
		
	}

}
