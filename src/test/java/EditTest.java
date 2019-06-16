import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditTest {
	
	private static WebDriver driver;

	@BeforeAll
	public static void setUp() throws Exception {
		 System.setProperty("webdriver.ie.driver","E:\\" + "selenium-firefox-driver-3.12.0");
		 driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test
	public void editdomena(){
	driver.get("https://dealsqwerty.000webhostapp.com/login.php");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][1]/input[@id='login']")).sendKeys("pikachu");
	driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/div[@class='form-group'][2]/input[@id='password']")).sendKeys("pikachu1");
	driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='login-container']/form[@id='loginForm']/button[@class='btn']")).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.titleIs("Strona Główna - Logo"));
	driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='mod']/a[@id='mod-dropdown-toggle']")).click();
	driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='mod']/div[@id='mod-dropdown']/a[@class='dropdown-item'][3]")).click();
	wait.until(ExpectedConditions.titleIs("Strona Główna - Panel Administracyjny Logo"));
	driver.findElement(By.xpath("/html/body/div[@class='wrapper']/nav[@class='navbar navbar-default sidebar']/div[@class='container-fluid']/div[@id='bs-sidebar-navbar-collapse-1']/ul[@class='nav navbar-nav']/li[5]/a")).click();
	wait.until(ExpectedConditions.titleIs("Domeny - Panel Administracyjny Logo"));
	driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/table[@class='table table-bordered table-striped']/tbody/tr[12]/td[5]/center/a[1]/span[@class='glyphicon glyphicon-pencil']")).click();
	wait.until(ExpectedConditions.titleIs("Edytuj domenę - Panel Administracyjny Logo"));
driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][2]/div[@class='col-sm-10']/input[@id='input1']")).sendKeys("coscos");
	driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/input[@class='btn btn-primary']")).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.titleIs("Domeny - Panel Administracyjny Logo"));
	String actual = driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='header']/h2")).getText();
	assertEquals("Domeny", actual);
	}


	@Test
	public void editdomena2(){

		String actual = driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='header']/h2")).getText();
		assertEquals("Domeny", actual);
	}
	
	
	
	
	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
}