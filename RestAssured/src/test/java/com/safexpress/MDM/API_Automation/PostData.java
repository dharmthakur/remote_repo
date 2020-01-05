package com.safexpress.MDM.API_Automation;

import java.util.HashMap;
import java.util.Map;

//import org.json.simple.JSONObject;
import org.testng.Assert;
//import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {
	

	//@Test
	public void testResponseCode() {
	RestAssured.baseURI="http://internal-a667ae5a906cd11ea86a00a1a1c1cf90-41609411.ap-south-1.elb.amazonaws.com";
	//Request object
	RequestSpecification httpRequest=RestAssured.given();
	
	/*JSONObject jobject=new JSONObject();
	jobject.put("FIRSTNAME","DK");
	jobject.put("LASTNAME", "THAKUR");
	jobject.put("USERNAME", "DHARM");
	jobject.put("PASSWORD", "DHARM123");
	jobject.put("EMAIL", "DHARM@GMAIL.COM");*/
	
	/*String s="{\"categoryId\": 145,\"defaultBranch\": {\"addOrRemoveOrUpdate\": \"add\",\"branchCode\": \"ABO03\",\"effectiveDate\": \"2019-12-09\",\"expiryDate\": \"2020-12-09\","+
"\"isDefault\": 1,\"status\": 1},\"description\": \"Test\",\"email\": \"test@test.com\",\"id\": 123,\"isAdmin\": 0,\"menuHierarchyId\": 1,\"mobile\": \"1234567890\","+
"\"name\": \"DARMENDRAThakUR\",\"previlegeBranches\": [{\"addOrRemoveOrUpdate\": \"add\",\"branchCode\": \"ABO02\",\"effectiveDate\": \"2019-12-09\",\"expiryDate\": \"2019-12-19\","+
"\"isDefault\": 0,\"status\": 1}],\"status\": 1,\"userId\": \"USERD33\",\"userRoles\": [{\"addOrRemoveOrUpdate\": \"add\",\"createdBy\": \"rahul\",\"description\": \"qwertyui\","+
"\"effectiveDate\": \"2019-12-09\",\"expiryDate\": \"2019-12-09\",\"roleId\": 1,\"roleName\": \"Role1\",\"status\": 1,\"updatedBy\": \"ertyui\"}]}";*/
	
	
	String s="{\n"+
			  "\"categoryId\": 0,\n"+
			  "\"defaultBranch\": {\n"+
			  "\"addOrRemoveOrUpdate\": \"string\",\n"+
			  "\"branchCode\": \"string\",\n"+
			  "\"effectiveDate\": \"yyyy-MM-dd\",\n"+
			  "\"expiryDate\": \"yyyy-MM-dd\",\n"+
			  "\"isDefault\": 0,\n"+
			  "\"status\": 0\n"+
			  "},\n"+
			  "\"description\": \"string\",\n"+
			  "\"email\": \"string\",\n"+
			  "\"id\": 0,\n"+
			  "\"isAdmin\": 0,\n"+
			  "\"menuHierarchyId\": 0,\n"+
			  "\"mobile\": \"string\",\n"+
			  "\"name\": \"string\",\n"+
			  "\"previlegeBranches\": [\n"+
			    "{\n"+
			      "\"addOrRemoveOrUpdate\": \"string\",\n"+
			      "\"branchCode\": \"string\",\n"+
			      "\"effectiveDate\": \"yyyy-MM-dd\",\n"+
			      "\"expiryDate\": \"yyyy-MM-dd\",\n"+
			      "\"isDefault\": 0,\n"+
			      "\"status\": 0\n"+
			    "}\n"+
			  "],\n"+
			  "\"status\": 0,\n"+
			  "\"userId\": \"string\",\n"+
			  "\"userRoles\": [\n"+
			    "{\n"+
			     "\"addOrRemoveOrUpdate\": \"string\",\n"+
			      "\"createdBy\": \"string\",\n"+
			      "\"description\": \"string\",\n"+
			      "\"effectiveDate\": \"yyyy-MM-dd\",\n"+
			      "\"expiryDate\": \"yyyy-MM-dd\",\n"+
			      "\"roleId\": 0,\n"+
			      "\"roleName\": \"string\",\n"+
			      "\"status\": 0,\n"+
			      "\"updatedBy\": \"string\"\n"+
			    "}\n"+
			  "]\n"+
			"}";
	
	Map<String,Object> headerMap = new HashMap<String,Object>();
	headerMap.put("authorization"," ");
	headerMap.put("branchCode"," ");
	headerMap.put("correlationId"," ");
	headerMap.put("journeyId","123");
	headerMap.put("userid","USER1");
	headerMap.put("origiUserType"," ");
	headerMap.put("Content-Type","application/json");
	httpRequest.headers(headerMap);
	httpRequest.body(s);
	
	Response response=httpRequest.request(Method.POST,"/v1/users");
	String responseBody=response.getBody().asString();
	System.out.println("Response Body is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("status code is:"+statusCode);
	Assert.assertEquals(statusCode, 201);
	
	//success code validatation
	String successCode=response.jsonPath().get("SuccessCode");
	Assert.assertEquals(successCode,"OPERATION_SUCCESS");

}}
