package projectEvri.uiAutomation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import projectEvri.uiAutomation.utilities.CommonUISteps;
import projectEvri.uiAutomation.utilities.ConfigurationReader;


public class EbayStepDefs extends CommonUISteps {

    @Given("the user goes to ebay website")
    public void theUserGoesToEbayWebsite() {
        driver.get(ConfigurationReader.get("ebayUrl"));
        try{
            waitFor(3);
            clickWithJS(homePage.acceptAllButton);
        }catch (Exception e){
        }

    }

    @When("the user searches for {string} item")
    public void theUserSearchesForItem(String string) {
        homePage.searchButton.sendKeys(string, Keys.ENTER);
        //homePage.searchButton.click();
    }
}
