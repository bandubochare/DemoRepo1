package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample1 {

	@Test(dataProvider="companyNames")
	public void test(String name)
	{
		System.out.println(name);
	}
	
	@DataProvider(name = "companyNames")
	public String[] data()
	{
		String obj[]  = {"WIPRO","AXIS","Tech Mahindra","TCS"};
		return obj;
	}
}
