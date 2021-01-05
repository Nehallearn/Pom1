package com.app.utils;

import java.util.ArrayList;

public class GetDataUtility {
	static ExcelReader reader;
	
	public static ArrayList<Object[]> getData(){
	ArrayList<Object[]> data = new ArrayList<Object[]>();
	reader = new ExcelReader("C:\\Users\\nehal\\eclipse-workspace\\TestAutomation1\\src\\main\\java\\com\\app\\testdata\\Testdata.xlsx");
	
	for(int rowcount =2;rowcount<=reader.getRowCount("Contact");rowcount++)
	{
		String title = reader.getCellData("Contact", "Title", rowcount);
		String firstname = reader.getCellData("Contact", "Firstname", rowcount);
		String lastname = reader.getCellData("Contact", "Lastname", rowcount);
		String cname = reader.getCellData("Contact", "Company", rowcount);
		Object ob[] = {title,firstname,lastname,cname};
		data.add(ob);
	}
	return data;
	
	}

}
