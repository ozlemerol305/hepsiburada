package org.example.pages;

import org.openqa.selenium.By;
import static org.example.utils.Driver.webDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Home {

    private static Home instance;
    private static final Log log = LogFactory.getLog(Product.class);

    public void search(String term)
    {
        log.info(term + " is searching");
        webDriver.findElement(By.className("desktopOldAutosuggestTheme-input")).sendKeys(term);
        webDriver.findElement(By.className("SearchBoxOld-buttonContainer")).click();
    }

    public static synchronized Home getInstance(){
        if (instance == null)
            instance = new Home();
        return instance;
    }
}
