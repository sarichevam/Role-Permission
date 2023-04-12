package testcase;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class roleAccess {
	
	
	public class PimsAdmin extends BaseClass {
		@Test(priority=1)
		public void LoginTest() throws InterruptedException {

			driver.findElement(By.name("user_id")).sendKeys("msaricheva@engsoftsolutions.com");// locators properties
			Thread.sleep(4000);
			driver.findElement(By.id("user_password")).sendKeys("pims2021");
			Thread.sleep(4000);
			driver.findElement(By.id("EnterButton")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[normalize-space()='ESS LLC - PIMS.NET QA']")).click();
			Thread.sleep(4000);
			String at = driver.getTitle();
			String no = "PIMS";
			// System.out.println(at);
			if (at.equalsIgnoreCase(no)) {
				System.out.println("Test Successful");
			} else {
				System.out.println("Test Failure");

			}
			// Assert.assertTrue(false);
		}
		@Test(priority=2)
		public void switchingPims() throws InterruptedException {
		
			driver.get("https://pimsqa.engsoftsolutions.net/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();
			
			Thread.sleep(4000);
			
			
			driver.findElement(By.xpath("//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']")).click();
			WebElement element = driver.findElement(By.xpath("//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"));

			// Get the inner text of the element
			String innerText = element.getText();

			// Verify if the inner text matches "6 - Critical Exception"
			if (innerText.equals("Full Control")) {
			    System.out.println("The role access is: Full Control'");
			} else {
			    System.out.println("The role access is NOT: Full Control");
			}
			
			driver.get("https://pimsqa.engsoftsolutions.net/pages/workitem/PunchList/punchlistdetail.aspx?wi=2134&filter=False");
			
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[normalize-space()='Comments']")).click();
			
			Thread.sleep(4000);
			
			
			
			
			//punchlist 90, comment 2nd from the top
			WebElement checkbox = driver.findElement(By.id("ctl00_cphContent_punchlistMain_WorkItemComment_rdgComment_ctl00_ctl06_chkIsActive"));

			
			
			
			if (checkbox.isSelected()) {
				//checkbox.click();
			}
			System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
			
			WebElement element1 = driver.findElement(By.xpath("//td[@class='Comment']"));
			String textContent = element1.getText();
			System.out.println("The text content is: " + textContent);
			
			driver.get("https://pimsqa.engsoftsolutions.net/Pages/WorkItem/PunchList/punchlistlist.aspx");
			
			
			WebElement punchlistLog = driver.findElement(By.xpath("//td[normalize-space()='Test Comment, tester, tester']"));
			String textContent1 = punchlistLog.getText();
			System.out.println("The text content is:" +textContent1);
			
			if(textContent1.contains(textContent)) {
			    System.out.println("The active item appears in the column");
			} else {
			    System.out.println("The active item DOES NOT appear in the column");
			}
			
			long startTime = System.currentTimeMillis();
			long endtime = System.currentTimeMillis();
			long duration = endtime - startTime;

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

}}}
