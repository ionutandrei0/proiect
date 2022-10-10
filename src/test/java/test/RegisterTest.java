package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Basepage;
import page.HomePage;
import page.LoginPage;

public class RegisterTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private Basepage basepage;


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

    //@Test
    //public void firstaccountregister(){
    // homePage.setClickMyaccount();
    // homePage.setRegisteremail("ungureanu_ionut_andrei@yahoo.com");
    //loginPage.setPassregister("@acasa@12");
    //wait(2);
    //loginPage.setPassregister("3");
    //loginPage.setClickregister();
//}
    @Test
    public void duplicateregistrationaccount() {
        homePage.setClickMyaccount();
        homePage.setRegisteremail("ungureanu_ionut_andrei@yahoo.com");
        loginPage.setPassregister("@acasa@12");
        basepage.wait(2);
        loginPage.setPassregister("3");
        loginPage.setClickregister();
        WebElement registerText = driver.findElement(By.cssSelector("#post-120 ul >li"));
        Assert.assertEquals("Error: An account is already registered with your email address. Please log in.", registerText.getText());
    }
    @Test
    public void alredyRegistered() {
        homePage.setClickMyaccount();
        homePage.setRegisteremail(basepage.randomChars(12) + "@yahoo.com");
        loginPage.setPassregister(basepage.randomChars(10));
        basepage.wait(2);
        loginPage.setPassregister("@");
        driver.findElement(By.cssSelector("p.woocommerce-FormRow.form-row > button")).click();
        WebElement registerText = driver.findElement(By.cssSelector("p:nth-child(1) > a"));
        Assert.assertEquals("Log out", registerText.getText());
    }
    @After
    public void closeDriver() {
        driver.quit();
    }


}




