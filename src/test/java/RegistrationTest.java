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

public class RegistrationTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() throws Exception {
        System.setProperty("webdriver.ie.driver", "E:\\" + "selenium-firefox-driver-3.12.0");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void registrationfailclear() {
        driver.get("https://dealsqwerty.000webhostapp.com/register.php");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='register-container']/form[@id='registerForm']/div[@class='form-group'][1]/input[@id='login']")).sendKeys("pikachu");
        driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='register-container']/form[@id='registerForm']/div[@class='form-group'][2]/input[@id='email']")).sendKeys("test3@o2.pl");
        driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='register-container']/form[@id='registerForm']/div[@class='form-group'][3]/input[@id='password']")).sendKeys("test3");
        driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='register-container']/form[@id='registerForm']/button[@class='btn']")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.titleIs("Zarejestruj się - Logo"));
        String actual = driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='register-container']/form[@id='registerForm']/div[@class='form-group'][1]/input[@id='login']")).getText();
        assertEquals("", actual);
    }


    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
	