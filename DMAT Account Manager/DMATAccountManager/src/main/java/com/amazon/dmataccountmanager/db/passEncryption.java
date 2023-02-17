package com.amazon.dmataccountmanager.db;

import java.math.BigInteger;
import java.security.MessageDigest;

public class passEncryption {
	
	private static passEncryption encrypt = new passEncryption();
	
	public static passEncryption getInstance(){
		return encrypt;
	}
	
	public String encryptor(String password){
		try {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte[] digestedBytes = md.digest();
		BigInteger bigInt= new BigInteger(1,digestedBytes);
		return bigInt.toString(16);
		
		} catch (Exception e) {
			System.out.println("Something went wrong during encryption: "+e);
		}
		
		return password;
	}
}
