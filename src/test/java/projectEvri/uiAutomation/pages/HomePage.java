package projectEvri.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPageElements {

    @FindBy(id = "gdpr-banner-accept")
    public WebElement acceptAllButton;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchButton;


}
