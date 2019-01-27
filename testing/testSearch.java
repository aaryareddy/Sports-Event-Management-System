import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testSearch
{
	private static WebDriver driver;
	private static WebElement element;
	
	@BeforeClass
	public static void prepare() throws InterruptedException 
	{
		System.out.println("Launching MoveOutSports...");
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\acads\\eclipse\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://localhost:8080/mos");
	}
	
	@Test
	public void Test0Search_single() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test0Search_single...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey@shrey");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		
		// get count of singleplayer events
		String temp = driver.findElement(By.tagName("body")).getText();
		String single = "single";
		String multiplayer = "multiplayer";
		int lastIndex = 0;
		int count = 0, count2 = 0, count3 = 0;
		while(lastIndex != -1){

		    lastIndex = temp.indexOf(single,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += single.length();
		    }
		}
		
		element = driver.findElement(By.id("single"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		lastIndex = 0;
		while(lastIndex != -1){

		    lastIndex = result.indexOf(single,lastIndex);

		    if(lastIndex != -1){
		        count2 ++;
		        lastIndex += single.length();
		    }
		}
		Assert.assertTrue(count == count2);	

		lastIndex = 0;
		while(lastIndex != -1){

		    lastIndex = result.indexOf(multiplayer,lastIndex);

		    if(lastIndex != -1){
		        count3 ++;
		        lastIndex += multiplayer.length();
		    }
		}
		Assert.assertTrue(count3 == 0);	
		
		System.out.println("Terminating test Test0Search_single...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test1Search_multiplayer() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test1Search_multiplayer...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey@shrey");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		
		// get count of multiplayer events
		String temp = driver.findElement(By.tagName("body")).getText();
		String single = "single";
		String multiplayer = "multiplayer";
		int lastIndex = 0;
		int count = 0, count2 = 0, count3 = 0;
		while(lastIndex != -1){

		    lastIndex = temp.indexOf(multiplayer,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += multiplayer.length();
		    }
		}
		
		element = driver.findElement(By.id("multiplayer"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		
		//verify count of multiplayer events
		lastIndex = 0;
		while(lastIndex != -1){

		    lastIndex = result.indexOf(multiplayer,lastIndex);

		    if(lastIndex != -1){
		        count2 ++;
		        lastIndex += multiplayer.length();
		    }
		}
		Assert.assertTrue(count == count2);	
		
		//verify that no singleplayer event is shown
		lastIndex = 0;
		while(lastIndex != -1){

		    lastIndex = result.indexOf(single,lastIndex);

		    if(lastIndex != -1){
		        count3 ++;
		        lastIndex += single.length();
		    }
		}
		Assert.assertTrue(count3 == 0);	
		
		System.out.println("Terminating test Test1Search_multiplayer...");
		Thread.sleep(500);
	}
	
	@AfterClass
	public static void Exit()
	{
		System.out.println("Selenium testing terminated. Closing driver...");		
		driver.quit();
	}
}
