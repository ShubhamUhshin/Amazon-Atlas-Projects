package com.amazaon.atlas22.crm;

import java.util.List;
import java.util.Scanner;

import com.amazaon.atlas22.crm.dao.CustomerDAO;
import com.amazaon.atlas22.crm.model.Customer;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("[App] Initializing DataBase....");
		
		CustomerDAO dao = new CustomerDAO();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-------");
		System.out.println("CRM App");
		System.out.println("-------");
		
		while(true) {

			System.out.println("Menu");
			System.out.println("1: Insert New Customer");
			System.out.println("2: Update Existing Customer");
			System.out.println("3: Delete Existing Customer");
			System.out.println("4: Fetch All Customers");
			System.out.println("5: Quit CRM App");
			System.out.println("Enter Your Choice: ");
						
			int choice = scanner.nextInt();
			
			if(choice == 1) {
				
				scanner.nextLine();
				
				Customer customer = new Customer();
				
				System.out.println("Enter Customer Name: ");
				customer.name = scanner.nextLine();
				
				System.out.println("Enter Customer Phone: ");
				customer.phone = scanner.nextLine();
				
				System.out.println("Enter Customer Email: ");
				customer.email = scanner.nextLine();
				
				System.out.println("Enter CashBack Points: ");
				customer.cashBack = scanner.nextInt();
				
				int result = dao.insert(customer);
				if(result > 0) {
					System.out.println(customer.name+" Inserted...");
				}else {
					System.out.println(customer.name+" Not Inserted...");
				}
				
			}else if(choice == 2) {
				
				scanner.nextLine();
				
				Customer customer = new Customer();
				
				System.out.println("Enter Customer Name: ");
				customer.name = scanner.nextLine();
				
				System.out.println("Enter Customer Phone: ");
				customer.phone = scanner.nextLine();
				
				System.out.println("Enter Customer Email: ");
				customer.email = scanner.nextLine();
				
				System.out.println("Enter CashBack Points: ");
				customer.cashBack = scanner.nextInt();
				
				System.out.println("Enter Customer ID: ");
				customer.cid = scanner.nextInt();
				
				int result = dao.update(customer);
				if(result > 0) {
					System.out.println(customer.name+" Updated...");
				}else {
					System.out.println(customer.name+" Not Updated...");
				}
				
			}else if(choice == 3) {
				
				scanner.nextLine();
				
				Customer customer = new Customer();
				
				System.out.println("Enter Customer ID: ");
				customer.cid = scanner.nextInt();
				
				int result = dao.delete(customer);
				if(result > 0) {
					System.out.println(customer.cid+" Deleted...");
				}else {
					System.out.println(customer.name+" Not Deleted...");
				}
				
			}else if(choice == 4) {
				
				List<Customer> customers = dao.query();
				for(Customer customer : customers) {
					System.out.println(customer);
				}
				
			}else if(choice == 5) {
				System.out.println("Thank you for Using CRM App :)");
				System.out.println("B.Byee....");
				scanner.close();
				break;
			}else {
				System.out.println("Invalid Choice");
			}	
			
		}
		
	}

}
