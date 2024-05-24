package Assignment01;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import OrangeHRMLogin.OrangeHRMLogin;
import OrangeHRMLogin.Screenshot;

public class Assignment1_HRMLoginLogout extends OrangeHRMLogin{
	protected Screenshot Take;
 @Test
public void HRMLoginLogout() throws InterruptedException, IOException {
Take=new Screenshot(dr);
/*-ExcelSetup-*/wb=new XSSFWorkbook(fis);sheet=wb.getSheetAt(0);

/*--Get All UserName and Password in Excel--*/
for(int i=0;i<=sheet.getLastRowNum();i++) {
dr.findElement(HRM.UserName).sendKeys(sheet.getRow(i).getCell(0).toString());
dr.findElement(HRM.PassWord).sendKeys(sheet.getRow(i).getCell(1).toString());
dr.findElement(HRM.Button).click();
Thread.sleep(3000);

   /*--Test Result--*/
    if(dr.getPageSource().contains("My Info"))
      {Test.log(Status.PASS,"Login Successfully -User"+sheet.getRow(i).getCell(0).toString());
      Take.Screenshot(i+"Pass");
       dr.findElement(HRM.ProfilePage).click();dr.findElement(HRM.Logout).click();
       System.out.println("PASS");}
    else
      {Test.log(Status.FAIL,"Invalid User-"+sheet.getRow(i).getCell(0).toString());
      Take.Screenshot(i+"FAIL");System.out.println(i+"FAIL");}}
wb.close(); fis.close();
}}
