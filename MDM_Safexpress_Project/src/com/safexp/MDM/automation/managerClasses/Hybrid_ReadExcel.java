package com.safexp.MDM.automation.managerClasses;

import java.io.FileInputStream;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Hybrid_ReadExcel {

	public void readExcelForHybrid(String excelfilepath)
	{
		try {
		Fillo filo=new Fillo();
		Connection con=filo.getConnection(excelfilepath);
		Recordset rs=con.executeQuery("select * from DriverSheet where ModuleName='Login'and SubmoduleName='submodule1'and ExecutionMode='y'");
		int recordcount=rs.getCount();
		for(int i=0;i<recordcount;i++)
		{
			Recordset rs1=con.executeQuery("select * from submodule1");
			List<String> fieldList=rs1.getFieldNames();
			//String pa 
			int n=fieldList.size();
			while(rs1.next())
			{
			
			for(int j=0;j<n;j++)
			{
				System.out.print(fieldList.get(j));
				System.out.print(rs1.getField(j).value());
				System.out.println();
				
			}
			
			Recordset rs2=con.executeQuery("select * from Loginpage");
			
			List<String> fList=rs2.getFieldNames();
			//String pa 
			int count =fList.size();
			while(rs2.next())
			{
			
			for(int k=0;k<count;k++)
			{
				System.out.print(fList.get(k));
				System.out.print(rs2.getField(k).value());
				System.out.println();
			}
			}
			}
		}
		/*while(rs.next())
		{
			List<String> fieldname=rs.getFieldNames();
			
			
		}*/
		
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
