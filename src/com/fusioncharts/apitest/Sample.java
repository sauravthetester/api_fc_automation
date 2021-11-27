package com.fusioncharts.apitest;

import org.testng.annotations.Test;

public class Sample {
	
	@Test(threadPoolSize = 1, invocationCount = 1000,  timeOut = 10)
	public void checkthis()
	{
		System.out.println("Thread . . .");
	}

}
