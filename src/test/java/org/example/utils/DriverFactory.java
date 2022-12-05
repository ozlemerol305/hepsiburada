package org.example.utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

public static WebDriver getDriver(){

    String browser = System.getenv("BROWSER");
    if (browser.equalsIgnoreCase("FIREFOX")) {
        return new FirefoxDriver();
    } else {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-popup-blocking");

        return new ChromeDriver(options);
    }
}
}
