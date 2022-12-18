package ai.ds.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.ds.testbase.TestBase;

public class DashboardPage extends TestBase {
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//-------------- Obj repo --------------------
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement txtbox_search;
	
	@FindBy(xpath="(//div[@class='m-4 card'])[2]")
	private WebElement option;
	
	@FindBy(xpath="//a[text()='Transactions']")
	private WebElement link_transaction;
	
	
	//------------------ action methods ----------
	public void enterCompanyName(String companyname)
	{
		txtbox_search.sendKeys(companyname);
	}
	
	public void selectOption()
	{
		option.click();
	}
	
	public void clickOnTransactionsLink()
	{
		link_transaction.click();
	}

}
