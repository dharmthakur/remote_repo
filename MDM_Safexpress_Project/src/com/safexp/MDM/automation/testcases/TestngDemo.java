package com.safexp.MDM.automation.testcases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.safexp.MDM.automation.Utility.UtilityClass;

import com.safexp.MDM.automation.managerClasses.ReadExcelData;
import com.safexp.MDM.automation.pagelibrary.Loginpage;

public class TestngDemo {
	
	@BeforeTest
	public void driverInitialisation()
	{
		UtilityClass.Init();
	}
	
	@BeforeMethod
	public void launchApp()
	{
		UtilityClass.launchApplication();
	}
	
	
	
	@Test
	public void hybridTestAutomation()
	{
		try {
	
		Fillo f=new Fillo();
		Connection con=f.getConnection("TestData/ModuleLogin.xls");
		Recordset rs=con.executeQuery("select * from DriverSheet where ExecutionMode='y'");
		while(rs.next()) 
		{
		String testid=rs.getField("TestCaseID");
		System.out.println(testid);
		Recordset rs1=con.executeQuery("select * from submodule1 where TestCaseID='"+testid+"'");
		ReadExcelData.readData("TestData/testdata.xls",testid);
		while(ReadExcelData.DataIt.hasNext())
		{
			UtilityClass.Initeration();
			
		    while(rs1.next())
	    	{
			String javaclassName=rs1.getField("pagesheet");
			String methodName=rs1.getField("pagekeyword");
			System.out.println(javaclassName);
			System.out.println(methodName);
			Recordset rs2=con.executeQuery("select * from "+javaclassName+" where pagekeyword='"+methodName+"'"); 
			int fieldcount=rs2.getFieldNames().size();
			int count=0;
			System.out.println(fieldcount);
			while(rs2.next())
			{
				List<String> parameterList=new ArrayList<String>();
				for(int i=1;i<fieldcount;i++)
				{   
					String fieldname=rs2.getField(i).value();
					System.out.println(fieldname);
					if(fieldname!=null&&fieldname.trim().equalsIgnoreCase("")==false)
					{
					parameterList.add(rs2.getField(i).value());
					count++;
					}
					else
					{
						break;
					}
					
				}
			
				System.out.println(count);

					//ReadExcelData.readData();
					
					
					
						switch(count)
						{
						case 0:Class cls=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj=cls.newInstance();
								Method m=cls.getMethod(methodName,null);
								m.invoke(obj,null);
								System.out.println("in case 0");
								break;
						 
						case 1:Class cls1=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj1=cls1.newInstance();
								Method m1=cls1.getMethod(methodName,String.class);
								String s=parameterList.get(0);
								System.out.println(s);
								String p=ReadExcelData.DataMap.get(s);
								
								m1.invoke(obj1,p);
								System.out.println("in case 1");
								break;
						case 2: Class cls2=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj2=cls2.newInstance();
								Method m2=cls2.getMethod(methodName,String.class,String.class);
								String p1=ReadExcelData.DataMap.get(parameterList.get(0));
								String p2=ReadExcelData.DataMap.get(parameterList.get(1));
								m2.invoke(obj2,p1,p2);
								System.out.println("in case 2");
								break;  
						    
						case 3: Class cls3=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
	                        	Object obj3=cls3.newInstance();
	                        	Method m3=cls3.getMethod(methodName,String.class,String.class,String.class);
	                        	String p4=ReadExcelData.DataMap.get(parameterList.get(0));
	                        	String p5=ReadExcelData.DataMap.get(parameterList.get(1));
	                        	String p6=ReadExcelData.DataMap.get(parameterList.get(2));
				            	m3.invoke(obj3,p4,p5,p6);
								System.out.println("in case 4");
								break;
				            
						default:System.out.println("invalid option");


					
					}//switch
				}//while
			System.out.println("hello");
			}//while
			
		}//while
		}//while
		
		}catch(Exception e) 
		{
			System.out.println("error in code"+e);
		}
		
	}
	/*@AfterMethod
	public void tearDown()
	{
		UtilityClass.closeApplication();
	}*/

}
