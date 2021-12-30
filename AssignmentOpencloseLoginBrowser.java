package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentOpencloseLoginBrowser {
	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\seleniumbrowserdriver\\chromedriver.exe");
		
		
		//open browser
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//open url
		driver.get("http://zero.webappsecurity.com/index.html");
		
		driver.findElement(By.id("signin_button")).click();
		
	    driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
	    
	    driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).sendKeys("password");
	    
	    driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click();
	    
	    driver.findElement(By.id("details-button")).click();
	    
	    driver.findElement(By.id("proceed-link")).click(); 
	    
	    driver.findElement(By.xpath("//a[contains(@href,'pay-bills.html')]")).click();
	    
	    driver.findElement(By.xpath("//a[contains(text(),'Add New Payee')]")).click();
	    
	    driver.findElement(By.className("brand")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
	
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("logout_link")).click();
	    
	    Thread.sleep(1000);
	    
	    driver.close();
	    driver.quit();
		
	}

}
