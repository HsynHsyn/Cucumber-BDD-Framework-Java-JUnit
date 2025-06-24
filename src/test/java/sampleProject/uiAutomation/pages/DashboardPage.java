package sampleProject.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class extends CommonPageElements to inherit shared web elements and functionality.
 */
public class DashboardPage extends CommonPageElements{

    @FindBy(xpath = "//*[@data-test-id='destination-choice-select-control']")
    public WebElement destinationCountryArea;

    @FindBy(xpath = "(//*[@data-test-id='input'])[1]")
    public WebElement fromPostcodeArea;

    @FindBy(xpath = "(//*[@data-test-id='input'])[2]")
    public WebElement toPostcodeArea;

    @FindBy(xpath = "//select[@data-test-id='weight-choice-select-control']")
    public WebElement weightChoice;

    @FindBy(xpath = "//button[@data-test-id='e-button' and @aria-label='Get a price']")
    public WebElement sendParcelButton;

    @FindBy(xpath = "//*[@data-test-id='page-title']")
    public WebElement deliveryOptions;

    @FindBy(css = "#standrd-size")
    public WebElement standardParcelSelectButton;

    @FindBy(css = "#standard-speed")
    public WebElement SpeedStandartSelectButton;

    @FindBy(css = "#parcelshop-method")
    public WebElement parcelShopDropOffSelectButton;

    @FindBy(css = "#parcelshop-method")
    public WebElement homeBusinessAddressSelectButton;

    @FindBy(xpath = "(//span[@data-test-id='e-button-text'])[1]")
    public WebElement continueButton;

    @FindBy(xpath = "//h2[@class='send-card__title']")
    public WebElement parcelDetails;

    @FindBy(xpath = "//input[@data-test-id='parcel-contents-input']")
    public WebElement parcelContentsInput;

    /**
    * Where's it going? page webElements
    */
    @FindBy(xpath = "//input[@data-test-id='parcel-value-input']")
    public WebElement priceInput;

    @FindBy(xpath = "//h1[@data-test-id='page-title']")
    public WebElement whereIsItGoingText;

    @FindBy(css = "input[data-test-id='first-name-input']")
    public WebElement receiptFirstNameInput;

    @FindBy(css = "input[data-test-id='last-name-input']")
    public WebElement receiptLastNameInput;

    @FindBy(css = "input[data-test-id='address-lookup-postcode']")
    public WebElement receiptPostCodeInput;

    @FindBy(css = "input[data-test-id='email-input']")
    public WebElement receiptEmailInput;

    @FindBy(xpath = "//option[@disabled and text()='Select an address']")
    public WebElement receiptAddressSelectButton;

    @FindBy(xpath = "//option[@data-test-id='recipient-address-lookup-dropdown-select-option-1']")
    public WebElement receiptAddressOption;

    @FindBy(xpath = "//button[text()=' Enter address manually ']")
    public WebElement enterAddressManuallyButton;

    @FindBy(xpath = "//input[@id='address line 1' and @data-test-id='address-lookup-input-addressLine1']")
    public WebElement addressLine1Input;

    @FindBy(xpath = "//h1[@data-test-id='page-title' and text()='Your details']")
    public WebElement yourDetailsText;

    /**
     * Your details page webElements
     */

    @FindBy(css = "input[data-test-id='first-name-input']")
    public WebElement yourFirstNameInput;

    @FindBy(css = "input[data-test-id='last-name-input']")
    public WebElement yourLastNameInput;

    @FindBy(css = "input[data-test-id='email-input']")
    public WebElement yourEmailInput;

    @FindBy(css = "input[data-test-id='phone-input']")
    public WebElement yourPhoneNumberInput;

    @FindBy(css = "input[data-test-id='address-lookup-postcode']")
    public WebElement senderPostCodeInput;

    @FindBy(xpath = "(//span[@data-test-id='e-button-text'])[1]")
    public WebElement addToBasketButton;

    /**
     * Basket page webElements
     */
    @FindBy(css = "h1.header__title")
    public WebElement basketText;

    @FindBy(css = "label.terms-and-conditions__input-label")
    public WebElement termsAndConditionsCheckBoxButton;

    @FindBy(xpath = "(//span[@data-test-id='e-button-text'])[2]")
    public WebElement continueToPaymentButton;

    @FindBy(css = "h1.header__title")
    public WebElement checkoutText;













}
