package org.example.utils;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver webDriver;

    @BeforeSuite
    public void initializeDriver(){
    webDriver = DriverFactory.getDriver();
    webDriver.manage().timeouts().pageLoadTimeout((long) 50, TimeUnit.SECONDS);
    }

    @BeforeScenario
    public void beforeScenario(){
    webDriver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void closeDriver(){
    webDriver.quit();
    }

    @AfterScenario
    public void afterScenario(){
    webDriver.manage().deleteAllCookies();    }
}
