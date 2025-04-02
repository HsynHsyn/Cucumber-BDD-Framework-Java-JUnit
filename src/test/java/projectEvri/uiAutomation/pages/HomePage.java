package projectEvri.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

//============================================
    @FindBy(id = "gdpr-banner-accept")
    public WebElement acceptAllButton;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchButton;

//============================================



    public void login(){
        this.loginButtonTop.click();
        this.emailAddress.sendKeys(System.getenv("EVRIEMAIL"));
        this.password.sendKeys(System.getenv("EVRIPASSWORD"));
        this.loginButtonSubmit.click();
    }


}
