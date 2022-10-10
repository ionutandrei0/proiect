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

public class LoginTest  {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;


    String email = "ungureanu_ionut_andrei@yahoo.com";



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
    public void loginValid() {
        homePage.setClickMyaccount();
        loginPage.setEmailField(email);
        loginPage.setPasswordField("@acasa@123");
        loginPage.setClickLogin();
        WebElement loginText = driver.findElement(By.cssSelector(" p:nth-child(1) a "));
        Assert.assertEquals("Log out", loginText.getText());
    }
    @Test
    public void validLoginUpperCaseEmail() {
        homePage.setClickMyaccount();
        loginPage.setEmailField(email.toUpperCase());
        loginPage.setPasswordField("@acasa@123");
        loginPage.setClickLogin();
        WebElement loginText = driver.findElement(By.cssSelector("p:nth-child(1) a"));
        Assert.assertEquals("Log out", loginText.getText());
    }
    @Test
    public void Resetpassword() {
        homePage.setClickMyaccount();
        loginPage.setClickLostyourpassword();
        loginPage.setemailresetpass("ungureanu_ionut_andrei@yahoo.com");
        driver.findElement(By.cssSelector("p:nth-child(4) > button")).click();
        WebElement resetpasswordText = driver.findElement(By.cssSelector("#post-120 > header > h1"));
        Assert.assertEquals("LOST PASSWORD", resetpasswordText.getText());
    }
    @After
    public void closeDriver() {
        driver.quit();
    }



}
