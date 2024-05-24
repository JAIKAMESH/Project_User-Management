package OrangeHRMLogin;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {
	static WebDriver dr;
	public Screenshot(WebDriver dr) {Screenshot.dr = dr;}

	public void Screenshot(String ScreenName) {
		String fpath="C:\\Users\\JAIKAMESH\\eclipse-workspace\\NewCapstan\\NewCapstonpic"
				+ "\\pic "+System.currentTimeMillis()+".png";
		TakesScreenshot scr=(TakesScreenshot) dr;
		File Actual=scr.getScreenshotAs(OutputType.FILE);
		File store=new File(fpath);
		
		try {FileHandler.copy(Actual, store);} 
		catch (Exception e) {e.printStackTrace();}
		}
}
