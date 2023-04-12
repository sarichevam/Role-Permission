package testcase;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class ProjectDashboard extends BaseClass {
	@Test
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

	@Test(dependsOnMethods = "LoginTest")
	public void projectDashboard() throws InterruptedException {

		driver.get("https://pimsqa.engsoftsolutions.net/adminlist.aspx?md=15");
		Thread.sleep(4000);
		// driver.findElement(By.id("ctl00_cphContent_adminTypeInstance_rdgTypeInstance_ctl00_ctl09_EditButton")).click();
		// Thread.sleep(4000);
		// driver.findElement(By.id("ctl00$cphContent$adminTypeInstance$rdgTypeInstance$ctl00$ctl09$ctl00")).click();
		// driver.findElement(By.id("ctl00_cphContent_adminTypeInstance_rdgTypeInstance_ctl00_ctl09_EditButton")).click();
		Thread.sleep(4000);
		String at1 = driver.getTitle();
		String no1 = "Punchlist Priority Administration";
		// System.out.println(at);
		if (at1.equalsIgnoreCase(no1)) {
			System.out.println("You are on the 'Punchlict Priority Administration page'.");
		} else {
			System.out.println("The title does not match");
			Assert.fail("The title is wrong");
		}
	}

	@Test
	public void continueTesting() throws InterruptedException {
		driver.get("https://pimsqa.engsoftsolutions.net/adminlist.aspx?md=15");
		driver.findElement(By.id("ctl00_cphContent_adminTypeInstance_rdgTypeInstance_ctl00_ctl09_EditButton")).click();
		
		
		Thread.sleep(4000);
		
		//driver.findElement(By.name("ctl00$cphContent$adminTypeInstance$rdgTypeInstance$ctl00$ctl09$ctl00")).click();
		
		
		
		//driver.findElement(By.xpath("//input[@id='ctl00_cphContent_adminTypeInstance_rdgTypeInstance_ctl00_ctl09_UpdateButton']")).click();
		WebElement checkbox = driver.findElement(By.name("ctl00$cphContent$adminTypeInstance$rdgTypeInstance$ctl00$ctl09$ctl00"));
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('onclick')", checkbox);
		checkbox.click();
		Thread.sleep(4000);
		if (checkbox.isSelected()) {
		    System.out.println("Checkbox '6 - Critical Exception' is checked");
		} else {
		    System.out.println("Checkbox '6 - Critical Exception' is not checked");
		}
		driver.findElement(By.xpath("//input[@id='ctl00_cphContent_adminTypeInstance_rdgTypeInstance_ctl00_ctl09_UpdateButton']")).click();
		WebElement element = driver.findElement(By.cssSelector("input[value='6 - Critical Exception']"));
		String value = element.getAttribute("value");
				
		System.out.println("Value: "+ value);
}
	@Test(dependsOnMethods = "continueTesting")
	public void systemActivityTracker() {
		
		driver.get("https://pimsqa.engsoftsolutions.net/pages/reporting/efereports/efetoptrackerdashboard.aspx?rpid=0");
		// Find the element
		WebElement element = driver.findElement(By.xpath("//a[contains(@onclick, 'Priority24') and contains(@title, 'sort') and text()='6 - Critical Exception']"));

		// Get the inner text of the element
		String innerText = element.getText();

		// Verify if the inner text matches "6 - Critical Exception"
		if (innerText.equals("6 - Critical Exception")) {
		    System.out.println("The element has the value '6 - Critical Exception'");
		} else {
		    System.out.println("The element does not have the value '6 - Critical Exceptionn'");
		}

		
		
	}}
		
		
	
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	