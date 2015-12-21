/**
 *	Controller class containing business logic for all service endpoints exposed in the form of REST API 
 *	for Online Library Management System 
 */
package com.egen.codechallenge.controller;

import java.util.ArrayList;
import java.util.List;
import com.egen.codechallenge.model.Book;
import com.egen.codechallenge.model.User;

/**
 * @author IshanD
 *
 */
public class OnlineLibController {
	
	private static List<User> registeredUsers = new ArrayList<User>();
	private static List<Book> books = new ArrayList<Book>();
		
	public static String createUser(String firstName, String lastName, int age, User.Gender gender, String phoneNumber, String zipCode){
		for(User u:registeredUsers)	{
			if(u.getFirstName().equalsIgnoreCase(firstName) && u.getLastName().equalsIgnoreCase(lastName))
				return "User already exist in the system. The User Id is "+u.getId().toString();
		}
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(age);
		user.setGender(gender);
		user.setPhoneNumber(phoneNumber);
		user.setZipCode(zipCode);
		registeredUsers.add(user);
		return "User "+user.getFirstName()+" "+user.getLastName() + " is created successfully in the system. The User Id is "+user.getId();
	}
	
	public static List<User> getAllUsers(){
		return registeredUsers;
	}
	
	public static void updateUser(String id, String firstName, String lastName, int age, User.Gender gender, String phoneNumber, String zipCode){
		
		for(User user: registeredUsers)
			if(user.getId().toString().equalsIgnoreCase(id)){
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAge(age);
				user.setGender(gender);
				user.setPhoneNumber(phoneNumber);
				user.setZipCode(zipCode);
			}
	}
	
	public static String addBook(String bookName, String[] authors){
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthors(authors);
		books.add(book);
		return book.getId().toString();
	}
	
	public static List<Book> getAllBooks(){
		return books;
	}
	
	public static Book findBookByName(String bookName){
		for(Book book: books){
			if(book.getBookName().equalsIgnoreCase(bookName))
				return book;
		}
		return null;
	}
	
	public static int checkoutBook(String userId, String bookId){
				
		for(User user:registeredUsers){
			if(user.getId().toString().equalsIgnoreCase(userId)){
				for(Book b:books){
					if(b.getId().toString().equalsIgnoreCase(bookId)){
						if(b.getBorrower()==null){
							b.setBorrower(user);
							return 1;
						}
						else {
							return -1;
						}
						
					}
				}
			}
		}
		return 0;
	}
}
