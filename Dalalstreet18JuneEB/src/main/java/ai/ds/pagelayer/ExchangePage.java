package ai.ds.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.ds.testbase.TestBase;

public class ExchangePage extends TestBase {
	
	public ExchangePage()
	{
		PageFactory.initElements(driver, this);
	}

	//-------------- Obj repo --------------------
	@FindBy(xpath="//a[contains(text(),'Buy')]")
	private WebElement btn_buy1;
	
	@FindBy(xpath="//input[@name='input-Qunatity']")
	private WebElement txtbox_quantity;
	
	@FindBy(xpath="//button[contains(text(),'Buy')]")
	private WebElement btn_buy2;
		
	@FindBy(xpath="//div[text()='Order Created successfully']")
	private WebElement status;
	//------------------ action methods ----------
	public void clickOnBuyButton1()
	{
		btn_buy1.click();
	}
	
	public void enterQuantityOfShare()
	{
		txtbox_quantity.click();
		txtbox_quantity.sendKeys("2");
	}
	
	public void clickOnBuyButton2()
	{
		btn_buy2.click();
	}
	
	public String getStatus()
	{
		String msg = status.getText();
		return msg;
	}
}
