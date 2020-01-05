package com.safexpress.MDM.API_Automation.pagelibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;
import com.safexpress.MDM.API_Automation.managerClass.ReadExcelData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PageForGetRequest {
	
	Logger log=Logger.getLogger(PageForGetRequest.class.getName());

	public Map<String,Object> getDetailsOf(Response rs)
	{
		log.info("......retrieving details of GET Response...........");
		Map<String,Object> details=new HashMap<String,Object>();
		Response response=rs;
		String responseBody=response.getBody().asString();
		details.put("ResponseBody",responseBody);
		log.info("Response Body is: "+responseBody);
		//System.out.println("Response Body is: "+responseBody);
		int statusCode=response.getStatusCode();
		details.put("StatusCode",statusCode);
		log.info("Status code is: "+statusCode);
		//System.out.println("status code is:"+statusCode);
		String StatusLine=response.getStatusLine();
		details.put("StatusLine",StatusLine);
		log.info("Status Line is: "+StatusLine);
		String contenttype=response.getContentType();
		details.put("Content-Type",contenttype);
		log.info("........end of details of GET Response........");
		return details;
	}
	
	public void verifyGetSuccess(Response response)
	{
		//log.info("Verifying the status code");
		log.info(".........verifying GET success.....");
				
		try {
			int statusCode=0;
			try {
			     statusCode=response.getStatusCode();
			}catch(Exception e) {log.info("status code not retrieved");}
			if(statusCode==200)
			{
				APIFrameworkDriver.flag=true;
		   	   log.info("...GET Request successed" );
		   	  // UtilityClassForAPI.logger.pass("GET Request passed");
		   	  // System.out.println("Post request success");
		   	   
			}
			else 
			{
				
				throw new Exception();
			}
		}catch(Exception e) 
		{
			APIFrameworkDriver.flag=false;
			log.info("...GET Request not successed" );
			UtilityClassForAPI.logger.fail("GET Request failed");
	    	//System.out.println("user exist");
	    	//Assert.fail();
	    	//e.printStackTrace();
	    }
		
		    	
	}
	
	public String getUIdOfExistingUserId(Response response,String userID) 
	{ 
		log.info("retrieving Id of user "+userID);
		response.prettyPrint();
		JsonPath jp=response.jsonPath();
		
		ArrayList<String> s=jp.get("userId");
		ArrayList<Integer> s1=jp.get("id");
		int count=s.size();
		
		for(int i=0;i<count;i++)
		{
			if((s.get(i)).equalsIgnoreCase(userID))
			{
				log.info("user found and now retrieving its Id");
				PageForPostRequest.userID=s.get(i);
		    	PageForPostRequest.uId=s1.get(i);
		    	log.info("user Id is: "+PageForPostRequest.uId+" for user:"+PageForPostRequest.userID);
		    	break;
				
			}
		}
		
		log.info("Id retrieval done");      
		//System.out.println(userID+" "+PageForPostRequest.uId);
		return (Integer.toString(PageForPostRequest.uId));
	}
	
	

	public Object[][] getRandomUserIdAlongWithId(Response response)
	{
		log.info("......Retrieving user and its Id on random basis.........");
		Object[][] obj=null;
		try {
		JsonPath jp=response.jsonPath();
		ArrayList<String> s=jp.get("userId");
		ArrayList<Integer> s1=jp.get("id");
		obj=new Object[1][2];
		for(int i=0;i<s.size();i++) {
		if(s.get(i).equalsIgnoreCase("USER1")||s.get(i).equalsIgnoreCase("USER2")||s.get(i).equalsIgnoreCase("USER3")||s.get(i).equalsIgnoreCase("USER4")||s.get(i).equalsIgnoreCase("USER5"))
		{ 
		 continue;
		
		}
		else
		{
			
			obj[0][0]=s.get(i);
			obj[0][1]=s1.get(i);
			log.info("...retrieved user is:"+obj[0][0]+" and itd Id is:"+obj[0][1]);
			break;
		}
		}
		
		log.info("......user retrieval on random basis is done.......");
		}catch(Exception e) {log.info("failed to retrieve data");}
		
		return obj;
			
	}
	
	public Map<String,Object> getHeader()
	{
		log.info("....initialising headers......");
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("authorization"," ");
		headerMap.put("branchCode"," ");
		headerMap.put("correlationId"," ");
		headerMap.put("journeyId","123");
		headerMap.put("userId","USER1");
		headerMap.put("origiUserType"," ");
		headerMap.put("Content-Type","application/json");
		log.info(".......headers initialisation done.......");
		return headerMap;
	}
	
	public Response getResponseOfaUser(String baseuri,String basepath,Map header,String userId)
	{   
		log.info(".......GET Request is fired for "+userId+"........");
		//String userid=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+userId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	public Response getResponse_All(String baseuri,String basepath,Map header)
	{   
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
		
	}
	
	public void validateUserExist(String user)
	{
		log.info(".......validating user existence.........");
		Boolean response=UtilityClassForAPI.isExist(user);
		if(response) {
			//System.out.println("user exist");
			log.info("...user is valid");
		}else {
			//System.out.println("....");
			log.info(".....user is not valid");
		}
		

	}
	
}
