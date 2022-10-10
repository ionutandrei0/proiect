package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import page.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartTest  {



    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private Basepage basepage;
    private CartPage cartPage;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        basepage = new Basepage(driver);
        driver.get("http://qa4.fasttrackit.org:8008/");
    }
    @Test
    public void emptyCart(){
        driver.findElement(By.cssSelector("[class=\"cart-contents\"]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("[class=\"cart-empty\"]")).getText().toString(),"Your cart is currently empty.");
    }
     @Test
     public void addtocart(){
        homePage.shopclick();
        driver.findElement(By.cssSelector("[data-product_sku=\"woo-album\"]")).click();
        basepage.wait(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("[class=\"cart-item-number\"]")).getText().toString(),"1");
    }
    @Test
    public void removeitemcart(){
        homePage.shopclick();
        driver.findElement(By.cssSelector("[data-product_sku=\"woo-album\"]")).click();
        basepage.wait(2);
        driver.findElement(By.cssSelector("[class=\"cart-contents\"]")).click();
        driver.findElement(By.cssSelector("#post-118 td.product-remove > a")).click();
        basepage.wait(1);
        Assert.assertEquals(driver.findElement(By.cssSelector("span.cart-item-number")).getText(),"0");
    }
    @Test
    public void order() {
        homePage.shopclick();
        driver.findElement(By.cssSelector("[data-product_sku=\"woo-album\"]")).click();
        basepage.wait(1);
        driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
        driver.findElement(By.cssSelector("#post-118 div > a")).click();
        cartPage.setFarstname("Eugen");
        cartPage.setLastname("Andrei");
        cartPage.setSetaddresname("acsa");
        cartPage.setnumberaddres("36");
        cartPage.setCity("Oradea");
        cartPage.setSetpostcode("7002555");
        cartPage.setPhonenumber("0780000000");
        cartPage.setEmail("andrei@yahoo.com");
        basepage.wait(1);
        cartPage.buttonorder();
        basepage.wait(4 );
        WebElement searchText = driver.findElement(By.cssSelector("p.woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received"));
        Assert.assertEquals("Thank you. Your order has been received.",searchText.getText());
    }
    @Test
    public void quantitychangeitem(){
        homePage.shopclick();
        driver.findElement(By.cssSelector("li > a[href=\"/?post_type=product&add-to-cart=48\"]")).click();
        basepage.wait(5);
        driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
        driver.findElement(By.cssSelector("div.quantity > input")).clear();
        driver.findElement(By.cssSelector("div.quantity > input")).sendKeys("2");
        driver.findElement(By.cssSelector("[name=\"update_cart\"]")).click();
        basepage.wait(2);
       WebElement searchText = driver.findElement(By.cssSelector("div.woocommerce-message"));
        Assert.assertEquals("Cart updated.",searchText.getText());

    }

    @Test
    public void shippingChange() {
        homePage.shopclick();
        driver.findElement(By.cssSelector("li > a[href=\"/?post_type=product&add-to-cart=48\"]")).click();
        basepage.wait(5);
        driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
        driver.findElement(By.cssSelector(".shipping-calculator-button")).click();
        basepage.wait(5);
        driver.findElement(By.cssSelector("[name=\"calc_shipping\"]")).click();
        basepage.wait(2);
        Assert.assertFalse(driver.findElement(By.cssSelector("[name=\"calc_shipping\"]")).isDisplayed());
    }
    @Test
    public void invalidCoupon() {
        homePage.shopclick();
        driver.findElement(By.cssSelector("li > a[href=\"/?post_type=product&add-to-cart=48\"]")).click();
        basepage.wait(5);
        driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
        driver.findElement(By.cssSelector("[name=\"coupon_code\"]")).clear();
        driver.findElement(By.cssSelector("[name=\"coupon_code\"]")).sendKeys("testcoupon");
        driver.findElement(By.cssSelector("[name=\"apply_coupon\"]")).click();
        basepage.wait(2);
        WebElement searchText = driver.findElement(By.cssSelector("[class=\"woocommerce-error\"]"));
        Assert.assertEquals("Coupon \"testcoupon\" does not exist!", searchText.getText());
    }
    @Test
    public void emptyCoupon() {
        homePage.shopclick();
        driver.findElement(By.cssSelector("li > a[href=\"/?post_type=product&add-to-cart=48\"]")).click();
        basepage.wait(5);
        driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
        driver.findElement(By.cssSelector("[name=\"coupon_code\"]")).clear();
        driver.findElement(By.cssSelector("[name=\"apply_coupon\"]")).click();
        basepage.wait(2);
        WebElement searchText = driver.findElement(By.cssSelector("[class=\"woocommerce-error\"]"));
        Assert.assertEquals("Please enter a coupon code.", searchText.getText());
    }

    @Test
    public void buttonReturntoShop(){
        cartPage.setClickcart();
        driver.findElement(By.cssSelector("p.return-to-shop>a")).click();
        WebElement searchText = driver.findElement(By.cssSelector("#primary > header > h1"));
        Assert.assertEquals("SHOP", searchText.getText());


    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}




















