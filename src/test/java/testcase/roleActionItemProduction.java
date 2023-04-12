package testcase;




import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import base.BaseClass;

public class roleActionItemProduction {

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
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"))
					.click();

			WebElement roleAction = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"));
			String roleActionElement = roleAction.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/WorkItemActionItem/actionitemdetail.aspx?wi=2121&filter=False");
			if (roleActionElement.equals("Full Control")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement = driver
							.findElement(By.id("cphContent_actionItemMain_actionItemDetail_frmViewActionItem_EditButton"));
					System.out.println("Edit button is present on the page for Full Control for Action Item");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page for Full Control for Action Item");
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
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnRead']//span[@class='rbText rbPrimary'][normalize-space()='Read']"))
					.click();
			WebElement roleAction1 = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnRead']//span[@class='rbText rbPrimary'][normalize-space()='Read']"));
			String roleActionElement1 = roleAction1.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/WorkItemActionItem/actionitemdetail.aspx?wi=2121&filter=False");

			if (roleActionElement1.equals("Read")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement1 = driver
							.findElement(By.id("cphContent_actionItemMain_actionItemDetail_frmViewActionItem_EditButton"));
					System.out.println("Edit button is present on the page in Read Mode for Action Item");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page in Read Mode for Action Item");
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
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnAdd']//span[@class='rbText rbPrimary'][normalize-space()='Add']"))
					.click();
			WebElement roleAction2 = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnAdd']//span[@class='rbText rbPrimary'][normalize-space()='Add']"));
			String roleActionElement2 = roleAction2.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/WorkItemActionItem/actionitemdetail.aspx?wi=2121&filter=False");

			if (roleActionElement2.equals("Add")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement2 = driver
							.findElement(By.id("cphContent_actionItemMain_actionItemDetail_frmViewActionItem_EditButton"));
					System.out.println("Edit button is present on the page in Add Mode for Action Item");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page in Add Mode for Action Item");
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
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnDeny']//span[@class='rbText rbPrimary'][normalize-space()='Deny']"))
					.click();
			WebElement roleAction3 = driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnDeny']//span[@class='rbText rbPrimary'][normalize-space()='Deny']"));
			String roleActionElement3 = roleAction3.getText();

			driver.get(
					"https://pims.engsoftsolutions.com/Pages/WorkItem/WorkItemActionItem/actionitemdetail.aspx?wi=2121&filter=False");

			if (roleActionElement3.equals("Deny")) {
				// Find the edit button element and verify if it's present
				try {
					WebElement editButtonElement3 = driver
							.findElement(By.id("cphContent_fpidcnMain_fpidcnDetail_frmViewFPIDCN_EditButton"));
					System.out.println("Edit button is present on the page in Deny Mode for Action Item");
				} catch (Exception e) {
					System.out.println("Edit button is not present on the page in Deny Mode for Action Item");
				}
			} else {
				System.out.println("User role is not admin");

			}
			String phrase = driver.findElement(By.id("cphContent_PageTitle")).getText();
			System.out.println("The following message pops up when the user is denied access to the page:   " + phrase);
			
		//user turns on "Full Control" back
		
			driver.get("https://pims.engsoftsolutions.com/pages/administration/adminroleaccess.aspx?rid=1");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[@class='rtsTxt'][normalize-space()='Project Management']")).click();

			Thread.sleep(4000);
			driver.findElement(By.xpath(
					"//span[@id='ctl00_cphContent_AdminRoleAccess_rdgRoleAccess_ctl00_ctl12_Detail30_ctl04_btnOverride']//span[@class='rbText rbPrimary'][normalize-space()='Full Control']"))
					.click();
	}
}}