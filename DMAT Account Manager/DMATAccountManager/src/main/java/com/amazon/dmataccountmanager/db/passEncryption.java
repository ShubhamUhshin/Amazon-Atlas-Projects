package com.amazon.dmataccountmanager.db;

import java.math.BigInteger;
import java.security.MessageDigest;

public class passEncryption {
	
	// Creating object using Singleton design pattern
	private static passEncryption passEncryptor = new passEncryption();
	public static passEncryption getInstance(){
		return passEncryptor;
	}
	
	// Encrypting Password
	public String encryptor(String password){
		try {
			// Encrypting into SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] digestedBytes = md.digest();
			
			// Converting the messageDigest byte array into big Int
			BigInteger bigInt= new BigInteger(1,digestedBytes);
			
			// Converting the big int to string
			return bigInt.toString(16);
		
		} 
		catch (Exception e) {
			System.out.println("Something went wrong during encryption: "+e);
		}
		
		return password;
	}
}
