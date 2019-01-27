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
public class testAdmin
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
	public void Test0Inactivity() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test0Inactivity...");
    	driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(31000);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Welcome, Please login";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test0Inactivity...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test1AddEventFailed_emptyFields() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test1AddEventFailed_emptyFields...");
    	driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Empty fields are not allowed";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test1AddEventFailed_emptyFields...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test2AddEventFailed_invalidType() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test2AddEventFailed_invalidType...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("title"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball");
		System.out.println("Event name 'Basketball' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("type"));
		Assert.assertNotNull(element);
		element.sendKeys("blablabla");
		System.out.println("Type 'blablabla' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("date"));
		Assert.assertNotNull(element);
		element.sendKeys("04012019");
		System.out.println("Date '04-01-2019' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("loc"));
		Assert.assertNotNull(element);
		element.sendKeys("UTD");
		System.out.println("Venue 'UTD' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("price"));
		Assert.assertNotNull(element);
		element.sendKeys("150");
		System.out.println("Fee amount '150' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("time"));
		Assert.assertNotNull(element);
		element.sendKeys("1630");
		System.out.println("Time '1630' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("desc"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball is a multiplayer sport");
		System.out.println("Event description 'Basketball is a multiplayer sport' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Invalid Event type";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test2AddEventFailed_invalidType...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test3AddEventFailed_invalidDate() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test3AddEventFailed_invalidDate...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("title"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball");
		System.out.println("Event name 'Basketball' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("type"));
		Assert.assertNotNull(element);
		element.sendKeys("multiplayer");
		System.out.println("Type 'multiplayer' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("date"));
		Assert.assertNotNull(element);
		element.sendKeys("04012017");
		System.out.println("Date '04-01-2017' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("loc"));
		Assert.assertNotNull(element);
		element.sendKeys("UTD");
		System.out.println("Venue 'UTD' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("price"));
		Assert.assertNotNull(element);
		element.sendKeys("150");
		System.out.println("Fee amount '150' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("time"));
		Assert.assertNotNull(element);
		element.sendKeys("1630");
		System.out.println("Time '1630' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("desc"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball is a multiplayer sport");
		System.out.println("Event description 'Basketball is a multiplayer sport' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Invalid Date";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test3AddEventFailed_invalidDate...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test4AddEventFailed_invalidPrice() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test4AddEventFailed_invalidPrice...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("title"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball");
		System.out.println("Event name 'Basketball' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("type"));
		Assert.assertNotNull(element);
		element.sendKeys("multiplayer");
		System.out.println("Type 'multiplayer' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("date"));
		Assert.assertNotNull(element);
		element.sendKeys("04012019");
		System.out.println("Date '04-01-2019' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("loc"));
		Assert.assertNotNull(element);
		element.sendKeys("UTD");
		System.out.println("Venue 'UTD' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("price"));
		Assert.assertNotNull(element);
		element.sendKeys("abc");
		System.out.println("Fee amount 'abc' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("time"));
		Assert.assertNotNull(element);
		element.sendKeys("1630");
		System.out.println("Time '1630' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("desc"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball is a multiplayer sport");
		System.out.println("Event description 'Basketball is a multiplayer sport' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Invalid Price";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test4AddEventFailed_invalidPrice...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test5AddEventFailed_invalidTime() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test5AddEventFailed_invalidTime...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("title"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball");
		System.out.println("Event name 'Basketball' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("type"));
		Assert.assertNotNull(element);
		element.sendKeys("multiplayer");
		System.out.println("Type 'multiplayer' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("date"));
		Assert.assertNotNull(element);
		element.sendKeys("04012019");
		System.out.println("Date '04-01-2019' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("loc"));
		Assert.assertNotNull(element);
		element.sendKeys("UTD");
		System.out.println("Venue 'UTD' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("price"));
		Assert.assertNotNull(element);
		element.sendKeys("150");
		System.out.println("Fee amount '150' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("time"));
		Assert.assertNotNull(element);
		element.sendKeys("2630");
		System.out.println("Time '2630' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("desc"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball is a multiplayer sport");
		System.out.println("Event description 'Basketball is a multiplayer sport' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Invalid Time";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test5AddEventFailed_invalidTime...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test6AddEventSuccess_single() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test6AddEventSuccess_single...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("title"));
		Assert.assertNotNull(element);
		element.sendKeys("Chess");
		System.out.println("Event name 'Chess' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("type"));
		Assert.assertNotNull(element);
		element.sendKeys("single");
		System.out.println("Type 'single' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("date"));
		Assert.assertNotNull(element);
		element.sendKeys("04012019");
		System.out.println("Date '04-01-2019' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("loc"));
		Assert.assertNotNull(element);
		element.sendKeys("UTD");
		System.out.println("Venue 'UTD' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("price"));
		Assert.assertNotNull(element);
		element.sendKeys("150");
		System.out.println("Fee amount '150' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("time"));
		Assert.assertNotNull(element);
		element.sendKeys("1630");
		System.out.println("Time '1630' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("desc"));
		Assert.assertNotNull(element);
		element.sendKeys("Chess is a strategy sport");
		System.out.println("Event description 'Chess is a strategy sport' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Sports Event has been added";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test6AddEventSuccess_single...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test7AddEventSuccess_multiplayer() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test7AddEventSuccess_multiplayer...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("addevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("title"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball");
		System.out.println("Event name 'Basketball' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("type"));
		Assert.assertNotNull(element);
		element.sendKeys("multiplayer");
		System.out.println("Type 'multiplayer' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("date"));
		Assert.assertNotNull(element);
		element.sendKeys("04012019");
		System.out.println("Date '04-01-2019' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("loc"));
		Assert.assertNotNull(element);
		element.sendKeys("UTD");
		System.out.println("Venue 'UTD' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("price"));
		Assert.assertNotNull(element);
		element.sendKeys("150");
		System.out.println("Fee amount '150' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("time"));
		Assert.assertNotNull(element);
		element.sendKeys("1630");
		System.out.println("Time '1630' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("desc"));
		Assert.assertNotNull(element);
		element.sendKeys("Basketball is a multiplayer sport");
		System.out.println("Event description 'Basketball is a multiplayer sport' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.id("add_event"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Sports Event has been added";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test7AddEventSuccess_multiplayer...");
		Thread.sleep(500);
	}
	
	@Test
	public void Test8DeleteEvent() throws NoSuchElementException, InterruptedException
	{
		System.out.println("Commencing test Test8DeleteEvent...");
		driver.get("http://localhost:8080/mos/index.jsp");
		element = driver.findElement(By.id("Login"));
		Assert.assertNotNull(element);
		element.click();
		element = driver.findElement(By.id("email"));
		Assert.assertNotNull(element);
		element.sendKeys("root");
		element = driver.findElement(By.name("password"));
		Assert.assertNotNull(element);
		element.sendKeys("170019");
		element = driver.findElement(By.id("login"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("deleteevent"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		element = driver.findElement(By.id("id"));
		Assert.assertNotNull(element);
		element.sendKeys("15");
		System.out.println("Event ID '15' entered.");
		Thread.sleep(500);
		element = driver.findElement(By.name("submit"));
		Assert.assertNotNull(element);
		element.click();
		Thread.sleep(500);
		String result = driver.findElement(By.tagName("body")).getText();
		String check = "Sports Event Successfully deleted";
		Assert.assertTrue(result.contains(check));	
		System.out.println("Terminating test Test8DeleteEvent...");
		Thread.sleep(500);
	}
	
	@AfterClass
	public static void Exit()
	{
		System.out.println("Selenium testing terminated. Closing driver...");		
		driver.quit();
	}
}