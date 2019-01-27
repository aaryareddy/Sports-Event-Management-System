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
public class testRegistration
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
	public void Test0LoginInvalid_userDoesNotExist() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test0LoginInvalid_userDoesNotExist...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("bonaparte@france");
		System.out.println("Email ID 'bonaparte@france' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("waterloo");
		System.out.println("Password 'waterloo' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Data Not Found!";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test0LoginInvalid_userDoesNotExist...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test1RegistrationInvalid_emptyFields() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test1RegistrationInvalid_emptyFields...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("Registration"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Can not leave data fields empty";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test1RegistrationInvalid_emptyFields...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test2RegistrationInvalid_differentPasswords() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test2RegistrationInvalid_differentPasswords...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("Registration"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("bonaparte@france");
		System.out.println("Email ID 'bonaparte@france' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("name"));
		Assert.assertNotNull(element);
		element.sendKeys("nepoleon");
		System.out.println("Name 'nepoleon' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("password"));
		Assert.assertNotNull(element);
		element.sendKeys("waterloo");
		System.out.println("Password 'waterloo' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("retry-password"));
		Assert.assertNotNull(element);
		element.sendKeys("waterloo:D");
		System.out.println("Retry password 'waterloo:D' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Passwords do not match";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test2RegistrationInvalid_differentPasswords...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test3RegistrationValid() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test3RegistrationValid...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("Registration"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("bonaparte@france");
		System.out.println("Email ID 'bonaparte@france' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("name"));
		Assert.assertNotNull(element);
		element.sendKeys("nepoleon");
		System.out.println("Name 'nepoleon' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("password"));
		Assert.assertNotNull(element);
		element.sendKeys("waterloo");
		System.out.println("Password 'waterloo' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("retry-password"));
		Assert.assertNotNull(element);
		element.sendKeys("waterloo");
		System.out.println("Retry password 'waterloo' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Registration done, please login!";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test3RegistrationValid...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test4LoginValid_newUser() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test4LoginValid_newUser...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("bonaparte@france");
		System.out.println("Username 'bonaparte@france' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("waterloo");
		System.out.println("Password 'waterloo' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Hello bonaparte@france";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test4LoginValid_newUser...");
		Thread.sleep(500);
	}
	
	@AfterClass
	public static void Exit()
	{
		System.out.println("Selenium testing terminated. Closing driver...");		
		driver.quit();
	}
}