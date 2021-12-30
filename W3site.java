package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3site {
	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumbrowserdriver\\chromedriver.exe");
		
		
		//open browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		
		
		
		WebElement iframe = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(iframe);
		
		Thread.sleep(2000);
        
		String text = driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).getText();
		
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		System.out.println(text);
		
		String text2 = driver.switchTo().alert().getText();
		
		System.out.println(text2);
		
		driver.switchTo().alert().accept();
		
		driver.close();
		driver.quit();
	}

}
