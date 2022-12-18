package ai.ds.utilities;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import ai.ds.testbase.TestBase;

public class UtilClass extends TestBase {
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void takeSS(String filename)
	{
		try 
		{ Date currentdate = new Date();
		  String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
			System.out.println(screenshotfilename);
			/*Calendar cal =  Calendar.getInstance();
		Date time = cal.getTime();
		System.out.println(time);
		String times=time.toString().replace(";"," ").replace(" ","");
		System.out.println(times);*/
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File("C:\\Users\\232338\\eclipse-workspace\\Dalalstreet18JuneEB\\screenshots\\"+filename+screenshotfilename+".png");
			FileHandler.copy(source, des);
		}
		catch (IOException e) 
		{
			System.out.println("Provide correct file path");
		}
		
	}
	

}
