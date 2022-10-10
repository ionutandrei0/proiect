package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#menu-item-124 > a")
    private WebElement clickcart;
    @FindBy(id = "place_order")
    private WebElement addplaceorder;
    @FindBy(id = "billing_email")
    private WebElement addemail;
    @FindBy(id = "billing_phone")
    private WebElement addphonenumber;
    @FindBy(id = "billing_postcode")
    private WebElement Setpostcode;
    @FindBy(id = "billing_city")
    private WebElement billingcity;
    @FindBy(id = "billing_first_name")
    private WebElement firstnameset;
    @FindBy(id = "billing_last_name")
    private WebElement lastnameset;
    @FindBy(id = "billing_address_1")
    private WebElement setaddresname;
    @FindBy(id = "billing_address_2")
    private WebElement setaddresnumber;
    public void setClickcart(){clickcart.click();}
    public void buttonorder(){addplaceorder.click();}
    public void setEmail(String email){
        addemail.sendKeys(email);
    }
    public void setPhonenumber(String phone_number){
        addphonenumber.sendKeys(phone_number);
    }
    public void setSetpostcode(String post_code){
        Setpostcode.sendKeys(post_code);
    }
    public void setCity(String city){billingcity.sendKeys(city);}
    public void setnumberaddres(String nr_addres){setaddresnumber.sendKeys(nr_addres);}
    public void setFarstname(String first_name){firstnameset.sendKeys(first_name);}
    public void setLastname(String last_name){lastnameset.sendKeys(last_name);}
    public void setSetaddresname(String addres_name){setaddresname.sendKeys(addres_name);}
}
