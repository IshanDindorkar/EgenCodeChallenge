/**
 * Entry point into Online Library Application
 */
package com.egen.codechallenge.application;

import com.egen.codechallenge.controller.OnlineLibController;
import com.egen.codechallenge.model.Book;
import com.egen.codechallenge.model.User;

import static spark.Spark.*;

/**
 * @author IshanD
 *
 */
public class OnlineLibApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		post("/createUser",(request,response) -> {
			if(String.valueOf(request.queryParams("gender")).equalsIgnoreCase("Male"))
				return OnlineLibController.createUser(request.queryParams("firstName"), request.queryParams("lastName"), Integer.parseInt(request.queryParams("age")), User.Gender.MALE, request.queryParams("phoneNumber"), request.queryParams("zipCode"));
			else
				return OnlineLibController.createUser(request.queryParams("firstName"), request.queryParams("lastName"), Integer.parseInt(request.queryParams("age")), User.Gender.FEMALE, request.queryParams("phoneNumber"), request.queryParams("zipCode"));
		});
		
		get("/getAllUsers",(request,response) -> {
			return OnlineLibController.getAllUsers();	
		});
		
		post("/updateUser",(request,response) -> {
			if(String.valueOf(request.queryParams("gender")).equalsIgnoreCase("Male"))
				OnlineLibController.updateUser(request.queryParams("id"), request.queryParams("firstName"), request.queryParams("lastName"), Integer.parseInt(request.queryParams("age")), User.Gender.MALE, request.queryParams("phoneNumber"), request.queryParams("zipCode"));
			else
				OnlineLibController.updateUser(request.queryParams("id"), request.queryParams("firstName"), request.queryParams("lastName"), Integer.parseInt(request.queryParams("age")), User.Gender.FEMALE, request.queryParams("phoneNumber"), request.queryParams("zipCode"));
			return "User details with id "+request.queryParams("id")+" are updated successfully!!!";
		});
		
		post("/addBook", (request,response) -> {
			String[] authors = request.queryParamsValues("author");
			String id = OnlineLibController.addBook(request.queryParams("bookName"), authors);
			return "Book is added to the catalogue. The book id is "+id;
		});
		
		get("/getAllBooks",(request,response) -> {
			return OnlineLibController.getAllBooks();	
		});
		
		get("/findBookByName", (request,response) -> {
			Book book = OnlineLibController.findBookByName(request.queryParams("bookName"));
			if(book == null)
				return "Book is not available in the library";
			else
				return book;	
		});
		
		get("/checkoutBook", (request,response) -> {
			int status = OnlineLibController.checkoutBook(request.queryParams("userId"), request.queryParams("bookId"));
			switch(status){
				case 1: return "Book with Id "+ request.queryParams("bookId") + " is issued to user with Id " + request.queryParams("userId");
				case -1: return "Book is already checked out";
				case 0: return "Either book or user does not exist in the system";
			}
			return null;
		});
	}

}
