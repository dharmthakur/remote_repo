package com.safexpress.MDM.API_Automation;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutData {
	
	public static void main(String[] args) {
	
	//RestAssured.baseURI="http://internal-a667ae5a906cd11ea86a00a1a1c1cf90-41609411.ap-south-1.elb.amazonaws.com";
	//Request object
	//RequestSpecification httpRequest=RestAssured.given();
										
	
	//JSONObject jobject=new JSONObject();
	/*jobject.put("id",2151);
	jobject.put("name", "100RABH");
	jobject.put("userId","USER151");
	jobject.put("email","dharm@GMAIL.COM");
	jobject.put("mobile","8448828089");
	jobject.put("categoryId",145);
	
	jobject.put("status",1);
	jobject.put("isAdmin",0);
	jobject.put("menuHierarchyId",2);*/
	String json= "{\n"+
			  "\"id\": 2763,\n"+
			  "\"userId\": \"USER\",\n"+
			  "\"name\": \"USERDEMO\",\n"+
			  "\"email\": \"USER@GMIAL.COM\",\n"+
			  "\"mobile\": \"9993765444\",\n"+
			  "\"categoryId\": 145,\n"+
			  "\"status\": 1,\n"+
			  "\"isAdmin\": 0,\n"+
			  "\"menuHierarchyId\": 3,\n"+
			  "\"defaultBranch\": {\n"+
			  "\"branchCode\": \"ABO03\",\n"+
			  "\"isDefault\": 1,\n"+
			  "\"status\": 0\n"+
			  "}\n"+
			"}";
	
	Map<String,Object> headerMap = new HashMap<String,Object>();
	headerMap.put("authorization"," ");
	headerMap.put("branchCode"," ");
	headerMap.put("correlationId"," ");
	headerMap.put("journeyId","123");
	headerMap.put("userId","USER");
	headerMap.put("origiUserType"," ");
	headerMap.put("content-Type","application/json");
	Response response=null;
	try {
		response=RestAssured.given()
				.baseUri("http://internal-a667ae5a906cd11ea86a00a1a1c1cf90-41609411.ap-south-1.elb.amazonaws.com")
				.basePath("/v1/users")
				.headers(headerMap)
				.body(json)
				.put();
	   }catch(Exception e) {e.printStackTrace();}
	
	
	/*httpRequest.headers(headerMap);
	httpRequest.body(json);
	Response response = httpRequest.put("/v1/users/USER");*/
	
	String responseBody=response.getBody().asString();
	System.out.println("Response Body is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("status code is:"+statusCode);
	//Assert.assertEquals(statusCode, 200);
	
	
}
}
