package com.safexpress.MDM.API_Automation.pagelibrary;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PageForPutRequest {
	
	Logger log=Logger.getLogger(PageForPutRequest.class.getName());
	static String userID=null;
	
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
		return headerMap;	}
	
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
	
	public Response putRequest(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......PUT Request is fired for user :"+userID+".......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.put();
			log.info(".....user updated successfully");
		   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
		   		//e.printStackTrace();
		   }return response;
		
		
	}
	
	public Map<String,Object> getResponse(Response response)
	{
		log.info("......retrieving details of PUT Response...........");
		HashMap<String,Object> resp=new HashMap<String,Object>();
		String responseBody=response.getBody().asString();
		resp.put("ResponseBody",responseBody);
		log.info("Response Body is: "+responseBody);
		//System.out.println("Response Body is: "+responseBody);
		int statusCode=response.getStatusCode();
		resp.put("StatusCode",statusCode);
		log.info("Status code is: "+statusCode);
		//System.out.println("status code is:"+statusCode);
		//String successCode=response.jsonPath().get("SuccessCode");
		//resp.put("SuccessCode",successCode);
		log.info(".........End of PUT Response Details.............");
		return resp;
	}
	
	public void verifyPutSuccess(Response response)
	{
		log.info("...........verifying PUT Request.............");
		try {
			
			//System.out.println(statusCode);
			//System.out.println(successcode);
			int statusCode=0;
			try {
			     statusCode=response.getStatusCode();
			}catch(Exception e) {log.info("status code not retrieved");}
			if(statusCode==200)
			{
			   APIFrameworkDriver.flag=true;
		   	   log.info("...PUT Request successed" );
		   	   //.UtilityClassForAPI.logger.pass("PUT Request passed");
		   	  // System.out.println("Post request success");
		   	   
			}
			else 
			{
				
				throw new Exception();
			}
		    }catch(Exception e) 
			{
		    	APIFrameworkDriver.flag=false;
		    	log.info("...PUT Request not successed" );
				UtilityClassForAPI.logger.fail("PUT Request failed");
		    	//System.out.println("user exist");
		    	//Assert.fail();
		    	//e.printStackTrace();
		    }
		    
	}

	
	

}
