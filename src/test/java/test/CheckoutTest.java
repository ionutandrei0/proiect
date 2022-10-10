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

public class CheckoutTest {
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
    public void LogoutTest() {
        homePage.setClickMyaccount();
        loginPage.setEmailField("ungureanu_ionut_andrei@yahoo.com");
        loginPage.setPasswordField("@acasa@123");
        loginPage.setClickLogin();
        loginPage.setClickLogout();
        WebElement LogoutText = driver.findElement(By.cssSelector("div.u-column1.col-1>h2"));
        Assert.assertEquals("Login", LogoutText.getText());
    }
    @After
    public void closeDriver() {
        driver.quit();
    }


}