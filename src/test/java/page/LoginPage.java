package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Name;
import java.nio.charset.StandardCharsets;


public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "username")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "p:nth-child(3) button")
    private WebElement clickLogin;
    @FindBy(id = "user_login")
    private WebElement resetpassemail;
    @FindBy(id = "reg_password")
    private WebElement passregister;
    @FindBy(css = "p.woocommerce-LostPassword.lost_password > a")
    private WebElement clickLostyourpassword;
    @FindBy(css = "p:nth-child(1) > a")
    private WebElement clickLogout;
    @FindBy(css = "p.woocommerce-FormRow.form-row > button")
    private WebElement clickregister;
    public void setClickregister()
    { clickregister.click(); }
    public void setClickLogout(){
        clickLogout.click();
    }
   public void setClickLostyourpassword(){
       clickLostyourpassword.click();
   }
    public void setEmailField(String email){
        emailField.sendKeys(email);
    }
    public void setPasswordField(String password){
        passwordField.sendKeys(password);
}
    public void setClickLogin(){
        clickLogin.click();
    }
    public void setemailresetpass(String emailresetpass){
        resetpassemail.sendKeys(emailresetpass);
    }
    public void setPassregister(String passwordregister){
        passregister.sendKeys(passwordregister);
    }

    }

















