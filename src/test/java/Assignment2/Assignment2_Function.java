package Assignment2;

import java.util.List;
import org.openqa.selenium.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import OrangeHRMLogin.OrangeHRMLogin;
import OrangeHRMLogin.OrangeHRMVariables;

public class Assignment2_Function extends OrangeHRMLogin
{WebDriver dr;

public Assignment2_Function(WebDriver dr) {this.dr = dr;}

protected OrangeHRMVariables HRM;

public void Scenario_01_PrintAllDashbaordMenu() throws Exception {
	spark1=new ExtentSparkReporter("Assignment 2_UserManagement.html");extent1=new ExtentReports();
	extent1.attachReporter(spark1);Test1=extent1.createTest("UserManagement");
	
	HRM=new OrangeHRMVariables();
	List<WebElement> Dashboard=dr.findElements(HRM.DashboardMenu);
	System.out.println("Option Size: "+Dashboard.size());
	dr.findElement(HRM.Adminmenu).click();
	Test1.log(Status.PASS, "Scenario_01_PrintAllDashbaordMenu is Passed");
}

public void Scenario_02_AdminPage_SearchExistingUser() throws InterruptedException {
	Thread.sleep(3000);
	dr.findElement(HRM.AdminSearch).sendKeys("Admin");
	dr.findElement(HRM.AdminSearchButton).click();
	Thread.sleep(3000);
	String result[]=dr.findElement(HRM.AdminResult).getText().replaceAll("[()]","").trim().split(" ");
	System.out.println("Total Records Found for Admin Search: "+result[0]);
	Test1.log(Status.PASS, "Scenario_02_AdminPage_SearchExistingUser is Passed");
	dr.navigate().refresh();}

public void Scenario_03_AdminPage_SearchUserByRoleFilter() throws InterruptedException {
	dr.findElement(HRM.AdminRoleSelection).click();
	dr.findElement(HRM.AdminRoleSelectvalue).click();
	dr.findElement(HRM.AdminSearchButton).click();
	Thread.sleep(3000);
	String result[]=dr.findElement(HRM.AdminResult).getText().replaceAll("[()]","").trim().split(" ");
	System.out.println("Total Records Found for RoleFilter Search: "+result[0]);
	dr.navigate().refresh();
	Test1.log(Status.PASS, "Scenario_03_AdminPage_SearchUserByRoleFilter is Passed");}

public void Scenario_04_AdminPage_ActiveUserByStatusFilter() throws InterruptedException {
	dr.findElement(HRM.StatusFilterSelection).click();
	dr.findElement(HRM.StatusFilterEnabled).click();
	dr.findElement(HRM.AdminSearchButton).click();
	Thread.sleep(3000);
	String result[]=dr.findElement(HRM.AdminResult).getText().replaceAll("[()]","").trim().split(" ");
	System.out.println("Total Records Found for ActiveUser Search: "+result[0]);
	dr.navigate().refresh();
	Test1.log(Status.PASS, "Scenario_04_AdminPage_ActiveUserByStatusFilter is Passed");}

public void Scenario_05_AdminPage_DisabledUserByFilter() throws InterruptedException {
	dr.findElement(HRM.StatusFilterSelection).click();
	dr.findElement(HRM.StatusFilterDisabled).click();
	dr.findElement(HRM.AdminSearchButton).click();
	Thread.sleep(3000);
	String result[]=dr.findElement(HRM.AdminResult).getText().replaceAll("[()]","").trim().split(" ");
	
	if(result[0].contains(".*\\d.*")==false) {System.out.println("Total Records Found for Inactive Search: 0");}
	  else {System.out.println("Total Records Found for Inactive Search: "+result[0]);}
	dr.navigate().refresh();
	Test1.log(Status.PASS, "Scenario_05_AdminPage_DisabledUserByFilter is Passed");
	extent1.flush();}

}
