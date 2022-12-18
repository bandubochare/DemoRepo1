package ai.ds.testlayer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ai.ds.testbase.TestBase;

public class BuyShare extends TestBase {

	@DataProvider(name = "companyNames")
	public String[] data()
	{
		String obj[]  = {"WIPRO","AXIS","Tech Mahindra","TCS"};
		return obj;
	}
	
	@Test(dataProvider = "companyNames")
	public void buyFunctionalityWIPRO(String name) throws InterruptedException
	{
		String expected_op = "Order Created successfully";
		//--- Company details  ----
		dash.enterCompanyName(name);
		dash.selectOption();
		Thread.sleep(3000);
		logger.info("Company Selected");
		//--- Process ----
		exchange.clickOnBuyButton1();
		exchange.enterQuantityOfShare();
		exchange.clickOnBuyButton2();
		Thread.sleep(3000);
		logger.info("Clicked Buy Button");
		//--- Validation Steps ----
		String actual_op= exchange.getStatus();
		System.out.println(actual_op);
		Assert.assertEquals(actual_op, expected_op);
		
	}
}
