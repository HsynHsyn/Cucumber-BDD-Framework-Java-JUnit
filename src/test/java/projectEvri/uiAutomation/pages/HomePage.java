package projectEvri.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the Home Page of the application.
 * This class contains web elements specific to the home page functionality
 * and extends the CommonPageElements class to inherit shared page elements.
 */
public class HomePage extends CommonPageElements {

    @FindBy(id = "gdpr-banner-accept")
    public WebElement acceptAllButton;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchButton;


}
