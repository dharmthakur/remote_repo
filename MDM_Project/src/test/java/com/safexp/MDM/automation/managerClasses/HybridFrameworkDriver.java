package com.safexp.MDM.automation.managerClasses;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.safexp.MDM.automation.Utility.UtilityClass;

public class HybridFrameworkDriver {
	public static void hybridTestAutomation(String testid,String testname,String submodule,String testdatapath,String scriptpath)
	{
		
		try {
			
	/* create connection with data source*/
		Fillo f=new Fillo();
		Connection con=f.getConnection(scriptpath);
				
	/* select all the steps for current testcaseid*/	
		Recordset rs1=con.executeQuery("select * from "+submodule+" where TestCaseID='"+testid+"'");
	/* gettestdata for current testcaseid*/
		ReadExcelData.readData(testdatapath,testid);
	/* execute the current testcase for each set of data*/	
		rs1.next();
		while(ReadExcelData.DataIt.hasNext())
		{
			System.out.println("calling initeration");
			UtilityClass.Initeration();
			System.out.println("after initeration");
			
			
			do
	    	{
		    
			String javaclassName=rs1.getField("pagesheet");
			String methodName=rs1.getField("pagekeyword");
			System.out.println(javaclassName);
			System.out.println(methodName);
			Recordset rs2=con.executeQuery("select * from "+javaclassName+" where pagekeyword='"+methodName+"'"); 
			int fieldcount=rs2.getFieldNames().size();
			int count=0;
			System.out.println(fieldcount);
			rs2.next();
			
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
					
						switch(count)
						{
						case 0: Class cls=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj=cls.newInstance();
							    Method m=cls.getMethod(methodName,null);
							    m.invoke(obj,null);  
								System.out.println("in case 0");
								break;				
						case 1: System.out.println("entered in case 1");
							    Class cls1=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj1=cls1.newInstance();
								Method m1=cls1.getMethod(methodName,String.class);
								String s=parameterList.get(0);
								System.out.println(s);
								String p=ReadExcelData.DataMap.get(s);
								System.out.println(p);
								m1.invoke(obj1,p);						          
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
				}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);
		}//while
//Testcase finished		
		
		}catch(Exception e) 
		{
			UtilityClass.logger.fail("testfailed");
			UtilityClass.extent.flush();
			//UtilityClass.driver.close();
	        Verify.verify(false);
	        
		}
		
	}
	

}
