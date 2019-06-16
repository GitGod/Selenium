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

public class AdminTest {
	
	private static WebDriver driver;

	@BeforeAll
	public static void setUp() throws Exception {
		 System.setProperty("webdriver.ie.driver","E:\\" + "selenium-firefox-driver-3.12.0");
		 driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testgettoadminpanel(){
	driver.get("https://dealsqwerty.000webhostapp.com/login.php");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][1]/input[@id='login']")).sendKeys("pikachu");
	driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][2]/input[@id='password']")).sendKeys("pikachu1");
	driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/button[@class='btn']")).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.titleIs("Strona Główna - Logo"));
	driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='mod']/a[@id='mod-dropdown-toggle']")).click();
	driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='mod']/div[@id='mod-dropdown']/a[@class='dropdown-item'][3]")).click();
	wait.until(ExpectedConditions.titleIs("Strona Główna - Panel Administracyjny Logo"));
	String actual = driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/h2")).getText();
	assertEquals("Witaj w panelu administratora", actual);
	}
	
	
	
	

	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
}
