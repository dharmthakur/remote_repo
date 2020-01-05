package com.safexpress.MDM.API_Automation.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.ReadExcelData;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForGetRequest;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForPostRequest;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForPutRequest;

import io.restassured.response.Response;

public class UsermanagementAPITest {
	Logger log=Logger.getLogger(UsermanagementAPITest.class.getName());
@BeforeTest
public void Init() 
{log.info("initialising log4j");
	 UtilityClassForAPI.initLogReport();//.Initialise_RequestObject("https://restcountries.eu/rest/v2");
	 UtilityClassForAPI.intitExtentReport();
}
@Test(dataProvider="executableTestID_provider")
public void TestCase(String tc,String title,String requesturl,String httpMethod,String basePath,String Module,String SubModule)
{
	//System.out.println(tc+" "+title+" "+requesturl+" "+httpMethod+" "+basePath+" "+Module+" "+SubModule);
log.info("....starting testcase:"+tc+":"+title+" for Module:"+Module+" and submodule "+SubModule+" for HttpMethod"+httpMethod+".......");
	
	if(httpMethod.equalsIgnoreCase("GET")) 
	{  
		log.info("....processing GET Request....");
		//System.out.println("inside GET");
		PageForGetRequest pgetobj=new PageForGetRequest();
		Map<String,Object> header=pgetobj.getHeader();
		
		ReadExcelData readexcel=new ReadExcelData();
		readexcel.readExcelData_GET(Module, SubModule,tc);
		Response response=null;
		while(ReadExcelData.DataIt.hasNext()) {
		    Map<String,String> datamap=ReadExcelData.DataIt.next();
		    String usrid=datamap.get("userId").toString();
			response=pgetobj.getResponseOfaUser(requesturl, basePath, header,usrid);
			//pgetobj.getDetailsOf(response);
			pgetobj.verifyGetSuccess(response);}
			
		log.info("....GET Request Processed....");		
	}
	else if(httpMethod.equalsIgnoreCase("POST"))
	{
		log.info("....processing POST Request....");
		//System.out.println("inside POST");
		PageForPostRequest postobj=new PageForPostRequest();
		Map<String,Object> header=postobj.getHeader();
		ReadExcelData readexcel=new ReadExcelData();
		readexcel.readExcelData_POST(Module,SubModule,tc);
		Response response=null;
		while(ReadExcelData.DataIt.hasNext()) {
			Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
			String json=postobj.getJSONString(jsonparamvalue);
			log.info("JSON is:"+json);
			//System.out.println("JSON is:"+json);
			response=postobj.postRequest(requesturl, basePath, header, json);
		    //Map<String,Object> responsemap=postobj.getResponse(response);
		    postobj.verifyPostSuccess(response);
            PageForGetRequest getobj=new PageForGetRequest();
           if(PageForPostRequest.bool==true)
           {   response=getobj.getResponse_All(requesturl, basePath, header);
        	   String id=getobj.getUIdOfExistingUserId(response, PageForPostRequest.userID);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"GET","userId",PageForPostRequest.userID);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"GET","id",id);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"PUT","userId",PageForPostRequest.userID);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"PUT","id",id);

           }
           else
           {   response=getobj.getResponse_All(requesturl, basePath, header);
        	   Object[][] obj=getobj.getRandomUserIdAlongWithId(response);
        	   String userId=(String)obj[0][0];
        	   PageForPostRequest.userID=userId;
        	   int id1=(Integer) obj[0][1];
        	   String id=Integer.toString(id1);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"GET","userId",userId);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"GET","id",id);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"PUT","userId",userId);
        	   new ReadExcelData().writeDataToExcel(Module, SubModule, tc,"PUT","id",id);

       	   
           }
           
		}
     log.info(".............POST Request Processed..................");
	}
	else if(httpMethod.equalsIgnoreCase("PUT"))
	{
		log.info(".............Processing PUT Request..................");
		//System.out.println("inside put");
		PageForPutRequest putobj=new PageForPutRequest();
		Map<String,Object> header=putobj.getHeader();
		ReadExcelData readexcel=new ReadExcelData();
		readexcel.readExcelData_PUT(Module,SubModule,tc);
		Response response=null;
		while(ReadExcelData.DataIt.hasNext()) {
		Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
		String json=putobj.getJSONString(jsonparamvalue);
		log.info("JSON is:"+json);
		//System.out.println("JSON is:"+json);
		response=putobj.putRequest(requesturl, basePath, header, json);
		Map<String,Object> responsemap=putobj.getResponse(response);
		putobj.verifyPutSuccess(response);
		}
		
		log.info(".............PUT Request Processed..................");
	}
		
	
	else if(httpMethod.equalsIgnoreCase("DELETE"))
	{
		
	}
		
}


@DataProvider
public Object[][] executableTestID_provider()
{
int n;
Object[][] obj=null;
Connection conn;
Recordset record;
log.info("inside dataprovider");
Fillo f=new Fillo();
try {
conn=f.getConnection("drivesheet/UserManagement_Module/APITestCaseTable.xls");

record=conn.executeQuery("select TC,Title,RequestURL,HTTPMethod,basePath,Module,SubModule from Sheet1 where ExecutionMode='y'");

n=record.getCount();
System.out.println(n);
obj=new Object[n][7];
for(int i=0;i<n;i++)
{
	record.next();
	obj[i][0]=record.getField("TC");
	obj[i][1]=record.getField("Title");
	obj[i][2]=record.getField("RequestURL");
	obj[i][3]=record.getField("HTTPMethod");
	obj[i][4]=record.getField("basePath");
	obj[i][5]=record.getField("Module");
	obj[i][6]=record.getField("SubModule");
	
			
}
}catch(Exception e) {}
log.info("exiting dataprovider");
return obj;
		
}

}
