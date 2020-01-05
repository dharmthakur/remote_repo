package com.safexpress.MDM.RestAssured;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class readExcelDemo {
public static void main(String[] args) {
	//Iterator<Map<String,String>> DataIt=null;
	Fillo fillo=new Fillo();
	/*try {
		Connection con=fillo.getConnection("drivesheet/UserManagement_Module/APITestCaseTable.xls");
		Recordset rs=con.executeQuery("select * from Sheet1");
		List<String> fieldList=rs.getFieldNames();
		
		List<Map<String,String>> listmap=new ArrayList<Map<String,String>>();
		int fieldcount=fieldList.size();
		while(rs.next()) 
		{
			Map<String,String> map=new HashMap<String,String>();
		
			
			for(int i=1;i<fieldcount;i=i+1)
			{
				String colname=fieldList.get(i);
				String fieldvalue=rs.getField(i).value();
				//System.out.println(colname);
				if((fieldvalue!=null)&&(fieldvalue.trim().equalsIgnoreCase("")==false))
				{
					//String fieldvalue=rs.getField(i+1).value();
				//	System.out.println(fieldvalue);
					map.put(colname,fieldvalue);
					
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
	
	while(DataIt.hasNext()) {
		Map<String,String> m=DataIt.next();
		m.forEach((key, value) -> System.out.println(key + ":" + value));
		
	}
	//System.out.println("exiting readData");*/
	Connection con=null;
	long theRandomNum = (long) (Math.random()*Math.pow(10,10));
	Long.toString(theRandomNum);
	String mbile=Long.toString(theRandomNum);
	System.out.println("mobile number: "+mbile);
	String query="Update Sheet1 Set mobile='"+mbile+"' where module='Usermanagement' and submodule='subusermanagement' and TC='TC01'";
	try { 
	
	 con=fillo.getConnection("testdata/TestDataForPUTMethod.xls");
	 
	
	
	int rows=con.executeUpdate(query);
	System.out.println("No. of rows modified: "+rows);
	} catch (FilloException e)
{
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	//long theRandomNum = (long) (Math.random()*Math.pow(10,10));
	//System.out.println(theRandomNum);
}

}

