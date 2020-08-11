package InstaRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RegisterValidData {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rocky-coast-20450.herokuapp.com/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		 // register input valid
		 driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("Jony");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test12345678");
		 driver.findElement(By.xpath("//input[contains(@id,'confirm_password')]")).sendKeys("test12345678");
		 driver.findElement(By.xpath("//input[contains(@id,'submit')]")).click();

		 WebElement textDemo = driver.findElement(By.xpath("//div[contains(@role,'alert')]"));
			 
		 if(textDemo.isDisplayed())
		  {
			System.out.println("Register success");
		  }
			 
		  else
		  System.out.println("Test fail"); 
		

}	
	
	
	}

