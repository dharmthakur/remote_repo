package com.safexp.MDM.automation.managerClasses;

import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcelData {
	
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

}