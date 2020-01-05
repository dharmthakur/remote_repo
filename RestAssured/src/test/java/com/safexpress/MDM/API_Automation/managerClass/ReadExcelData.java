package com.safexpress.MDM.API_Automation.managerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.safexpress.MDM.API_Automation.testcases.UsermanagementAPITest;

public class ReadExcelData
{
	public static Iterator<Map<String,String>> DataIt=null;
	Logger log=Logger.getLogger(ReadExcelData.class.getName());
	Fillo fillo=new Fillo();
	public void readExcelData()
	{
		
		
		try {
			Connection con=fillo.getConnection("testdata/APITestCaseTable.xls");
			
			Recordset rs=null;
			 try {
			 rs=con.executeQuery("select * from Sheet1");
			 }catch(Exception e) {log.info("no record found in drivesheet table");}

			List<String> fieldList=rs.getFieldNames();
			
			List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
			int fieldcount=fieldList.size();
			while(rs.next()) 
			{
				Map<String,String> map=new HashMap<String,String>();
			
				
				for(int i=1;i<fieldcount;i=i+1)
				{
					String fieldname=fieldList.get(i);
					String fieldvalue=rs.getField(i).value();
					if((fieldvalue!=null)&&(fieldvalue.trim().equalsIgnoreCase("")==false))
					{
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
		
	/*	
		while(DataIt.hasNext()) {
			Map<String,String> m=DataIt.next();
			m.forEach((key, value) -> System.out.println(key + ":" + value));
			
		}*/
		//System.out.println("exiting readData");

	}
	
	public void readExcelData_GET(String module,String submodule,String testcaseid)
	{
		try {
		Connection con=fillo.getConnection("testdata/TestDataForGETMethod.xls");
		Recordset rs=null;
		boolean flag=false;
		     try {
		          rs=con.executeQuery("select * from Sheet1 where Module='"+module+"' and Submodule='"+submodule+"' and TC='"+testcaseid+"'");
		          flag=true;
		         }catch(Exception e) {flag=false;log.info("No record found for "+testcaseid+" of Module "+module+" and submodule "+submodule+" in GET testdata table"); }
		if(flag==true) {
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

  }	
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
		Recordset rs=null;
		try {
		rs=con.executeQuery("select * from Sheet1 where Module='"+module+"' and Submodule='"+submodule+"' and TC='"+testcaseid+"'");
		}catch(Exception e){log.info("No record found for "+testcaseid+" of Module "+module+" and submodule "+submodule+" in POST testdata table"); }
		List<String> fieldList=rs.getFieldNames();
		
		List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
		int fieldcount=fieldList.size();
		//System.out.println(fieldcount);
		while(rs.next()) 
		{
			Map<String,String> map=new HashMap<String,String>();
			
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
	{
		try {
		Connection con=fillo.getConnection("testdata/TestDataForPUTMethod.xls");
		Recordset rs=null;
		try {
		    rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		    }catch(Exception e) {log.info("No record found for "+testcaseid+" of Module "+module+" and submodule "+submodule+" in PUT testdata table");} 
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
			//System.out.println(fieldname);
			
			if((fieldname!=null)&&(fieldname.trim().equalsIgnoreCase("")==false))
			{
				String fieldvalue=rs.getField(i+1).value();
				//System.out.println(fieldvalue);
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
	
	public void writeDataToExcel(String module,String submodule,String testcaseid,String httpmethod,String field,String value)
	{
		System.out.println(field);
		System.out.println(value);
		Connection con=null;
		
		try { 
		if(httpmethod.equalsIgnoreCase("GET"))
		{
		 con=fillo.getConnection("testdata/TestDataForGETMethod.xls");
		 Recordset rs=null;
		 try {
		 rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		 }catch(Exception e) {log.info("no record found in GET testdata table");}
		 rs.next();
		 List<String> colname=rs.getFieldNames();
		 int colcount=colname.size();
		 for(int i=3;i<colcount;i=i+2)
		 {
			 String fieldname=rs.getField(i).value();
			 if(fieldname.equalsIgnoreCase(field))
			 {
				 String fieldnm=colname.get(i+1);
				 con.executeUpdate("Update Sheet1 Set "+fieldnm+"='"+value+"' where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
				 
			 }
			 
		 }
		}
		else if(httpmethod.equalsIgnoreCase("PUT"))
		{
		 con=fillo.getConnection("testdata/TestDataForPUTMethod.xls");
		 Recordset rs=null;
		 try {
		 rs=con.executeQuery("select * from Sheet1 where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
		 }catch(Exception e) {log.info("no record found in PUT testdata table");}

		 rs.next();
		 List<String> colname=rs.getFieldNames();
		 int colcount=colname.size();
		 for(int i=3;i<colcount;i=i+2)
		 {
			 String fieldname=rs.getField(i).value();
			 if(fieldname.equalsIgnoreCase(field))
			 {
				 String fieldnm=colname.get(i+1);
				 con.executeUpdate("Update Sheet1 Set "+fieldnm+"='"+value+"' where module='"+module+"' and submodule='"+submodule+"' and TC='"+testcaseid+"'");
				 System.out.println("row modified");
			 }
			 
		 }
		}
		
		} catch (FilloException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
		public void readDataFor_GET(String module,String submodule,String testcaseid)
		{
			try {
			Connection con=fillo.getConnection("testdata/APITestData.xls");
			Recordset rs=null;
			boolean flag=false;
			     try {
			          rs=con.executeQuery("select * from GET where Module='"+module+"' and Submodule='"+submodule+"' and TC='"+testcaseid+"'");
			          flag=true;
			         }catch(Exception e) {flag=false;log.info("No record found for "+testcaseid+" of Module "+module+" and submodule "+submodule+" in GET testdata table"); }
			if(flag==true) {
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

	  }	
		} catch (FilloException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting readData");
	}

		public void readDataFor_POST(String module,String submodule,String testcaseid)
		{
			try {
			Connection con=fillo.getConnection("testdata/APITestData.xls");
			Recordset rs=null;
			boolean flag=false;
			     try {
			          rs=con.executeQuery("select * from POST where Module='"+module+"' and Submodule='"+submodule+"' and TC='"+testcaseid+"'");
			          flag=true;
			         }catch(Exception e) {flag=false;log.info("No record found for "+testcaseid+" of Module "+module+" and submodule "+submodule+" in POST testdata table"); }
			if(flag==true) {
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

	  }	
		} catch (FilloException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting readData");
	}

		public void readDataFor_PUT(String module,String submodule,String testcaseid)
		{
			try {
			Connection con=fillo.getConnection("testdata/APITestData.xls");
			Recordset rs=null;
			boolean flag=false;
			     try {
			          rs=con.executeQuery("select * from PUT where Module='"+module+"' and Submodule='"+submodule+"' and TC='"+testcaseid+"'");
			          flag=true;
			         }catch(Exception e) {flag=false;log.info("No record found for "+testcaseid+" of Module "+module+" and submodule "+submodule+" in PUT testdata table"); }
			if(flag==true) {
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

	  }	
		} catch (FilloException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting readData");
	}


	

	}
