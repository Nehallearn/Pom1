package com.app.utils;

import com.app.base.BaseClass;

public class TestUtils extends BaseClass{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static long TEST = 10;
	
	
	public void frame() {
		driver.switchTo().frame("mainpanel");
	}

}
