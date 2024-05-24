package OrangeHRMLogin;

import java.io.*;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Assignment2.Assignment2_Function;

public class OrangeHRMLogin 
{
protected WebDriver dr;protected OrangeHRMVariables HRM;protected Assignment2_Function Function;
protected XSSFWorkbook wb; protected XSSFSheet sheet;
protected File file;protected FileInputStream fis;
protected ExtentSparkReporter spark;protected ExtentReports extent;protected ExtentTest Test;
protected ExtentSparkReporter spark1;protected ExtentReports extent1;protected ExtentTest Test1;


@BeforeTest
public void Login() throws IOException {
/*Driver Setup*/dr = new ChromeDriver();Function=new Assignment2_Function(dr);
                HRM=new OrangeHRMVariables();

/*-LoginPage-*/dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       		   dr.manage().window().maximize();dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

/*-LoginPage-*/file=new File("C:\\Users\\JAIKAMESH\\OneDrive\\Desktop\\ORangeHRM User sheet\\UserSheet4 - Copy.xlsx");
               fis=new FileInputStream(file); 

/*Assignment 1*/
/*ExtendReport*/spark=new ExtentSparkReporter("Assignment 1_Login.html");extent=new ExtentReports();
                extent.attachReporter(spark);Test=extent.createTest("OrangeHrMLogin");}

@AfterTest
public void logout() throws IOException
{extent.flush();dr.close();}
}
