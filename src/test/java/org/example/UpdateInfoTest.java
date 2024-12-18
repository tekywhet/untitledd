package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class UpdateInfoTest {

    /**
     * Test class for the UpdateInfo class.
     * Ensures that the login method initiates the correct sequence of steps to authenticate
     * a user and update profile information.
     */

    @Test
    void testLoginValidCredentials() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        try {
            driver.get("https://dev.mavenx.gg/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement okGotItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Ok Got It')]")));
            okGotItButton.click();

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'font-[inherit] text-inherit')]")));
            loginButton.click();

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Username / Email']")));
            usernameField.sendKeys("teky");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Password']")));
            passwordField.sendKeys("12345@Talha");

            WebElement loginSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='font-inherit text-inherit font-thin']")));
            loginSubmitButton.click();

            WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='object-cover h-full w-full']")));
            assertNotNull(profileIcon);

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @Test
    void testLoginInvalidCredentials() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        try {
            driver.get("https://dev.mavenx.gg/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement okGotItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Ok Got It')]")));
            okGotItButton.click();

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'font-[inherit] text-inherit')]")));
            loginButton.click();

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Username / Email']")));
            usernameField.sendKeys("invalidUser");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Password']")));
            passwordField.sendKeys("wrongPassword");

            WebElement loginSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='font-inherit text-inherit font-thin']")));
            loginSubmitButton.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invalid credentials')]")));
            assertNotNull(errorMessage);

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @Test
    void testLoginProfileUpdate() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        try {
            driver.get("https://dev.mavenx.gg/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement okGotItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Ok Got It')]")));
            okGotItButton.click();

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'font-[inherit] text-inherit')]")));
            loginButton.click();

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Username / Email']")));
            usernameField.sendKeys("teky");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Password']")));
            passwordField.sendKeys("12345@Talha");

            WebElement loginSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='font-inherit text-inherit font-thin']")));
            loginSubmitButton.click();

            WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='object-cover h-full w-full']")));
            profileIcon.click();

            WebElement settingsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
            settingsButton.click();

            WebElement usernameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='w-full rounded-[10px] h-[40px] text-[13px] lg:text-[15px] text-primary-content px-[20px] py-[16px] font-cnb cursor-text bg-base-200 focus:outline-none' and @type='text']")));
            usernameInputField.clear();
            usernameInputField.sendKeys("tekyUpdated");

            assertEquals("tekyUpdated", usernameInputField.getAttribute("value"));

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}