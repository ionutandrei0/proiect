package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#menu-item-122 > a")
    private WebElement clickMyaccount;
    public void setClickMyaccount() {
        clickMyaccount.click();
    }
    @FindBy(id = "reg_email")
    private WebElement emailregisterfield;
    public void setRegisteremail(String email){
        emailregisterfield.sendKeys(email);
    }

     @FindBy(css = "#menu-item-123 > a")
     private WebElement setclickshop;
     public void shopclick(){
        setclickshop.click();
    }
     @FindBy(css = "#search-2 > form > label > input")
     private WebElement searchtext;
     public void setSearchtext(String text){
         searchtext.sendKeys(text);
     }

     @FindBy(css = "#search-2 > form > input")
    private WebElement searchclick;
     public void setSearchclick(){
         searchclick.click();
     }




}