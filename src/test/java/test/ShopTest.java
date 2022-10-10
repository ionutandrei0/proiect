package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import page.Basepage;

import page.HomePage;
import page.LoginPage;

public class ShopTest  {
    private WebDriver driver;
    private Basepage basepage;
    private HomePage homePage;
    private LoginPage loginPage;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        basepage = new Basepage(driver);
        driver.get("http://qa4.fasttrackit.org:8008/");
    }
     @Test
     public void Reviewsitems(){
        homePage.setSearchtext("BEANIE");
        homePage.setSearchclick();
        driver.findElement(By.cssSelector("#post-48 > header > h1 > a")).click();
        driver.findElement(By.cssSelector("#tab-title-reviews > a")).click();
        driver.findElement(By.cssSelector("#commentform > div > p > span > a.star-5")).click();
       driver.findElement(By.id("comment")).click();
        driver.findElement(By.id("comment")).sendKeys(basepage.randomChars(12));
        driver.findElement(By.id("author")).sendKeys("Andrei");
        driver.findElement(By.id("email")).sendKeys("andreiandrei@yahoo.com");
        driver.findElement(By.id("submit")).click();
        basepage.wait(2);
         WebElement ReviewsText = driver.findElement(By.cssSelector("#reply-title"));
         Assert.assertEquals("Add a review",ReviewsText.getText());
     }
     @Test
     public void changeDropdownselecitem(){
         homePage.shopclick();
         Select dropdownselecitem = new Select(driver.findElement(By.cssSelector("#primary > form > select")));
         dropdownselecitem.selectByVisibleText("Sort by price: low to high");
     }
     @Test
    public void saleExists(){
        homePage.shopclick();
        Assert.assertTrue(driver.findElements(By.cssSelector(".onsale")).size()!=0);
     }
    @After
    public void closeDriver() {
        driver.quit();
    }

    }
