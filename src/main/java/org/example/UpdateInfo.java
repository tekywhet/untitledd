package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class UpdateInfo {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void setup() {
        // Set up the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    public void login() {
        // Open the website
        driver.get("https://dev.mavenx.gg/");

        // Wait for and click the "Ok Got It" button
        clickWhenClickable(By.xpath("//*[contains(text(),'Ok Got It')]"));

        // Wait for and click the login element
        clickWhenClickable(By.xpath("//span[contains(@class,'font-[inherit] text-inherit')]"));

        // Enter username and password
        enterText(By.xpath("//input[@title='Username / Email']"), "teky2");
        enterText(By.xpath("//input[@title='Password']"), "12345@Talha");

        // Click the login button
        clickWhenClickable(By.xpath("//span[@class='font-inherit text-inherit font-thin']"));
    }

    @Test(priority = 1)
    public void infoUpdate() {
        // Wait for and click the profile icon
        clickWhenClickable(By.xpath("//img[@class='object-cover h-full w-full']"));

        // Wait for and click "Settings"
        clickWhenClickable(By.xpath("//span[normalize-space()='Settings']"));

        // Update the username
        WebElement usernameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='text' and contains(@class, 'w-full')]")));
        usernameInputField.clear();
        usernameInputField.sendKeys("teky Name Updated");

        // Update the email address
        WebElement emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email' and contains(@class, 'w-full')]")));
        emailInputField.clear();
        emailInputField.sendKeys("talhapms2@yopmail.com");
    }

    // Helper methods to reduce redundancy
    private void clickWhenClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    // Clean up after tests
    @org.testng.annotations.AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
