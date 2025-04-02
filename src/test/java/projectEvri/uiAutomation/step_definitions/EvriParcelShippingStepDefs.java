package projectEvri.uiAutomation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectEvri.uiAutomation.utilities.CommonUISteps;
import projectEvri.uiAutomation.utilities.ConfigurationReader;
import projectEvri.uiAutomation.utilities.Log;

import static org.junit.Assert.assertEquals;

public class EvriParcelShippingStepDefs extends CommonUISteps {

    public String parcelContent;

    @Given("user logged into the Evri Company webpage and landed on the home page")
    public void user_logged_into_the_evri_company_webpage_and_landed_on_the_home_page() {

        driver.navigate().to(ConfigurationReader.get("evriUrl"));
        Log.info("Navigated to " + ConfigurationReader.get("evriUrl"));
        //driver.get(ConfigurationReader.get("evriUrl"));
        homePage.cookieRejectButton.click();
        homePage.login();
    }

    @When("user enters {string}, {string} and selects {string}")
    public void user_enters_and_selects(String fromPostcode, String toPostcode, String weight) {
        waitFor(2);
        dashboardPage.fromPostcodeArea.sendKeys(fromPostcode);
        dashboardPage.toPostcodeArea.sendKeys(toPostcode);
        dashboardPage.weightChoice.sendKeys(weight);
    }

    @When("user clicks on the Send a parcel button")
    public void user_clicks_on_the_button() {

        dashboardPage.sendParcelButton.click();
    }

    @Then("user proceeds to the Delivery Options page")
    public void user_proceeds_to_the_delivery_options_page() {

        verifyElementDisplayed(dashboardPage.deliveryOptions);
    }

    @Given("user selects Parcel size as Standard parcel")
    public void user_selects_parcel_size_as_standard_parcel() {

        dashboardPage.standardParcelSelectButton.click();
    }

    @Given("user selects Delivery speed as Standard")
    public void user_selects_delivery_speed_as_standard() {

        dashboardPage.SpeedStandartSelectButton.click();
    }

    @Given("user selects Drop off or collection as the drop-off or collection")
    public void user_selects_drop_off_or_collection_as_the_drop_off_or_collection() {

        dashboardPage.parcelShopDropOffSelectButton.click();
    }

    @When("user selects Parcel delivery location Deliver to a ParcelShop")
    public void user_selects_parcel_delivery_location_deliver_to_a_parcel_shop() {

        dashboardPage.homeBusinessAddressSelectButton.click();
    }

    @When("user clicks on the Continue button")
    public void user_clicks_on_the_continue_button() {
        waitFor(2);
        dashboardPage.continueButton.click();
    }

    @Then("user proceeds to the What's in it? page")
    public void user_proceeds_to_the_what_s_in_it_page() {

        verifyElementDisplayed(dashboardPage.parcelDetails);
    }

    @When("user enters {string} into the Parcel contents area")
    public void user_enters_into_the_parcel_contents_area(String parcelContent) {

        this.parcelContent = parcelContent;
        dashboardPage.parcelContentsInput.sendKeys(parcelContent);
    }
    @When("user enters {string} into the How much is it worth? area")
    public void user_enters_into_the_how_much_is_it_worth_area(String price) {

        dashboardPage.priceInput.sendKeys(price);
    }
    @Then("user proceeds to the Where's it going? page")
    public void user_proceeds_to_the_where_s_it_going_page() {

        verifyElementDisplayed(dashboardPage.whereIsItGoingText);
    }

    @When("user enters recipient details {string}, {string}")
    public void user_enters_recipient_details(String recipientFirstName, String recipientLastName) {

        dashboardPage.receiptFirstNameInput.sendKeys(recipientFirstName);
        dashboardPage.receiptLastNameInput.sendKeys(recipientLastName);
    }
    @When("user enters recipient address {string}, {string}")
    public void user_enters_recipient_address(String addressLine, String toPostcode) {

        dashboardPage.enterAddressManuallyButton.click();
        dashboardPage.addressLine1Input.sendKeys(addressLine);
        dashboardPage.receiptPostCodeInput.clear();
        dashboardPage.receiptPostCodeInput.sendKeys(toPostcode);
    }

    @Then("user proceeds to the Your details page")
    public void user_proceeds_to_the_your_details_page() {
        verifyElementDisplayed(dashboardPage.yourDetailsText);

    }

    @When("user enters sender first name {string}, last name {string}, email {string}, phone {string}")
    public void user_enters_sender_name_last_name_email_phone(String firstName, String lastName, String email, String phone) {

        dashboardPage.yourFirstNameInput.clear();
        dashboardPage.yourFirstNameInput.sendKeys(firstName);

        dashboardPage.yourLastNameInput.clear();
        dashboardPage.yourLastNameInput.sendKeys(lastName);

        dashboardPage.yourEmailInput.clear();
        dashboardPage.yourEmailInput.sendKeys(email);
        dashboardPage.yourPhoneNumberInput.sendKeys(phone);
    }
    @When("user enters return address {string}, {string}")
    public void user_enters_return_address(String postcode, String address) {

        dashboardPage.enterAddressManuallyButton.click();
        dashboardPage.addressLine1Input.sendKeys(address);
        dashboardPage.senderPostCodeInput.sendKeys(postcode);

    }
    @Then("user clicks on the Add to Basket button")
    public void user_clicks_on_the_add_to_basket_button() {
        waitFor(2);
        dashboardPage.addToBasketButton.click();
    }

    @Then("user proceeds to the Basket page")
    public void user_proceeds_to_the_basket_page() {

        verifyElementDisplayed(dashboardPage.basketText);
    }
    @Then("user should see parcel content name {string} on the Basket page")
    public void user_should_see_parcel_content_name_on_the_basket_page(String parcelContent) {
        assertEquals(this.parcelContent,parcelContent);

    }

    @When("user clicks on the terms and conditions checkbox")
    public void user_clicks_on_the_terms_and_conditions_checkbox() {
        dashboardPage.termsAndConditionsCheckBoxButton.click();

    }
    @When("user clicks on the Continue to payment button")
    public void user_clicks_on_the_continue_to_payment_button() {
        dashboardPage.continueToPaymentButton.click();

    }
    @Then("user proceeds to Checkout page")
    public void user_proceeds_to_checkout_page() {

        verifyElementDisplayed(dashboardPage.checkoutText);
    }

}