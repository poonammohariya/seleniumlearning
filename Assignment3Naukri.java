package SeleniumPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3Naukri {
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\seleniumbrowserdriver\\chromedriver.exe");
			
			
			//open browser
			WebDriver driver = new ChromeDriver();
			 driver.get("https://www.naukri.com/");
			 Thread.sleep(3000);
			 

			 
			 String parentwindow = driver.getWindowHandle();
			 Set<String> allwindow=driver.getWindowHandles();
			 
			 Iterator<String>itr=allwindow.iterator();
			 while(itr.hasNext())
			 {
				 String Childwindow=itr.next();
				 if(!parentwindow.equals(Childwindow))
				 {
					 driver.switchTo().window(Childwindow);
					 
					 System.out.println(driver.switchTo().window(Childwindow).getTitle());
					 
					 driver.close();
				 }
				 
			 }
			 
					 driver.switchTo().window(parentwindow);
					 
					 driver.close();
					 driver.quit();
					 
					 
			 

}

}
