package utils;

import java.util.List;
import static java.lang.Thread.sleep;
import core.Customer;
import customException.CustomerCustomExceptions;

public class CustomerEntitiesValidator {
	
	static Customer customerObj = null;

	public static void decoration(Customer cust1) throws InterruptedException
	{
		System.out.print("Logging in ");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");System.out.println("\nWelcome ,"+cust1.getFirstName());
	}
	
	
	public static Customer emailCheckExists(List<Customer> arr, String mail) throws CustomerCustomExceptions
	{
		Customer customer = new Customer(mail);
		int index = arr.indexOf(customer);
		if(index==-1)
			throw new CustomerCustomExceptions("Email does not Exists.....!!!!");
		
		return arr.get(index);
	}
	
	
	public static void unsubscribe(List<Customer> arr, String mail) throws CustomerCustomExceptions,InterruptedException
	{
		customerObj = emailCheckExists(arr, mail);
		arr.remove(customerObj);
		System.out.print("Removing Customer ");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");System.out.println("\nRemoval Successfull....!");

	}
	
	
	public static Customer emailAndPasswordCheckExists(List <Customer> arr,String email,String password) throws CustomerCustomExceptions
	{
		customerObj = emailCheckExists(arr, email);
		
		if(!customerObj.getPasssword().equals(password))
			throw new CustomerCustomExceptions("Password does not Match......!!!!");
		
		return customerObj;
		
	}
	
	
	
	public static void changePassword(List<Customer> arr, String mail, String oldPass, String NewPass) throws CustomerCustomExceptions,InterruptedException
	{
		Customer passwordChangeCustomer =  emailAndPasswordCheckExists(arr, mail, oldPass);
		passwordChangeCustomer.setPasssword(NewPass);
		System.out.print("Changing Password ");
		sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");sleep(500);System.err.print(".");
		System.out.println("\nPassword Changed....!!!");
	}
	
	
	public static void display(List<Customer> arr)
	{
		for (Customer c : arr) {
			System.out.println(c);
		}
	}
	
	
}
