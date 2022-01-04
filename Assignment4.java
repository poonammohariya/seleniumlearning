package TestngPackage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment4 {
	public WebDriver driver;
	
	
	@BeforeTest(groups = {"Smoke"})
	public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\seleniumbrowserdriver\\chromedriver.exe");
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
	}
	
	@Test(priority = 0,groups = {"Smoke"})
    public void Homepagetest() {
		 WebDriverWait ewait=new WebDriverWait(driver,10);
	driver.get("http://zero.webappsecurity.com/index.html");
    assertEquals(driver.getTitle(),"Zero - Personal Banking - Loans - Credit Cards");
  ewait.until(ExpectedConditions.elementToBeClickable(By.id("signin_button")));
    driver.findElement(By.id("signin_button")).click();
	}
	@Test(priority = 1,groups = {"Regression"})
    public void negativelogintest() {
		 WebDriverWait ewait=new WebDriverWait(driver,10);
ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#user_login")));
		driver.findElement(By.cssSelector("input#user_login")).clear();
    	driver.findElement(By.cssSelector("input#user_login")).sendKeys("usernme");
    	
    	
 ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'user_password')]")));
    	driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).clear();
    	driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).sendKeys("password");
        driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click();
    	
    }
	
	@Test(priority = 2,groups = {"Regression"})
	public void usernameblanknegativetestcase() {
		 WebDriverWait ewait=new WebDriverWait(driver,10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#user_login")));
		driver.findElement(By.cssSelector("input#user_login")).clear();
		driver.findElement(By.cssSelector("input#user_login")).sendKeys(" ");
		
	}
	
	@Test(priority = 3,groups = {"Regression"})
	
	public void negativeusernamewithwrongcredentials() {
		 WebDriverWait ewait=new WebDriverWait(driver,10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#user_login")));
		driver.findElement(By.cssSelector("input#user_login")).clear();
		driver.findElement(By.cssSelector("input#user_login")).sendKeys("Welcome");
	}
	
	@Test(priority = 4,groups = {"Regression"})
	public void negativeBlankkpasswordtestcases() {
		 WebDriverWait ewait=new WebDriverWait(driver,10);
ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'user_password')]")));
		driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).sendKeys(" ");
		
	}
	
	@Test(priority = 5,groups = {"Regression"})
	public void Incorrectpasswordnegativetestcases() {
		 WebDriverWait ewait=new WebDriverWait(driver,10);
 ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'user_password')]")));
		driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).sendKeys("Welcome124");
	}
	
	
	
    @Test(priority = 6,groups = {"Smoke"})
    public void logintest() {
    	
    	 WebDriverWait ewait=new WebDriverWait(driver,10);
    ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#user_login")));
    driver.findElement(By.cssSelector("input#user_login")).clear();
    driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
    
 ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'user_password')]")));
    driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'user_password')]")).sendKeys("password");
    
 ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'submit')]")));
    driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click();
    }
    
   
    
    @Test(priority = 7 ,groups = "Smoke")
   public void clickonlinktest() {
    	 WebDriverWait ewait=new WebDriverWait(driver,10);
ewait.until(ExpectedConditions.elementToBeClickable(By.id("details-button")));  	
   driver.findElement(By.id("details-button")).click();
   
  
ewait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link")));  
   driver.findElement(By.id("proceed-link")).click(); 
   assertEquals(driver.getTitle(),"Zero - Account Summary");
	}
    
    @Test(priority = 8,groups = "Smoke")
    public void Transferfund() {
    	driver.findElement(By.xpath("//a[contains(text(),'Transfer Funds')]")).click();
    	assertEquals(driver.getTitle(), "Zero - Transfer Funds");
    	
    }
    @Test(priority =9,groups = "Smoke" )
    public void clickonFormAccount() {
    	driver.findElement(By.id("tf_fromAccountId")).click();
    	String text1=driver.findElement(By.id("tf_fromAccountId")).getText();
    	System.out.println("text of from account" + text1);
    }
    @Test(priority =10,groups = "Smoke" )
    public void toaccount() {
    	driver.findElement(By.name("toAccountId")).click();
    }
    @Test(priority =11 ,groups = "Smoke")
    public void amount() {
    	driver.findElement(By.id("tf_amount")).click();
    }
    
   @Test(priority =12,groups = "Smoke" )
    public void paybillclicktest() {
    	driver.findElement(By.xpath("//a[contains(text(),'Pay Bills')]")).click();
    }
	
    @Test(priority = 13,groups = "Smoke")
    public void purchaseforeigncurrencycashflow() {
    	driver.findElement(By.xpath("//a[contains(text(),'Purchase Foreign Currency')]")).click();
    }
    
    @Test(priority = 14,groups = "Smoke")
    public void clickonpurchasebutton() {
    	 //driver.findElement(By.id("purchase_cash")).click();
    	 driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
 	    
 	    String amount = driver.findElement(By.className("control-label")).getText();
 	    System.out.println(amount); 
 	   WebDriverWait ewait=new WebDriverWait(driver,10);
 	   ewait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("control-label"), amount));
 		    
 		    driver.findElement(By.id("purchase_cash")).click();
 		    
 		    Alert purchase =  driver.switchTo().alert();
 		    String text =purchase.getText();
 		    System.out.println("The text on the alert is : " + text);
 		    purchase.accept();
 		    
    }
    
    @Test(priority = 15,groups = {"Smoke"})
    public void logout() {
    	
    	 WebDriverWait ewait=new WebDriverWait(driver,10);
    	 driver.findElement(By.className("brand")).click();
 	     driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
 	
 	    ewait.until(ExpectedConditions.elementToBeClickable(By.id("logout_link")));
 	    
 	    driver.findElement(By.id("logout_link")).click();
 	    
 	  String title=driver.findElement(By.className("brand")).getText();
 	  System.out.println(title);
 	  
 	 
 	  ewait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("brand"), title));
 	  
 	 
    }
	
	@AfterTest(groups = "Smoke")
    public void cleanUp() {
	driver.close();
	driver.quit();
	}

}
