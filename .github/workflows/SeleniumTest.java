package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTest {

    static WebDriver driver;
    @BeforeAll
    static  void setup(){
        // Set the system property for the Microsoft Edge driver
        //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/msedgedriver.exe");

        // Initialize the WebDriver instance using EdgeDriver
        WebDriver driver = new EdgeDriver();
        driver.get("http://www.bing.com");

    }

    @Test
    void test1() throws InterruptedException {
        driver.get("http://www.bing.com");

        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
        Thread.sleep(1000);

        textArea.sendKeys("Neusoft institute guangdong");
        Thread.sleep(2000);

        textArea.sendKeys(Keys.ENTER);
        Thread.sleep(2000);


    }
    @AfterAll
    static void tearDown(){
        driver.quit();

    }

}