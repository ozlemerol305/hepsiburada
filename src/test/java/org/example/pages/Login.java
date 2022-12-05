package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.utils.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.utils.Driver.webDriver;
public class Login {

    private static Login instance;

    public static synchronized Login getInstance() {
        if (instance == null)
            instance = new Login();
        return instance;
    }

    public void clickLogin() throws InterruptedException {
        WebElement giris = webDriver.findElement(By.id("myAccount"));
        giris.click();
        WebElement login = webDriver.findElement(By.id("login"));
        login.click();
        Thread.sleep(5000);
        WebElement username = webDriver.findElement(By.id("txtUserName"));
        new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable((username))).sendKeys("ozlemerol305@gmail.com");
        //username.sendKeys("ozlemerol305@gmail.com");

        WebElement girisyap = webDriver.findElement(By.id("btnLogin"));
        girisyap.click();
        Thread.sleep(5000);
        WebElement parola = webDriver.findElement(By.id("txtPassword"));
        parola.sendKeys("Ozlem123.");
        WebElement girisyap2 = webDriver.findElement(By.id("btnEmailSelect"));
        girisyap2.click();
        WebElement Labelhesabim = webDriver.findElement(By.xpath("//a[@title='Hesabım']"));
       // boolean b = webDriver.findElements(By.xpath("//a[@title='Hesabım']")).size() != 0;
    }


}
