package projectEvri.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import projectEvri.uiAutomation.utilities.ConfigurationReader;

/**
 * Represents the Home Page of the application.
 * This class contains web elements specific to the home page functionality
 * and extends the CommonPageElements class to inherit shared page elements.
 */
public class HomePage extends CommonPageElements {

    @FindBy(css = "input[id='1-email']")
    public WebElement emailAddress;

    @FindBy(css = "input[name='password']")
    public WebElement password;

    @FindBy(css = "button[name='submit']")
    public WebElement loginButtonSubmit;

    @FindBy(css = "button#onetrust-reject-all-handler")
    public WebElement cookieRejectButton;




    public void login(){
        this.loginButtonTop.click();
        //this.emailAddress.sendKeys(System.getenv("EVRIEMAIL"));
        //this.password.sendKeys(System.getenv("EVRIPASSWORD"));
        this.emailAddress.sendKeys(ConfigurationReader.get("email"));
        this.password.sendKeys(ConfigurationReader.get("password"));
        this.loginButtonSubmit.click();
    }


}
