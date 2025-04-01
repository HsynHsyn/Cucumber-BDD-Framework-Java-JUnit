package projectEvri.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectEvri.uiAutomation.utilities.Driver;

/**
 * Abstract base class for page objects that contains common web elements shared across multiple pages.
 * This class extends the Driver class to have access to the WebDriver instance.
 */
public abstract class CommonPageElements extends Driver {

    //Initializes web elements using PageFactory
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "about")
    public WebElement aboutUsButton;

}
