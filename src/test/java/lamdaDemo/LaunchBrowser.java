package lamdaDemo;


import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class LaunchBrowser {
	
	 RemoteWebDriver driver;
   
    
    @BeforeTest
	
    public void setup() 
    {
    	
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("platform", "Windows 11");
    	caps.setCapability("name", "First Test in Remote");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "131.0");
        caps.setCapability("build", "TestNG With Java");
    	 try {
			driver = new RemoteWebDriver(new URL("https://n18guptag:7TO8brxa5A1X6WOrdrhbQFpatk8U4v77Z5qGJtDRC5B3lCyjog@hub.lambdatest.com/wd/hub"), caps);
		} catch (MalformedURLException e) {
			 System.err.println("Invalid URL provided for RemoteWebDriver: " + e.getMessage());
			e.printStackTrace();
		}
    }
    
    
	@Test
	public void myTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		System.out.println("Loading Url");
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();
		String currenturl=driver.getCurrentUrl();
		String expectedurl="https://www.lambdatest.com/selenium-playground/simple-form-demo";
		if(currenturl.equals(expectedurl))
			{
			System.out.println("URL redirection successful");
			}
		else{
			System.out.println("URL redirection failed");
		}
		String str="simple-form-demo";
		driver.findElement(By.id("user-message")).sendKeys(str);
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		String str1=driver.findElement(By.xpath("//div[@id='user-message']/p[@id='message']")).getText();
		if(str.equals(str1))
		{
			System.out.println("Same message displayed");
		}
		else
		{
			System.out.println("Message is different");
		}
	}
	@Test
	public void SecondTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		System.out.println("Loading Url");
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(":nth-child(13) > .text-black")).click();
		WebElement element=driver.findElement(By.cssSelector(".sp__range-success > .sp__range"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, 215, 0).perform();
		String Actval=driver.findElement(By.id("rangeSuccess")).getText();
		String expval="95";
		Assert.assertEquals(Actval,expval);
	}
	
	@Test
	public void ThirdTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		System.out.println("Loading Url");
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Input Form Submit']")).click();
		driver.findElement(By.id("name")).sendKeys("Satyam");
		driver.findElement(By.id("inputEmail4")).sendKeys("Satyam@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("Abc@123");
		driver.findElement(By.id("company")).sendKeys("Indra");
		driver.findElement(By.id("websitename")).sendKeys("www.google.com");
		Select Country = new Select(driver.findElement(By.name("country")));
		Country.selectByValue("AR");
		driver.findElement(By.id("inputCity")).sendKeys("Delhi");
		driver.findElement(By.id("inputAddress1")).sendKeys("Abc");
		driver.findElement(By.id("inputAddress2")).sendKeys("def");
		driver.findElement(By.id("inputState")).sendKeys("Delhi");
		driver.findElement(By.id("inputZip")).sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String actOut=driver.findElement(By.className("success-msg")).getText(); 
		String expOut="Thanks for contacting us, we will get back to you shortly.";
		if(actOut.equals(expOut))
		{
			System.out.println("Validation successfull");
		}
		
	}
	
	@AfterTest
	    public void tearDown() 
	    {
	        driver.quit();
	    }

}

