package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BMITest {
    WebDriver driver;
    WebDriverWait myWait;
    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        // Waits for driver to be loaded for 5 seconds
        myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.texasheart.org/heart-health/heart-information-center/topics/body-mass-index-bmi-calculator/");
    }
    @Test
    void input() throws InterruptedException {
        WebElement Height = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[2]/input")));

        WebElement Weight = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[3]/input")));

        WebElement CalculateBMI = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[1]/div[2]/div[4]/input")));

        WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-601\"]/div/div/form/fieldset/div[2]/div[2]/input")));


        //WebElement result = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result-input")));



        CalculateBMI.click();
        Height.sendKeys("176");
        Thread.sleep(1000);
        Weight.sendKeys("70");
        Thread.sleep(1000);
        CalculateBMI.click();
        Thread.sleep(1000);


        String resultTest = result.getAttribute("value");


        System.out.println(result.getText());
        Assertions.assertEquals(Double.parseDouble(result.getText()), 22.85, 0.2);


    }
    //如果你想看到这个页面可以不用输入关闭语句
    @AfterEach
    void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
