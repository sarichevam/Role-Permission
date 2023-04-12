package testcase;






import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
//PIMS TEST BRINNY

public class verifyingClass extends BaseClass {
	//String [] names = {"yadayada", "masha", "misha"};
	@Test(groups= {"smoke"})
	public void LoginTest() throws InterruptedException {
		

		driver.findElement(By.name("user_id")).sendKeys("msaricheva@engsoftsolutions.com");// locators properties
		Thread.sleep(4000);
		driver.findElement(By.id("user_password")).sendKeys("pims2021");
		Thread.sleep(4000);
		driver.findElement(By.id("EnterButton")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[normalize-space()='ESS LLC - PIMS.NET QA']")).click();
		Thread.sleep(4000);
		
		
		  driver.get(
		  "https://pimsqa.engsoftsolutions.net/pages/reporting/efereports/efetoptrackerdashboard.aspx?rpid=0"
		  );
		  
		  WebElement element = driver.findElement(By.xpath("//td[normalize-space()='Autoclave #1']")); 
		  String expectedText = "Autoclave #1";
		  String actualText = element.getText(); 
		  
		  Assert.assertEquals(actualText, expectedText);
		  
		  Thread.sleep(4000);
		  
		  driver.findElement(By.xpath("//tr[@id='ctl00_cphContent_ReportTemplate_rdgReportTemplate_ctl00__3']//a[contains(text(),'2/0')]")).click();
		  Thread.sleep(4000);
		  System.out.println("The actual text is :" + actualText );
		  
	}
	@Test(dependsOnMethods = "LoginTest", groups= {"smoke", "functional"})
	public void Testik() throws InterruptedException {
		
		driver.get(
				  "https://pimsqa.engsoftsolutions.net/pages/reporting/efereports/efetoptrackerdashboard.aspx?rpid=0"
				  );
		WebElement punchlict = driver.findElement(By.xpath("//a[normalize-space()='1 - IC Critical']"));
		String expectedText = "1 - IC Critical";
		String actualText = punchlict.getText();
		
		Assert.assertEquals(actualText, expectedText);
		System.out.println("The actual text is :" + actualText );
		
		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		 
		
	
		
		
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}}