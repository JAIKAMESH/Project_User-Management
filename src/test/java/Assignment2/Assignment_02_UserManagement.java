package Assignment2;

import org.testng.annotations.Test;
import OrangeHRMLogin.OrangeHRMLogin;

public class Assignment_02_UserManagement extends OrangeHRMLogin{
 @Test
public void Scenario_01_PrintAllDashbaordMenu() throws Exception  {
       dr.findElement(HRM.UserName).sendKeys("Admin");
	   dr.findElement(HRM.PassWord).sendKeys("admin123");
	   dr.findElement(HRM.Button).click(); Thread.sleep(4000);
	               
	   Function.Scenario_01_PrintAllDashbaordMenu();
	   Function.Scenario_02_AdminPage_SearchExistingUser();
	   Function.Scenario_03_AdminPage_SearchUserByRoleFilter();
	   Function.Scenario_04_AdminPage_ActiveUserByStatusFilter();
	   Function.Scenario_05_AdminPage_DisabledUserByFilter();}
}
