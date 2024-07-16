package com.mustafaaslantas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {

            KitapYurduHomePage homePage = new KitapYurduHomePage(driver);


            driver.get("https://www.kitapyurdu.com");


            homePage.login("email", "password");


            homePage.searchForBook("Java Programlama");
            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Android Studio İle Mobil Java Programlama')]")));
            productLink.click();
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));

            addToCartButton.click();
            driver.get("https://www.kitapyurdu.com/index.php?route=checkout/cart");

            WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Kaldır')]")));
            removeButton.click();

            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
