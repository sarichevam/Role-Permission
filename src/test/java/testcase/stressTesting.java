package testcase;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import base.BaseClass;

public class stressTesting {
	
	
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
		
			driver.get("https://pimsqa.engsoftsolutions.net/Pages/WorkItem/workitempcn/pcndetail.aspx");
			Thread.sleep(4000);
			WebElement field = driver.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtSubject"));
			field.sendKeys("tesdfgsdfgsdfgsdfgsdfgfgfgsfdgsfdgttesdfjojojojojojgsdfgsdfgsdfgsdfgfgfgsfdgsfdgttesdfgsdfgsdfgsdfgsdfgfgfgsfdgsfdgt");
			String typedValue = field.getAttribute("value");
			int size = typedValue.length();
			
			if (size <= 100 ) {
				System.out.println("User can enter only 100");
			}else {
				System.out.println("No limit is set");
			}
			
			
			
			
			
			
			
			
		}}}