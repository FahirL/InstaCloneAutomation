package InstaRegistration;


import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterNameNotValid {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rocky-coast-20450.herokuapp.com/register");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	    
		 // register name not valid
		 driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("s");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test12345678");
		 driver.findElement(By.xpath("//input[contains(@id,'confirm_password')]")).sendKeys("test12345678");
		 driver.findElement(By.xpath("//input[contains(@id,'submit')]")).click();
		 
		 String expectedErrorMsg = "Field must be between 2 and 20 characters long.";
		 WebElement exp = driver.findElement(By.xpath("//span[contains(.,'Field must be between 2 and 20 characters long.')]"));
		 String actualErrorMsg = exp.getText();
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	      if (expectedErrorMsg.equals("Field must be between 2 and 20 characters long.")){
	            System.out.println("Not valid name");
	            
	        } else{
	            System.out.println("Test fail");
	        }
	}

}
