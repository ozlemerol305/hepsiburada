package org.example.pages;

import org.example.utils.Driver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Set;
import static org.example.utils.Driver.webDriver;

public class Product {

    private static Product instance;
    private static final Log log = LogFactory.getLog(Product.class);

    public static synchronized Product getInstance() {
        if (instance == null)
            instance = new Product();
        return instance;
    }

    public void switchWindow(){
        Set handles = Driver.webDriver.getWindowHandles();
        while (handles.size() > 1){
            Driver.webDriver.close();
            handles = Driver.webDriver.getWindowHandles();
        }
        Driver.webDriver.switchTo().window(Driver.webDriver.getWindowHandles().iterator().next());
    }

    public void openComments(){
        if (checkRatings()){
            log.info("====Clicking Comments and Reviews====");
            WebElement rating = webDriver.findElement(By.className("rating-star"));
            rating.click();
        }
        else
        {
            log.info("====Product has no comment and case ended====");
        }
    }

    public void clickYesButton(){
        if (checkYesButton()){
            log.info("====Clicking Yes Button=====");
            WebElement element = webDriver.findElement(By.xpath("//div[contains(@class, 'thumbsUp hermes-ReviewCard-module')]"));
            new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable((element))).click();
        }
    }

    public void assertThanks(){
        if (checkThanksLabel()) {
            log.info("=====Checking Thanks Message====");
            String labelThanks = webDriver.findElement(By.xpath("//span[contains(@class, 'hermes-ReviewCard-module')][contains(text(),'Teşekkür Ederiz.')]")).getText();
            Assert.assertEquals("Teşekkür Ederiz.", labelThanks);
        }
    }

    public boolean checkRatings(){
        return webDriver.findElements(By.className("rating-star")).size() > 0;
    }

    public boolean checkYesButton(){
        //return webDriver.findElements(By.xpath("((//div[@class='hermes-ReviewCard-module-1HkLz'])[1]//*[local-name()='svg'])[1]")).size() > 0;
        return webDriver.findElements(By.xpath("//div[contains(@class, 'thumbsUp hermes-ReviewCard-module')]")).size()>0;
    }

    public boolean checkThanksLabel() {
        return webDriver.findElements(By.xpath("//span[contains(@class, 'hermes-ReviewCard-module')][contains(text(),'Teşekkür Ederiz.')]")).size() > 0;
    }

}
