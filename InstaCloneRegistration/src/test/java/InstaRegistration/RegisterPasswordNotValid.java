package InstaRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class RegisterPasswordNotValid {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rocky-coast-20450.herokuapp.com/register");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	    
		 // password not valid
		 driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("Roner");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1235");
		 driver.findElement(By.xpath("//input[contains(@id,'confirm_password')]")).sendKeys("1235");
		 driver.findElement(By.xpath("//input[contains(@id,'submit')]")).click();

		 String expectedErrorMsg = "Field must be at least 6 characters long.";
		 WebElement exp = driver.findElement(By.xpath("//span[contains(.,'Field must be at least 6 characters long.')]"));
		 String actualErrorMsg = exp.getText();
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	      if (expectedErrorMsg.equals("Field must be at least 6 characters long.")){
	            System.out.println("Not valid password");
	            
	        } else{
	            System.out.println("Test fail");
	        }
		 
	}

}
