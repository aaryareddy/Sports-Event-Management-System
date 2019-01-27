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
public class testLogin
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
	public void Test0LoginInvalid_invalidUsername() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test0LoginInvalid_invalidUsername...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("abc");
		System.out.println("Email 'abc' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("123");
		System.out.println("Password '123' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Data Not Found!";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test0LoginInvalid_invalidUsername...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test1LoginInvalid_invalidPassword() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test0LoginInvalid_invalidUsername...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey@shrey");
		System.out.println("Email 'shrey@shrey' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("not_shrey");
		System.out.println("Password 'not_shrey' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Data Not Found!";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test0LoginInvalid_invalidPassword...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test2LoginValid_student() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test2LoginValid_student...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey@shrey");
		System.out.println("Email 'shrey@shrey' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey");
		System.out.println("Password 'shrey' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Hello shrey@shrey";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test2LoginValid_student...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test3LoginValid_admin() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test3LoginValid_admin...");
		driver.get("http://localhost:8080/mos/index.jsp");
		Thread.sleep(500);
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		System.out.println("Email 'root' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		System.out.println("Password '170019' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Welcome Admin";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test3LoginValid_admin...");
		Thread.sleep(500);
	}
	
	@AfterClass
	public static void Exit()
	{
		System.out.println("Selenium testing terminated. Closing driver...");		
		driver.quit();
	}
}