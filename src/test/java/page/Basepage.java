package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {

    public WebDriver driver;
    public Basepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   public static String randomChars(int n) {

       String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
               + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

           sb.append(AlphaNumericString
                    .charAt(index));
       }

       return sb.toString();
    }
}



