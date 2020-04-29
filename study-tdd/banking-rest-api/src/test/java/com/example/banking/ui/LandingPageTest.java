package com.example.banking.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LandingPageTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","c:/opt/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void landingpage() {
        // Test name: landingpage
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://jquery.com/");
        // 2 | setWindowSize | 1936x1056 |
        driver.manage().window().setSize(new Dimension(1936, 1056));
        // 3 | click | linkText=Download |
        driver.findElement(By.linkText("Download")).click();
        // 4 | click | linkText=API Documentation |
        driver.findElement(By.linkText("API Documentation")).click();
        // 5 | click | css=.menu-item:nth-child(4) > a |
        driver.findElement(By.cssSelector(".menu-item:nth-child(4) > a")).click();
        // 6 | click | linkText=jquery |
        driver.findElement(By.linkText("jquery")).click();
        // 7 | click | linkText=jQuery File Upload |
        driver.findElement(By.linkText("jQuery File Upload")).click();
    }
}
