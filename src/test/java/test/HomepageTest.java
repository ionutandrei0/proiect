package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.LoginPage;

public class HomepageTest {
    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;



    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get("http://qa4.fasttrackit.org:8008/");
    }
    @Test
    public void buttonhomepage() {
        homePage.shopclick();
        WebElement searchText = driver.findElement(By.cssSelector("header >h1"));
        Assert.assertEquals("SHOP", searchText.getText());

    }
    @Test
    public void searchtest() {
        homePage.setSearchtext("BEANIE");
        homePage.setSearchclick();
        WebElement searchText = driver.findElement(By.cssSelector(" header>h1>a"));
        Assert.assertEquals("BEANIE WITH LOGO", searchText.getText());
    }
    @After
    public void closeDriver() {
        driver.quit();
    }

}