package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingWebElementsTest {

    WebDriver driver;

    @BeforeClass
    void setUp() throws InterruptedException {
        driver = new EdgeDriver();
        Thread.sleep(2000);
        // set Path
        driver.get("file:///C:/Users/13718/IdeaProjects/selenium_test/src/test/resources/index.html");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // 1. selectByVisibleText
        Select colorDropDown = new Select(driver.findElement(By.id("colorSelector")));
        colorDropDown.selectByVisibleText("Blue");
        Thread.sleep(3000);

        // 2. selectByvalue
        Select fruitDropDown = new Select(driver.findElement(By.id("fruitSelector")));
        fruitDropDown.selectByValue("banana");
        Thread.sleep(3000);

        //class Activity
        //selectByIndex
        // 2. selectByValue
        Select country = new Select(driver.findElement(By.id("countrySelect")));
        country.selectByIndex(2);
        Thread.sleep(3000);

        //TextField
        WebElement textField = driver.findElement(By.id("nameInput"));
        textField.sendKeys("Neusoft");
        Thread.sleep(2000);

        //RedButton
        WebElement radioMale = driver.findElement(By.xpath("/html/body/fieldset[1]/label[2]/input"));
        radioMale.click();
        Thread.sleep(2000);

        // CheckBox
        WebElement sportHobbies = driver.findElement(By.xpath("/html/body/fieldset[2]/label[1]/input"));
        if(!sportHobbies.isSelected()) {
            sportHobbies.click();
        }
        Thread.sleep(1000);
        WebElement readingHobbies = driver.findElement(By.xpath("/html/body/fieldset[2]/label[2]/input"));
        readingHobbies.click();
        Thread.sleep(1000);
        // selectByIndex
        // 2. selectByValue
        Select countries = new Select(driver.findElement(By.id("countrySelect")));
        countries.selectByIndex(2);
        Thread.sleep(2000);

    }
    @Test
    void testWebElements() throws InterruptedException{
        driver.findElement(By.linkText("Bing")).click();
        Thread.sleep(2000);
        // navigate back to the home page
        driver.navigate().back();
        Thread.sleep(2000);
    }
    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}