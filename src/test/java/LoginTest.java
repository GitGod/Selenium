import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	
	private static WebDriver driver;

	@BeforeAll
	public static void setUp() throws Exception {
		 System.setProperty("webdriver.ie.driver","E:\\" + "selenium-firefox-driver-3.12.0");
		 driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testTitlePage() {
		driver.get("https://dealsqwerty.000webhostapp.com/login.php");
    	assertEquals("Zaloguj się - Logo", driver.getTitle());
	}
	
	@Test
	public void loginSuccessful() {
		driver.get("https://dealsqwerty.000webhostapp.com/login.php");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][1]/input[@id='login']")).sendKeys("pikachu");
		driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][2]/input[@id='password']")).sendKeys("pikachu1");
		driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/button[@class='btn']")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.titleIs("Strona Główna - Logo"));
		String actual = driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='user']/a[@id='user-dropdown-toggle']")).getText();
		assertEquals("Pikachu", actual);
	}
	
	@Test
	public void loginFailed() {
		driver.get("https://dealsqwerty.000webhostapp.com/login.php");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][1]/input[@id='login']")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][2]/input[@id='password']")).sendKeys("ss");
		driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/button[@class='btn']")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.titleIs("Zaloguj się - Logo"));
		String actual = driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/div[@class='error-alert-box alert-box']/p")).getText();
		assertEquals("Podany login bądź hasło są nieprawidłowe.", actual);
	}
	
	@Test
	public void emptyFields() {
			driver.get("https://dealsqwerty.000webhostapp.com/login.php");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/button[@class='btn']")).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.titleIs("Zaloguj się - Logo"));
			String actual = driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][1]/label[@id='login-error']")).getText();
			String actual2 = driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][2]/label[@id='password-error']")).getText();
			assertEquals("Wpisz swój login.", actual);
			assertEquals("Wpisz swoje hasło.", actual2);
	}
	
	
	
	
	
	
	
	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

}

