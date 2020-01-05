package com.safexpress.MDM.API_Automation.pagelibrary;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;
import com.safexpress.MDM.API_Automation.managerClass.ReadExcelData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class PageForPostRequest {
	Logger log=Logger.getLogger(PageForPostRequest.class.getName());
	public static String userID=null;
	public static Integer uId=null;
	public static boolean bool=false;
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
	
	public  String getJSONString(Map jsonparamvalue)
	{
		userID=jsonparamvalue.get("userId").toString();
		log.info(".......creating json string.......");	
				String jsonbody="{\n"+
				  "\"categoryId\":"+jsonparamvalue.get("categoryId")+",\n"+
				  "\"defaultBranch\": {\n"+
				  "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("defaultBranch_addOrRemoveOrUpdate")+"\",\n"+
				  "\"branchCode\": \""+jsonparamvalue.get("defaultBranch_branchCode")+"\",\n"+
				  "\"effectiveDate\": \""+jsonparamvalue.get("defaultBranch_effectiveDate")+"\",\n"+
				  "\"expiryDate\": \""+jsonparamvalue.get("defaultBranch_expiryDate")+"\",\n"+
				  "\"isDefault\":"+jsonparamvalue.get("defaultBranch_isDefault")+",\n"+
				  "\"status\":"+jsonparamvalue.get("defaultBranch_status")+ "\n"+
				  "},\n"+
				  "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
				  "\"email\": \""+jsonparamvalue.get("email")+"\",\n"+
				  "\"id\":"+jsonparamvalue.get("id")+",\n"+
				  "\"isAdmin\":"+jsonparamvalue.get("isAdmin")+",\n"+
				  "\"menuHierarchyId\":"+jsonparamvalue.get("menuHierarchyId")+",\n"+
				  "\"mobile\": \""+jsonparamvalue.get("mobile")+"\",\n"+
				  "\"name\": \""+jsonparamvalue.get("name")+"\",\n"+
				  "\"previlegeBranches\": [\n"+
				    "{\n"+
				      "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("previlegeBranches_addOrRemoveOrUpdate")+"\",\n"+
				      "\"branchCode\": \""+jsonparamvalue.get("previlegeBranches_branchCode")+"\",\n"+
				      "\"effectiveDate\": \""+jsonparamvalue.get("previlegeBranches_effectiveDate")+"\",\n"+
				      "\"expiryDate\": \""+jsonparamvalue.get("previlegeBranches_expiryDate")+"\",\n"+
				      "\"isDefault\":"+jsonparamvalue.get("previlegeBranches_isDefault")+",\n"+
				      "\"status\":"+jsonparamvalue.get("previlegeBranches_status")+"\n"+
				    "}\n"+
				  "],\n"+
				  "\"status\":"+jsonparamvalue.get("status")+",\n"+
				  "\"userId\": \""+jsonparamvalue.get("userId")+"\",\n"+
				  "\"userRoles\": [\n"+
				    "{\n"+
				     "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("userRoles_addOrRemoveOrUpdate")+"\",\n"+
				      "\"createdBy\": \""+jsonparamvalue.get("userRoles_createdBy")+"\",\n"+
				      "\"description\": \""+jsonparamvalue.get("userRoles_description")+"\",\n"+
				      "\"effectiveDate\": \""+jsonparamvalue.get("userRoles_effectiveDate")+"\",\n"+
				      "\"expiryDate\":\""+jsonparamvalue.get("userRoles_expiryDate")+"\",\n"+
				      "\"roleId\":"+jsonparamvalue.get("userRoles_roleId")+",\n"+
				      "\"roleName\": \""+jsonparamvalue.get("userRoles_roleName")+"\",\n"+
				      "\"status\":"+jsonparamvalue.get("userRoles_status")+",\n"+
				      "\"updatedBy\":\""+jsonparamvalue.get("userRoles_updatedBy")+"\"\n"+
				    "}\n"+
				  "]\n"+
				"}";
				log.info(".......json string created.......");
		return jsonbody;
	}
	
	public Response postRequest(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......POST Request is fired for new user :"+PageForPostRequest.userID+".......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.post();
			//.headers("Content-Type","application/json")
			
		   }catch(Exception e) {
			   log.info(".......sorry,requested url is down so unbale to fulfil request");
			 //  e.printStackTrace();
			   }
		return response;	
		
	}
	
	public Map<String,Object> getResponse(Response response)
	{
		log.info("......retrieving details of POST Response...........");
		Map<String,Object> details=new HashMap<String,Object>();
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
		log.info("........end of details of POST Response........");
		return details;

	}
	
	public void verifyPostSuccess(Response response)
	{ 
		log.info(".........verifying POST success.....");
		bool=false;
		try {
			int statusCode=0;
			try {
			     statusCode=response.getStatusCode();
			}catch(Exception e) {log.info("status code not retrieved");}
			
			if(statusCode==201)
			{
		   	   bool=true;
		       APIFrameworkDriver.flag=true;
		   	   log.info("...POST Request successed" );
		   	  // UtilityClassForAPI.logger.pass("POST Request passed");
		   	  // System.out.println("Post request success");
		   	//return bool;
			}
			else 
			{
				//userID=null;
				APIFrameworkDriver.flag=false;
				throw new Exception();
			}
		    }catch(Exception e) 
			{
		    	log.info("...POST Request not successed" );
				//UtilityClassForAPI.logger.fail("POST Request failed");
		    	//System.out.println("user exist");
		    	//Assert.fail();
		    	//e.printStackTrace();
				//return bool;
		    }
		    	
		
	}
}
