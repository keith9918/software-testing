package org.example;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;

import static org.example.BMICalculatorTest.myWait;

public class authLoginTest {

        static WebDriver driver;
        static WebElement username;
        static WebElement password;
        static WebElement loginBtn;
        @BeforeClass
        public static void setUp() {
            driver = new EdgeDriver();
            driver.get("https://practicetestautomation.com/practice-test-login/");
            username = driver.findElement(By.id("username"));
            password = driver.findElement(By.id("password"));
            loginBtn = driver.findElement(By.id("submit"));
        }

        @BeforeMethod
        void clearUp() {
            username.clear();
            password.clear();
        }
        @Test
        void PositiveLogInTest() throws InterruptedException{
            username.sendKeys("student");
            Thread.sleep(2000);
            password.sendKeys("Password123");
            Thread.sleep(2000);

            loginBtn.click();
            Thread.sleep(2000);
            // check if it successful
            WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div/div/div/a"));
            Assert.assertTrue(logoutBtn.isDisplayed());
            // Logout
            logoutBtn.click();
        }

        @org.testng.annotations.Test
        void NegativeUsernameTest() throws InterruptedException{
            username.sendKeys("incorrectUser");
            Thread.sleep(2000);
            password.sendKeys("Password123");
            Thread.sleep(2000);

            loginBtn.click();
            Thread.sleep(2000);

            WebElement errorMessage = driver.findElement(By.id("error"));
            Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"));
        }

        @AfterClass
        public static void tearDown() {

            if(driver != null) {
                driver.quit();
            }
        }
    }