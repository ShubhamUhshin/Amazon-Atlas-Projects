package com.amazon.internalclassifieds.db;

import java.math.BigInteger;
import java.security.MessageDigest;

public class passwordEncryptor {
	
	// Creating object using Singleton design pattern
	private static passwordEncryptor passEncryptor = new passwordEncryptor();
	public static passwordEncryptor getInstance() {
		return passEncryptor;
	}
	
	// Encrypting Password
	public String encryptor (String password){
		try {
			
			// Encrypting into SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(password.getBytes());
			
			// Converting the messageDigest byte array into big Int
			BigInteger bigInt = new BigInteger(1,messageDigest);
			
			// Converting the big int to string
			return bigInt.toString(16);
		}
		catch(Exception e) {
			System.err.println("Exception occured:"+e);
		}
		
		return password; 
		
	}
}
