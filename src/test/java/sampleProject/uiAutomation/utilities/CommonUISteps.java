package sampleProject.uiAutomation.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import sampleProject.uiAutomation.pages.PageInitializer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonUISteps extends PageInitializer {

    /**
     * Clicks on the specified WebElement after waiting for it to be clickable.
     * @param element The WebElement to be clicked.
     */
    public static void click(WebElement element) {
        waitForClickability(element, 10);
        element.click();
    }

    /**
     * Clicks on the specified WebElement using Actions after waiting for it to be clickable.
     * @param element The WebElement to be clicked.
     */
    public static void clickWithActions(WebElement element) {
        waitForClickability(element,10);
        actions.click(element).build().perform();
    }

    /**
     * Clicks on the specified WebElement using JavaScript.
     * @param element The WebElement to be clicked.
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Clicks on the specified WebElement with a timeout.
     * @param element The WebElement to be clicked.
     * @param timeout The timeout in seconds.
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            if (element.isDisplayed()){
                element.click();
                break;
            }else{
                waitFor(1);
            }
        }
    }

    /**
     * Double clicks on the specified WebElement using Actions.
     * @param element The WebElement to be double-clicked.
     */
    public static void doubleClickWithActions(WebElement element) {
        waitForClickability(element,10);
        actions.doubleClick(element).build().perform();
    }

    /**
     * Right clicks on the specified WebElement using Actions.
     * @param element The WebElement to be right-clicked.
     */
    public static void rightClickWithActions(WebElement element) {
        waitForClickability(element,10);
        actions.contextClick(element).build().perform();
    }

    /**
     * Clicks and holds the specified WebElement using Actions.
     * @param element The WebElement to be clicked and held.
     */
    public static void clickAndHold(WebElement element) {
        actions.clickAndHold(element).build().perform();
    }

    /**
     * Sends text to the specified WebElement.
     * @param element The WebElement to send text to.
     * @param text The text to be sent.
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        actions.sendKeys(element,text).build().perform();
    }

    /**
     * Drags and drops a source WebElement to a target WebElement using Actions.
     * @param sourceElement The source WebElement.
     * @param targetElement The target WebElement.
     */
    public static void dragAndDropWithActions(WebElement sourceElement, WebElement targetElement) {
        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
    }

    /**
     * Releases the specified WebElement using Actions.
     * @param element The WebElement to be released.
     */
    public static void releaseElement(WebElement element){
        actions.release(element).build().perform();
    }

    /**
     * Switches to a window with the specified title.
     * @param targetTitle The title of the target window.
     */
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * Retrieves the text of a list of WebElements.
     * @param list The list of WebElements.
     * @return A list of text from the WebElements.
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Retrieves the text of WebElements located by a locator.
     * @param locator The locator to find WebElements.
     * @return A list of text from the WebElements.
     */
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Verifies that an element is displayed.
     * @param by The locator of the element.
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element is visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }

    /**
     * Verifies that an element is not displayed.
     * @param by The locator of the element.
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element is not visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifies that a WebElement is displayed.
     * @param element The WebElement to be verified.
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element is visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    /**
     * Verifies that a WebElement is not displayed.
     * @param element The WebElement to be verified.
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            Assert.assertFalse("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the JavaScriptExecutor object.
     * @return The JavaScriptExecutor object.
     */
    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * Executes a JavaScript command on a WebElement.
     * @param element The WebElement to execute the command on.
     * @param command The JavaScript command to be executed.
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);
    }

    /**
     * Executes a JavaScript command in the current browser session.
     * @param command The JavaScript code to be executed.
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);
    }

    /**
     * Scrolls to the specified WebElement.
     * @param element The WebElement to scroll to.
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls down by a specified number of pixels.
     * @param pixel The number of pixels to scroll down.
     */
    public static void scrollDownByPixels(int pixel) {
        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
    }

    /**
     * Scrolls up by a specified number of pixels.
     * @param pixel The number of pixels to scroll up.
     */
    public static void scrollUpByPixels(int pixel) {
        getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
    }

    /**
     * Scrolls to the bottom of the page.
     */
    public static void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * Hovers over the specified WebElement.
     * @param element The WebElement to hover over.
     */
    public static void hoverOverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Sets an attribute of a WebElement using JavaScript.
     * @param element The WebElement to set the attribute on.
     * @param attributeName The name of the attribute.
     * @param attributeValue The value of the attribute.
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlights a WebElement by changing its background and border color.
     * @param element The WebElement to be highlighted.
     */
    public static void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Selects or deselects a checkbox WebElement.
     * @param element The checkbox WebElement.
     * @param check True to select, false to deselect.
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * Selects a radio button or checkbox from a list of WebElements based on value.
     * @param listElement The list of WebElements.
     * @param value The value to match for selection.
     */
    public static void selectRadioOrCheckbox(List<WebElement> listElement, String value) {
        String actualValue;
        for (WebElement el : listElement) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }

    /**
     * Selects an option from a dropdown by visible text.
     * @param dropdownElement The dropdown WebElement.
     * @param textToSelect The visible text to select.
     */
    public static void selectDropdownByText(WebElement dropdownElement, String textToSelect) {
        try {
            Select select = new Select(dropdownElement);
            List<WebElement> options = select.getOptions();
            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects an option from a dropdown by index.
     * @param dropdownElement The dropdown WebElement.
     * @param index The index of the option to select.
     */
    public static void selectDropdownByIndex(WebElement dropdownElement, int index) {
        try {
            Select select = new Select(dropdownElement);
            int size = select.getOptions().size();
            if (size > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    /**
     * Accepts an alert if present.
     */
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dismisses an alert if present.
     */
    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the text from an alert.
     * @return The text from the alert.
     */
    public static String getAlertText() {
        String alertText = null;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return alertText;
    }

    /**
     * Sends text to an alert if present.
     * @param text The text to send to the alert.
     */
    public static void sendAlertText(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to a frame by name or ID.
     * @param nameOrId The name or ID of the frame.
     */
    public static void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to a frame by index.
     * @param index The index of the frame.
     */
    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to a frame by WebElement.
     * @param element The WebElement of the frame.
     */
    public static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to a child window.
     */
    public static void switchToChildWindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
            }
        }
    }

    /**
     * Retrieves the validation error message from a WebElement.
     * @param element The WebElement to retrieve the message from.
     * @return The validation error message.
     */
    public static String getValidationErrorMessage(WebElement element){
        String message =element.getAttribute("validationMessage");
        return message;
    }

    /**
     * Takes a screenshot and saves it with the specified filename.
     * @param filename The filename for the screenshot.
     * @return The screenshot as a byte array.
     */
    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File file = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/test-output/Screenshots/" + filename + date + ".png";
        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    /**
     * Creates a partial image from a screenshot.
     * @param imageName The name of the image.
     * @param xStartPoint The x-coordinate start point.
     * @param yStartPoint The y-coordinate start point.
     * @param width The width of the partial image.
     * @param height The height of the partial image.
     * @return The partial image as a BufferedImage.
     */
    public static BufferedImage partialImageCreator(String imageName, int xStartPoint, int yStartPoint, int width, int height) {
        File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage Image = null;
        BufferedImage ImagePartial = null;
        try {
            Image = ImageIO.read(Screenshot);
            ImagePartial = Image.getSubimage(xStartPoint, yStartPoint-115, width, height);
            ImageIO.write(ImagePartial, "png", Screenshot);
            FileUtils.copyFile(Screenshot, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\projectResources\\uiResources\\uiImages\\" + imageName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImagePartial;
    }

    /**
     * Moves the mouse to a specified coordinate.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @throws AWTException If the platform configuration does not allow low-level input control.
     */
    public static void moveMouseToACoordinate(int x, int y) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(x, y);
    }

    /**
     * Waits for a specified number of seconds.
     * @param seconds The number of seconds to wait.
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for a WebElement to be visible.
     * @param element The WebElement to wait for.
     * @param timeToWaitInSec The time to wait in seconds.
     * @return The visible WebElement.
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for a WebElement located by a locator to be visible.
     * @param locator The locator of the WebElement.
     * @param timeout The time to wait in seconds.
     * @return The visible WebElement.
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for a WebElement to be clickable.
     * @param locator The WebElement to wait for.
     * @param timeout The time to wait in seconds.
     * @return The clickable WebElement.
     */
    public static WebElement waitForClickability(WebElement locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for the presence of an element located by a locator.
     * @param by The locator of the element.
     * @param time The time to wait in seconds.
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Waits for the page to load completely.
     * @param timeOutInSeconds The timeout in seconds.
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Checks if an element is available on the page.
     * @param by The locator of the element.
     * @return True if the element is available, false otherwise.
     */
    public static boolean isElementAvailable(By by){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        try {
            if(driver.findElement(by).isDisplayed()){
                System.out.println(by.toString()+" element found");
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(by.toString()+" element not found");
            return false;
        }
        return false;
    }
}

