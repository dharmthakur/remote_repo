package com.safexpress.MDM.API_Automation.managerClass;

import java.util.Map;

import org.apache.log4j.Logger;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Verify;
import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForGetRequest;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForPostRequest;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForPutRequest;
import com.safexpress.MDM.API_Automation.testcases.UsermanagementAPITest;

import io.restassured.response.Response;

public class APIFrameworkDriver {
	
static Logger log1=Logger.getLogger(APIFrameworkDriver.class.getName());
public static boolean flag;
	public static void automateAPITestcase(String testid,String testname,String module,String submodule,String testdatapath,String scriptpath)
		{
			flag=true;
			try {
				
		// create connection with data source
			Fillo f=new Fillo();
			Connection con=f.getConnection(scriptpath);		
		// select all the steps for current testcaseid	
			Recordset rs1=con.executeQuery("select * from "+module+" where TC='"+testid+"' and SubModule='"+submodule+"'");
		// execute the current testcase for each set of data
			rs1.next();
								
				do
		    	{
			    
				String requesturl=rs1.getField("RequestURL");
				String basepath=rs1.getField("basePath");
				String httpMethod=rs1.getField("HTTPMethod");
				String testId=rs1.getField("TC");
				String testcasename=rs1.getField("TestcaseName");
				
				if(httpMethod.equalsIgnoreCase("GET")) 
			    {  
				log1.info("....processing GET Request....");
				//System.out.println("inside GET");
				PageForGetRequest pgetobj=new PageForGetRequest();
				Map<String,Object> header=pgetobj.getHeader();
				
				ReadExcelData readexcel=new ReadExcelData();
				readexcel.readExcelData_GET(module,submodule,testId);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
			    Map<String,String> datamap=ReadExcelData.DataIt.next();
			    String usrid=datamap.get("userId").toString();
				response=pgetobj.getResponseOfaUser(requesturl, basepath, header,usrid);
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);}
				log1.info("....GET Request Processed....");		
			    }
				else if(httpMethod.equalsIgnoreCase("POST"))
				{
					log1.info("....processing POST Request....");
					//System.out.println("inside POST");
					PageForPostRequest postobj=new PageForPostRequest();
					Map<String,Object> header=postobj.getHeader();
					ReadExcelData readexcel=new ReadExcelData();
					readexcel.readExcelData_POST(module,submodule,testId);
					Response response=null;
					while(ReadExcelData.DataIt.hasNext()) {
						Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
						String json=postobj.getJSONString(jsonparamvalue);
						log1.info("JSON is:"+json);
						System.out.println("JSON is:"+json);
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
			    					}
			     log1.info(".............POST Request Processed..................");
				}
				else if(httpMethod.equalsIgnoreCase("PUT"))
				{
					log1.info(".............Processing PUT Request..................");
					//System.out.println("inside put");
					PageForPutRequest putobj=new PageForPutRequest();
					Map<String,Object> header=putobj.getHeader();
					ReadExcelData readexcel=new ReadExcelData();
					readexcel.readExcelData_PUT(module,submodule,testId);
					Response response=null;
					while(ReadExcelData.DataIt.hasNext()) {
					Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
					String json=putobj.getJSONString(jsonparamvalue);
					log1.info("JSON is:"+json);
					//System.out.println("JSON is:"+json);
					response=putobj.putRequest(requesturl, basepath, header, json);
					//Map<String,Object> responsemap=putobj.getResponse(response);
					putobj.verifyPutSuccess(response);
					}
					
					log1.info(".............PUT Request Processed..................");
				}				
					
			}while(rs1.next());//while
				rs1.moveFirst();
				Thread.sleep(3000);	
				if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
				}
	//Testcase finished		
			
			}catch(Exception e) 
			{
				UtilityClassForAPI.logger.fail(testname+" failed");
				UtilityClassForAPI.extent.flush();
		        Verify.verify(false);
				
			}
			
		}
		

	}
