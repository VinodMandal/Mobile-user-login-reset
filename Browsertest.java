package Selenium;




import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browsertest {
	
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://acviss.co/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("acvissadmin");
		driver.findElement(By.id("password")).sendKeys("Uniqolabel@12#");

		
		driver.findElement(By.id("submit")).click();

		//Locating element by link text and store in variable "Element"        		
		WebElement Element = driver.findElement(By.xpath("//span[contains(text(),'Settings') and @class=\"mdc-list-item__text mdc-drawer-text\"]//parent::a"));

		// Scrolling down the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);


		driver.findElement(By.xpath("//span[contains(text(),'Settings') and @class=\"mdc-list-item__text mdc-drawer-text\"]//parent::a")).click();

		Thread.sleep(5000);



		

		driver.findElement(By.xpath("//span[@id ='select2-selectCustomer-container']")).click();
		
		//*************************** Enter the customer name***************************
		
		driver.findElement(By.xpath("//input[@class='select2-search__field' and @type='search']")).sendKeys("Home");
		
		//*************************** Enter the customer name***************************
		
		
		driver.findElement(By.xpath("//input[@class='select2-search__field' and @type='search']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[contains(text(), 'Reset User Login') and @class='mdc-tab__text-label']//following::span[@class = 'mdc-tab__ripple mdc-ripple-upgraded']")).click();

	Thread.sleep(5000);


		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[5]";
		
		Boolean isBreak= false;
	

		for(int i=1; i<=10; i++){
			isBreak= false;
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

				//System.out.println("row count is :" + i +" "  + name);
			
			//******************** Enter date which needs to be reset**********************
			
			String date = "October 26, 2021";
			
			//******************** Enter date which needs to be reset**********************

			if(name.contains(date)) {
				System.out.println("date row count is :" + i +" "  + name);


				String BeforeIMEI = "//tbody/tr[";
				String AfterIMEI = "]/td[6]";

				String Beforetoken = "//tbody/tr[";
				String Aftertoken ="]/td[7]";

				for(int j=i; j<=10; j++) 
				{
					String imei = driver.findElement(By.xpath(BeforeIMEI + j + AfterIMEI)).getText();
					int imeicount =Integer.parseInt(imei);  

					System.out.println("IMEI row count is :" + j +" "  + imei);
					for(int k=i; k<=10; k++) 

					{
						String token = driver.findElement(By.xpath(Beforetoken + k + Aftertoken)).getText();

						int tokencount =Integer.parseInt(token);  
						System.out.println("Token row count is :" + k +" "  + token);

						if((imeicount>0) || (tokencount>0))
						{
							
							driver.findElement(By.xpath("//*[@id=\"resetUserLoginTable\"]/tbody/tr["+ i +"]/td[8]")).click();
						
							Thread.sleep(2000);
							
							 driver.findElement(By.xpath("//*[@id=\"alertConfirm\"]//button[1]")).click();
//							WebElement Txtbutton	=  driver.findElement(By.xpath("//span[@class='mdc-button__label' and contains(text(), 'Ok')]//parent::button[@class='mdc-button mdc-dialog__button mdc-ripple-upgraded']//following-sibling::div[@class='mdc-button__ripple']"));
//						
//							System.out.println("Printing " +Txtbutton.getText());
						Thread.sleep(1000);
						
							
							System.out.println("reset successfull");
						}else {
							System.out.println("count is less than 2 ");
						
						}
						
						isBreak = true;

						if (isBreak) {
							break;
						}
					}
					if (isBreak) {
						break;
					}
				}




			
	}

		}
}
	
}

