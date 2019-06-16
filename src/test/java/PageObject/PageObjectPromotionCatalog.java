package PageObject;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageObjectPromotionCatalog {
    public WebDriver driver;
    private WebDriverWait wait;
    public PageObjectPromotionCatalog(WebDriver driver){
        this.driver = driver;
        driver.get("https://dealsqwerty.000webhostapp.com/login.php");
        wait = new WebDriverWait(driver, 10);
    }

    public void addProduct(String text, String text2) throws Exception{
      //  driver.get("https://dealsqwerty.000webhostapp.com/login.php");
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
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='header']/a[@class='btn btn-success']")).click();
        wait.until(ExpectedConditions.titleIs("Dodaj domenę - Panel Administracyjny Logo"));
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][1]/div[@class='col-sm-10']/input[@id='input1']")).sendKeys(text);
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][2]/div[@class='col-sm-10']/input[@id='input1']")).sendKeys(text2);
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/input[@class='btn btn-primary']")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.titleIs("Domeny - Panel Administracyjny Logo"));

    }

    public void editDomena(String text, String text2) throws Exception{
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
        List<WebElement> cardItems = driver.findElements(By.cssSelector(".glyphicon"));
        cardItems.get(cardItems.size()-2).click();
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][1]/div[@class='col-sm-10']/input[@id='input1']")).clear();
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][2]/div[@class='col-sm-10']/input[@id='input1']")).clear();
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][1]/div[@class='col-sm-10']/input[@id='input1']")).sendKeys(text);
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][2]/div[@class='col-sm-10']/input[@id='input1']")).sendKeys(text2);
        driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/input[@class='btn btn-primary']")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.titleIs("Domeny - Panel Administracyjny Logo"));
        //System.out.println(cardItems.size());
       // cardItems.get(cardItems.size()-1).click();
       // driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/div[@class='form-group'][2]/div[@class='col-sm-10']/input[@id='input1']")).sendKeys("coscos");
        //driver.findElement(By.xpath("/html/body/div[@class='wrapper']/div[@class='content']/div[@class='row']/form[@class='form-horizontal col-md-6 col-md-offset-3']/input[@class='btn btn-primary']")).sendKeys(Keys.ENTER);
       // wait.until(ExpectedConditions.titleIs("Domeny - Panel Administracyjny Logo"));

    }
    public void wyloguj()throws Exception{
        driver.get("https://dealsqwerty.000webhostapp.com/login.php");
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='user']/a[@id='user-dropdown-toggle']")).click();
        driver.findElement(By.xpath("/html/body/nav[@class='primary-nav']/div[@class='container']/ul[@class='primary-nav-actions']/li[@class='user']/div[@id='user-dropdown']/a[@class='dropdown-item'][3]")).click();
    }


}
