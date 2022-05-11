package com.myapplication.testcases;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.io.IOException;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.myapplication.utils.*;

public class apiTests {
	apiOperations apiop = new apiOperations();	 

	@Test
	public void apiTest1() throws UnirestException {
		assertEquals(200,apiop.getOperationResponseCode("https://reqres.in/api/users?page=2")) ;
		//https://dsternlicht.github.io/RESTool/api/characters?
	}

	@Test
	public void apiTest2() throws UnirestException {
		String ss = apiop.getOperationResponseBody("https://reqres.in/api/users?page=2");
		//https://dsternlicht.github.io/RESTool/api/characters?
		boolean b =ss.contains("hello");
		assertTrue(b, "This not matched" );
	}


	//D:\Suyash\Automation\new_Workspace\automation-pom\src\test\resources\com\facebook\qa\TestData\Test1.json

	@Test
	public void apiTest3() throws UnirestException, IOException {
		//String ss = apiop.getOperationResponseBody("https://reqres.in/api/users?page=2");
		assertTrue(apiop.jsonCompare("GET","https://reqres.in/api/users?page=2","D:\\Suyash\\Automation\\new_Workspace\\automation-pom\\src\\test\\resources\\com\\facebook\\qa\\TestData\\Test1.json") );

		//	
		//	//https://dsternlicht.github.io/RESTool/api/characters?
		//	boolean b =ss.contains("hello");
		//	assertTrue(b, "This not matched" );
	}

}
