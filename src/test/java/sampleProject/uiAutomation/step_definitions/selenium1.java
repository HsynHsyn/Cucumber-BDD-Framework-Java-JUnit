package sampleProject.uiAutomation.step_definitions;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium1 {

    WebDriver driver;

    @BeforeEach
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://www.google.com");
        driver.get("https://practice.cydeo.com");
}

    @Test
    public void test01(){

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        try{
            driver.findElement(By.id("L2AGLb")).click();
        }catch(Exception e){
            System.out.println("Button to accept cookies not found");
        }


        Assertions.assertEquals(actualTitle, expectedTitle);

    }
    
    @Test
    public void test02() throws InterruptedException{

        String expectedLinkText = "A/B Testing";
        WebElement ABTestingButton = driver.findElement(By.linkText("A/B Testing"));
        ABTestingButton.click();
        driver.navigate().back();
        Assertions.assertEquals("Practice", driver.getTitle());

        Thread.sleep(2000); // Wait for 2 seconds to observe the back navigation
        //WebElement googleSearchBox = driver.findElement(By.name("q"));
       // googleSearchBox.sendKeys("Amscreen");

        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));

        for(WebElement each:listOfLinks){
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }



    }


    @AfterEach
    public void tearDownMethod(){
        driver.quit();
    }


    
}   
