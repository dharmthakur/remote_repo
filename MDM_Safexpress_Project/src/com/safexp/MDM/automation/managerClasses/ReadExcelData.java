package com.safexp.MDM.automation.managerClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcelData {
	public static Map<String,String> DataMap=null;
	public static Iterator<Map<String,String>> DataIt=null;
	
	public static void readData(String path,String testid) 
	{System.out.println("entring readData");
		Fillo fillo=new Fillo();
		try {
			Connection con=fillo.getConnection(path);
			Recordset rs=con.executeQuery("select * from Sheet1 where TestCaseID='"+testid+"'");
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