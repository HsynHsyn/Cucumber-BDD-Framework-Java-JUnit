package sampleProject.uiAutomation.step_definitions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class testStepDefs {

   WebDriver driver1;

   @BeforeEach
   public void setupMethod(){
    driver1 = new ChromeDriver();
    driver1.manage().window().maximize();
    driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    driver1.get("https://amscreen.com/");
   }

   @Test
    public void test01() {

    String actualTitle = driver1.getTitle();
    String expectedTitle = "Amscreen | Digital Signage Specialists | IoT and Digital Screen Solutions";

    Assertions.assertEquals(actualTitle, expectedTitle);

    WebElement popUpButton = driver1.findElement(By.xpath("//button[text()='Accept']"));
    popUpButton.click();
    
    WebElement element = driver1.findElement(By.xpath("//div[@class='header-btn']//a[@class='default-btn green']"));
    
    element.click();

    }

    @Test
    public void test02(){

        Actions actions = new Actions(driver1);

        WebElement popUpButton = driver1.findElement(By.xpath("//button[text()='Accept']"));
        popUpButton.click();

        WebElement blackGetInTouchButton = driver1.findElement(By.xpath("(//div[@class='cell medium-6 link-align']//a[@class='default-btn black'])[2]"));
        actions.moveToElement(blackGetInTouchButton).perform();

        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        
        blackGetInTouchButton.click();

        


    }



   @AfterEach
   public void tearDownMethod(){
    driver1.quit();
   }



       
}
