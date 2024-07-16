package com.mustafaaslantas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KitapYurduTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            KitapYurduHomePage homePage = new KitapYurduHomePage(driver);
            driver.get("https://www.kitapyurdu.com");

            homePage.searchForBook("Java Programlama");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
