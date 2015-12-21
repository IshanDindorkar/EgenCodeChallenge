/**
 * Model class that represent a book in the Online Library Management System
 */

package com.egen.codechallenge.model;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author IshanD
 *
 */
public class Book {
	
	private final UUID id = UUID.randomUUID();
	private String bookName;
	private String[] authors;
	private User borrower;
	/**
	 * Constructor for initializing an instance of type Book
	 */
	public Book() {
		super();
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the authors
	 */
	public String[] getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	/**
	 * @return the borrower
	 */
	public User getBorrower() {
		return borrower;
	}
	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(borrower!=null)
			return "Book {id=" + id + ", bookName=" + bookName + ", authors="
			+ Arrays.toString(authors) 
			+ " borrower=" + borrower.getFirstName() + " " + borrower.getLastName()
			+ "} \n";
		else
			return "Book {id=" + id + ", bookName=" + bookName + ", authors="
			+ Arrays.toString(authors) 
			+ "} \n";
	}
}
