package com.amazon.atlas22.railwaycrossingapp;

import java.io.Console;

public class PasswordReadApp {

	public static void main(String[] args) {
		
		try {
			Console console = System.console();
			
			if(console == null) {
				System.err.println("Could Not Get The Console Reference...");
				return;
			}
			
			console.printf("Enter Email: \n");
			String email = console.readLine();
			console.printf("Email is "+email+"\n");
			
			char[] password = console.readPassword("Enter Your Password: ");
			for(char ch : password) {
				System.out.print("*");
			}
			
			System.out.println();
			System.out.println("Password is: " + new String(password));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went Wrong: "+e);
		}

	}

}
