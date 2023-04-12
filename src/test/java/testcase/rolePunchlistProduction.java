package testcase;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import base.BaseClass;

public class rolePunchlistProduction {

	public class PimsAdmin extends BaseClass {
		@Test(priority = 1)
		public void LoginTest() throws InterruptedException {

			driver.findElement(By.name("user_id")).sendKeys("msaricheva@engsoftsolutions.com");// locators properties
			Thread.sleep(4000);
			driver.findElement(By.id("user_password")).sendKeys("Sadyk777!");
			Thread.sleep(4000);
			driver.findElement(By.id("EnterButton")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[normalize-space()='ESS LLC - PIMS.NET - ESS - Standard Demo']")).click();
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

		@Test(priority = 2)
		public void rfiFullControl() throws InterruptedException {

			driver.get("https://pims.engsoftsolutions.com/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();

			Thread.sleep(4000);
			driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"))
					.click();

			WebElement roleRfi = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"));
			String roleRfiElement = roleRfi.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/PunchList/punchlistdetail.aspx?wi=2146&filter=False");
			if (roleRfiElement.equals("Full Control")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement = driver
							.findElement(By.id("cphContent_punchlistMain_punchlistDetail_frmViewPunchlist_EditButton"));
					System.out.println("Edit button is present on the page for Full Control for Punchlist");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page for Full Control for Punchlist");
				}
			} else {
				System.out.println("User role is not Full Control");
			}
		}

		@Test(priority = 3)
		public void rfiRead() throws InterruptedException {
			driver.get("https://pims.engsoftsolutions.com/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();
			Thread.sleep(4000);

			driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnRead']//span[@class='rbText rbPrimary'][normalize-space()='Read']"))
					.click();
			WebElement roleRfi1 = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnRead']//span[@class='rbText rbPrimary'][normalize-space()='Read']"));
			String roleRfiElement1 = roleRfi1.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/PunchList/punchlistdetail.aspx?wi=2146&filter=False");

			if (roleRfiElement1.equals("Read")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement1 = driver
							.findElement(By.id("cphContent_punchlistMain_punchlistDetail_frmViewPunchlist_EditButton"));
					System.out.println("Edit button is present on the page in Read Mode for Punchlist");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page in Read Mode for Punchlist");
				}
			} else {
				System.out.println("User role is not admin");
			}
		}

		@Test(priority = 4)
		public void rfiAdd() throws InterruptedException {
			driver.get("https://pims.engsoftsolutions.com/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();
			Thread.sleep(4000);

			driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnAdd']//span[@class='rbText rbPrimary'][normalize-space()='Add']"))
					.click();
			WebElement roleRfi2 = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnAdd']//span[@class='rbText rbPrimary'][normalize-space()='Add']"));
			String roleRfiElement2 = roleRfi2.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/PunchList/punchlistdetail.aspx?wi=2146&filter=False");

			if (roleRfiElement2.equals("Add")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement2 = driver
							.findElement(By.id("cphContent_punchlistMain_punchlistDetail_frmViewPunchlist_EditButton"));
					System.out.println("Edit button is present on the page in Add Mode for Punchlist");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page in Add Mode for Punchlist");
				}
			} else {
				System.out.println("User role is not admin");

			}
		}

		@Test(priority = 5)
		public void rfiDeny() throws InterruptedException {
			driver.get("https://pims.engsoftsolutions.com/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();
			Thread.sleep(4000);

			driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnDeny']//span[@class='rbText rbPrimary'][normalize-space()='Deny']"))
					.click();
			WebElement roleRfi3 = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnDeny']//span[@class='rbText rbPrimary'][normalize-space()='Deny']"));
			String roleRfiElement3 = roleRfi3.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/PunchList/punchlistdetail.aspx?wi=2146&filter=False");

			if (roleRfiElement3.equals("Deny")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement3 = driver
							.findElement(By.id("cphContent_punchlistMain_punchlistDetail_frmViewPunchlist_EditButton"));
					System.out.println("Edit button is present on the page in Deny Mode for Punchlist");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page in Deny Mode for Punchlist");
				}
			} else {
				System.out.println("User role is not admin");

			}
			String phrase = driver.findElement(By.id("cphContent_PageTitle")).getText();
			System.out.println("The following message pops up when the user is denied access to the page:       " + phrase);
			//user turns on "Full Control" back
			
			driver.get("https://pims.engsoftsolutions.com/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();

			Thread.sleep(4000);
			driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl09_Detail20_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"))
					.click();
		}
	}
}