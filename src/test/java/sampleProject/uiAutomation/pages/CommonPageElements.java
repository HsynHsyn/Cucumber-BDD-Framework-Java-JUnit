package sampleProject.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sampleProject.uiAutomation.utilities.Driver;

/**
 * Abstract base class for page objects that contains common web elements shared across multiple pages.
 * This class extends the Driver class to have access to the WebDriver instance.
 */
public abstract class CommonPageElements extends Driver {

    //Initializes web elements using PageFactory
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-test-id='login-button-top']")
    public WebElement loginButtonTop;

    @FindBy(xpath = "//button[@data-test-id='signup-button-top']")
    public WebElement signUpButtonTop;

    @FindBy(css = "button[aria-label='expand Send menu']")
    public WebElement sendButtonTop;

    @FindBy(css = "button[aria-label='expand Track menu']")
    public WebElement trackButtonTop;

    @FindBy(css = "button[aria-label='expand Return menu']")
    public WebElement returnButtonTop;

    @FindBy(xpath = "//button[contains(text(), 'Our Services')]")
    public WebElement ourServicesButtonTop;

    @FindBy(xpath = "//button[contains(text(), 'ParcelShops')]")
    public WebElement parcelShopsButtonTop;

    @FindBy(xpath = "//button[contains(text(), 'Careers')]")
    public WebElement careersButtonTop;

    @FindBy(xpath = "//button[contains(text(), 'Help')]")
    public WebElement helpButtonTop;







}
