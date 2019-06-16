import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import PageObject.PageObjectPromotionCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTest {
	
	private static WebDriver driver;
	private PageObjectPromotionCatalog foodPage;
	@BeforeAll
	public static void setupClass() {
		WebDriverManager.firefoxdriver().setup();
	}

	@BeforeEach
	public void setupTest() {
		driver = new FirefoxDriver();
		foodPage = PageFactory.initElements(driver, PageObjectPromotionCatalog.class);
	}

	@AfterEach
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void addProductSuccess() throws Exception {
		foodPage.addProduct("test", "10");
		String actual = driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='header']/h2")).getText();
		assertEquals("Domeny", actual);
		//Assert.assertEquals("Food Catalog", driver.getTitle());
	}



	@Test
	public void editdomena2() throws Exception {
		foodPage.addProduct("xxx","xxx");
		foodPage.wyloguj();
		foodPage.editDomena("xxx","xxxx");

	//	String actual = driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='header']/h2")).getText();

		String actual = driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='header']/h2")).getText();
		assertEquals("Domeny", actual);
	}
	
	
	
	
	
	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
}