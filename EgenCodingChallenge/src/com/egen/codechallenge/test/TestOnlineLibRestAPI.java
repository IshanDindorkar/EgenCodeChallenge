/**
 * JUnit Test Cases for all service endpoints defined in REST API for Online Library Management System
 */

package com.egen.codechallenge.test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

/**
 * @author IshanD
 *
 */
public class TestOnlineLibRestAPI {
	
	private final String BASE_URL = "http://localhost:4567";
	
	@Test
	public void testCreateUser(){
		HttpUriRequest request = new HttpPost(BASE_URL+"/createUser?firstName=Ishan&lastName=Dindorkar&age=30&gender=Male&phoneNumber=9729879137&zipCode=75067");
		assertCheck(request);
	}
	
	@Test
	public void testGetAllUsers(){
		HttpUriRequest request = new HttpPost(BASE_URL+"/createUser?firstName=Ishan&lastName=Dindorkar&age=30&gender=Male&phoneNumber=9729879137&zipCode=75067");
		assertCheck(request);
		request = new HttpGet(BASE_URL+"/getAllUsers");
		assertCheck(request);
	}
	
	@Test
	public void testUpdateUser(){
		HttpUriRequest request = new HttpPost(BASE_URL+"/updateUser?id=cbe47c52-9321-483b-8ada-f97c9f6fbc5f&firstName=ABC&lastName=DEF&age=45&gender=Female&phoneNumber=9926450869&zipCode=452007");
		assertCheck(request);
	}
	
	@Test
	public void testAddBook() throws UnsupportedEncodingException{
		HttpUriRequest request = new HttpPost(BASE_URL+"/addBook?bookName=ABC&author=DEF");
		assertCheck(request);
	}
	
	@Test
	public void testGetAllBooks(){
		HttpUriRequest request = new HttpPost(BASE_URL+"/addBook?bookName=MNO&author=IOP");
		assertCheck(request);
		request = new HttpGet(BASE_URL+"/getAllBooks");
		assertCheck(request);
	}
	
	@Test
	public void testCheckoutBook(){
		HttpUriRequest request = new HttpGet(BASE_URL+"/checkoutBook?bookId=e4b2540d-de71-4631-99b7-88fa56cbdd20&userId=3f4275b4-f3d1-4b02-a7aa-9758b0d14f0e");
		assertCheck(request);
	}
	
	@Test
	public void testFindBookByName(){
		HttpUriRequest request = new HttpPost(BASE_URL+"/addBook?bookName=MNO&author=IOP");
		assertCheck(request);
		request = new HttpGet(BASE_URL+"/findBookByName?bookName=MNO");
		assertCheck(request);
	}
	
	/**
	 * @param request
	 */
	private void assertCheck(HttpUriRequest request) {
		try {
			HttpResponse response = new DefaultHttpClient().execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			assertEquals( statusCode, 200 );
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
