package com.mustafaaslantas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KitapYurduHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public KitapYurduHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void searchForBook(String bookName) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-input")));
        searchBox.sendKeys(bookName);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void login(String username, String password) {

        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Giriş Yap')]")));
        loginLink.click();

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-email")));
        WebElement passwordField = driver.findElement(By.id("login-password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("search-input"))).sendKeys("Java Programlama");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search-input"))).sendKeys(Keys.RETURN);
    }
}