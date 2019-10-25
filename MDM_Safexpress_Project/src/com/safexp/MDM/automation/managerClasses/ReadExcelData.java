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
	
	
	public static void readData() 
	{
		Fillo fillo=new Fillo();
		try {
			Connection con=fillo.getConnection("TestData/testdata.xls");
			Recordset rs=con.executeQuery("select * from Sheet1");
			List<String> fieldList=rs.getFieldNames();
			Map<String,String> map=new HashMap<String,String>();
			List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
			int fieldcount=fieldList.size();
			while(rs.next()) 
			{
				
				for(int i=3;i<fieldcount;i=i+2)
				{
					String fieldname=rs.getField(i).value();
					if(fieldname!=null&&fieldname.trim().equalsIgnoreCase(" ")==false)
					{
						String fieldvalue=rs.getField(i+1).value();
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
	}
	
	/*
	public void readDataFromExcel(String excelpath)
	{
		Fillo fillo=new Fillo();
		try {
			Connection con=fillo.getConnection(excelpath);
			Recordset rs=con.executeQuery("select * from Sheet1");
			List<String> fieldList=rs.getFieldNames();
			int fieldcount=fieldList.size();
			while(rs.next()) {
			for(int i=0;i<fieldcount;i++)
			{
				System.out.print(rs.getField(i).value()+" ");
			}
			System.out.println();
			}
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
}