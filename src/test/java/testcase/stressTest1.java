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

public class stressTest1 {
	
	
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
			
			/*
			 * WebElement subjectField =
			 * driver.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtSubject"
			 * )); String maxLength = subjectField.getAttribute("maxlength");
			 * driver.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtSubject"
			 * )).sendKeys("test");
			 * 
			 * 
			 * String expectedMaxLength = "100"; assert maxLength.equals(expectedMaxLength)
			 * : "Expected max length:" + expectedMaxLength + ", but got: " + maxLength;
			 * System.out.println("Maximum character limit of input box: " +maxLength);
			 * 
			 * 
			 * //another one: WebElement descriptionField = driver.findElement(By.id(
			 * "ctl00_cphContent_PCNMain_PCNDetail_frmViewPCN_redDescriptionCenter"));
			 * String maxLength1 = descriptionField.getAttribute("maxlength");
			 * driver.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtSubject"
			 * )).sendKeys("test"); String expectedMaxLength1 = "500"; assert
			 * maxLength1.equals(expectedMaxLength1) : "Expected max length:" +
			 * expectedMaxLength1 + ", but got: " + maxLength;
			 * System.out.println("Maximum character limit of input box: " +maxLength1);
			 */
			 
			
			
			///from here
			WebElement subjectField = driver.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtSubject"));
		    String subjectMaxLength = subjectField.getAttribute("maxlength");
		    assert subjectMaxLength.equals("100") : "Expected max length: 200, but got: " + subjectMaxLength;
		    System.out.println("Maximum character limit of subject field: " + subjectMaxLength);

		    // Verify maximum character limit for Vendor CO
		    WebElement vendorCO = driver.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtVendorCO"));
		    String vendorCOMaxLength = vendorCO.getAttribute("maxlength");
		    assert vendorCOMaxLength.equals("2000") : "Expected max length: 2000, but got: " + vendorCOMaxLength;
		    System.out.println("Maximum character limit of vendorCO field: " + vendorCOMaxLength);
		    
			WebElement AlternateID = driver
					.findElement(By.id("cphContent_PCNMain_PCNDetail_frmViewPCN_txtAlternateId"));
			String AlternateidMaxLength = AlternateID.getAttribute("maxlength");
			assert AlternateidMaxLength.equals("200") : "Expected max length: 200, but got: " + AlternateidMaxLength;
			System.out.println("Maximum character limit of Alternate id field: " + AlternateidMaxLength);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			

			driver.switchTo().frame("ctl00_cphContent_PCNMain_PCNDetail_frmViewPCN_redDescription_contentIframe");
			WebElement description = driver.findElement(By.cssSelector("body"));
			String descriptionMaxLength1 = description.getAttribute("maxlength");
			
			if (descriptionMaxLength1 != null && descriptionMaxLength1.equals("10000")) {
			    System.out.println("Maximum character limit of Description field: " + descriptionMaxLength1);
			} else {
			    String errorMessage = "Expected max length: 10000, but got: " + descriptionMaxLength1;
			    System.err.println(errorMessage);
			    throw new AssertionError(errorMessage);
			}
			
			//assert descriptionMaxLength1.equals("10000") : "Expected max length: 10000, but got: " + descriptionMaxLength1;

			//System.out.println("Maximum character limit of Description  field: " + descriptionMaxLength1);

			/*
			 * driver.switchTo().frame(
			 * "ctl00_cphContent_PCNMain_PCNDetail_frmViewPCN_redDescription_contentIframe")
			 * ; WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 * WebElement nearbyElement =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
			 * "cphContent_PCNMain_PCNDetail_frmViewPCN_cvDescription"))); // Move the mouse
			 * pointer to the nearby element using Actions class Actions actions = new
			 * Actions(driver); actions.moveToElement(nearbyElement).perform(); // Use
			 * JavaScript to click on the hidden button WebElement hiddenButton =
			 * driver.findElement(By.id("hiddenButton")); JavascriptExecutor executor =
			 * (JavascriptExecutor)driver; executor.executeScript("arguments[0].click();",
			 * hiddenButton); // Switch back to the default content
			 * driver.switchTo().defaultContent(); // Close the browser driver.quit();
			 */
		    
		
			

			
			
		
			
		
	
	
	
	

		}}}