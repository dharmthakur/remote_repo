package com.safexpress.MDM.API_Automation.APIUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class XLUtility {
	public static Iterator<Map<String,String>> DataIt=null;
	public static Fillo fillo=null;
	
	public static void readExcelData_GET(String module,String submodule,String testcaseid)
	{
		
		try {
		fillo=new Fillo();
		Connection con=fillo.getConnection("testdata/TestDataForGETMethod.xls");
		Recordset rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		List<String> fieldList=rs.getFieldNames();
		
		List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
		int fieldcount=fieldList.size();
		while(rs.next()) 
		{Map<String,String> map=new HashMap<String,String>();
			
			for(int i=3;i<fieldcount;i=i+2)
			{
				String fieldname=rs.getField(i).value();
				System.out.println(fieldname);
				if((fieldname!=null)&&(fieldname.trim().equalsIgnoreCase("")==false))
				{
					String fieldvalue=rs.getField(i+1).value();
					System.out.println(fieldvalue);
					map.put(fieldname,fieldvalue);
					
				}
				
			}
			listmap.add(map);
			
		}
		DataIt=listmap.iterator();

		
	} catch (FilloException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("exiting readData");
}


	
	public void readExcelData_POST(String module,String submodule,String testcaseid)
	{try {
		Connection con=fillo.getConnection("testdata/TestDataForPOSTMethod.xls");
		Recordset rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		List<String> fieldList=rs.getFieldNames();
		
		List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
		int fieldcount=fieldList.size();
		while(rs.next()) 
		{Map<String,String> map=new HashMap<String,String>();
			
			for(int i=3;i<fieldcount;i=i+2)
			{
				String fieldname=rs.getField(i).value();
				System.out.println(fieldname);
				if((fieldname!=null)&&(fieldname.trim().equalsIgnoreCase("")==false))
				{
					String fieldvalue=rs.getField(i+1).value();
					System.out.println(fieldvalue);
					map.put(fieldname,fieldvalue);
					
				}
				
			}
			listmap.add(map);
			
		}
		DataIt=listmap.iterator();

		
	} catch (FilloException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("exiting readData");
}


	public void readExcelData_PUT(String module,String submodule,String testcaseid)
	{try {
		Connection con=fillo.getConnection("testdata/TestDataForPUTMethod.xls");
		Recordset rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		List<String> fieldList=rs.getFieldNames();

		
		
		List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
		int fieldcount=fieldList.size();
		while(rs.next()) 
		{Map<String,String> map=new HashMap<String,String>();
			
			for(int i=3;i<fieldcount;i=i+2)
			{
				String fieldname=rs.getField(i).value();
				System.out.println(fieldname);
				if((fieldname!=null)&&(fieldname.trim().equalsIgnoreCase("")==false))
				{
					String fieldvalue=rs.getField(i+1).value();
					System.out.println(fieldvalue);
					map.put(fieldname,fieldvalue);
					
				}
				
			}
			listmap.add(map);
			
		}
		DataIt=listmap.iterator();

		
	} catch (FilloException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("exiting readData");
}


	public void readExcelData_DELETE(String module,String submodule,String testcaseid)
	{try {
		Connection con=fillo.getConnection("testdata/TestDataForDELETEMethod.xls");
		Recordset rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		List<String> fieldList=rs.getFieldNames();

		
		
		List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
		int fieldcount=fieldList.size();
		while(rs.next()) 
		{Map<String,String> map=new HashMap<String,String>();
			
			for(int i=3;i<fieldcount;i=i+2)
			{
				String fieldname=rs.getField(i).value();
				System.out.println(fieldname);
				if((fieldname!=null)&&(fieldname.trim().equalsIgnoreCase("")==false))
				{
					String fieldvalue=rs.getField(i+1).value();
					System.out.println(fieldvalue);
					map.put(fieldname,fieldvalue);
					
				}
				
			}
			listmap.add(map);
			
		}
		DataIt=listmap.iterator();

		
	} catch (FilloException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("exiting readData");
}

}


