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

public class SearchTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() throws Exception {
        //Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
        //NaleĹĽy dodaÄ‡ sterownik geckodriver
        //Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
        //	System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        //System.setProperty("webdriver.gecko.driver", "resources/IEDriverServer");
        System.setProperty("webdriver.ie.driver", "E:\\" + "selenium-firefox-driver-3.12.0");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testClick() {
        driver.get("https://dealsqwerty.000webhostapp.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/div[@class='primary-nav-search']/form[@id='searchForm']/button[@class='search-action']")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.titleIs("Strona Główna - Logo"));
        assertEquals("Strona Główna - Logo", driver.getTitle());
    }

    @Test
    public void testSearchFail() {
        driver.get("https://dealsqwerty.000webhostapp.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/div[@class='primary-nav-search']/form[@id='searchForm']/input[@id='search-query']")).sendKeys("kardioafaga");
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/div[@class='primary-nav-search']/form[@id='searchForm']/input[@id='search-query']")).submit();
        wait.until(ExpectedConditions.titleIs("Strona Główna - Logo"));
        //driver.get("https://dealsqwerty.000webhostapp.com/?search=kardioafa");
        String actual = driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='container']/div[@class='result-holder']/div[@class='no-results']/span[@class='emoji']")).getText();
        assertEquals("(╯°□°)╯︵ ┻━┻", actual);
    }


    @Test
    public void testSearchSuccess() {
        driver.get("https://dealsqwerty.000webhostapp.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/div[@class='primary-nav-search']/form[@id='searchForm']/input[@id='search-query']")).sendKeys("fruit");
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/div[@class='primary-nav-search']/form[@id='searchForm']/input[@id='search-query']")).submit();
        wait.until(ExpectedConditions.titleIs("Strona Główna - Logo"));
        String actual = driver.findElement(By.xpath("/html/body/div[@class='content']/div[@class='container']/div[@class='result-holder']/div[@class='result-toolbar'][1]/div[@class='pagination']/span")).getText();
        assertEquals("1", actual);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
