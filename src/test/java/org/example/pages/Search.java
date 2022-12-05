package org.example.pages;

import org.openqa.selenium.By;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static org.example.utils.Driver.webDriver;

public class Search {

    private static Search instance;
    private static final Log log = LogFactory.getLog(Product.class);

    public static synchronized Search getInstance() {
        if (instance == null)
            instance = new Search();
        return instance;
    }

    public void clickProduct(Integer productNumber){
        log.info(productNumber + ". product is selecting");
        try {
            Thread.sleep(5000);
            productNumber -= 1;
           // String value = String.valueOf(webDriver.findElement(By.xpath("//li[@id='i"+productNumber+"']//a")));
            webDriver.findElement(By.xpath("//li[@id='i"+productNumber+"']//a")).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
