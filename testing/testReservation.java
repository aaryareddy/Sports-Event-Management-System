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
public class testReservation
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
	public void Test0ReservationSuccess() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test0ReservationSuccess...");
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
		element = driver.findElement(By.id("event1"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addCart"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("username"));
		Assert.assertNotNull(element);
		element.sendKeys("shrey@shrey");
		System.out.println("Username 'shrey@shrey' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("phonenumber"));
		Assert.assertNotNull(element);
		element.sendKeys("4693959560");
		System.out.println("Phone number '4693959560' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("eventname"));
		Assert.assertNotNull(element);
		element.sendKeys("Soccer");
		System.out.println("Event name 'Soccer' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("category"));
		Assert.assertNotNull(element);
		element.sendKeys("multiplayer");
		System.out.println("Category 'multiplayer' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("address"));
		Assert.assertNotNull(element);
		element.sendKeys("Atlantis");
		System.out.println("Address 'Atlantis' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Thank You";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test0ReservationSuccess...");
		Thread.sleep(500);
	}
	
	@AfterClass
	public static void Exit()
	{
		System.out.println("Selenium testing terminated. Closing driver...");		
		driver.quit();
	}
}