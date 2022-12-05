package org.example.pagesteps;

import com.thoughtworks.gauge.Step;
import org.example.pages.Home;
import org.example.pages.Login;
import org.example.pages.Product;
import org.example.pages.Search;


public class Casesteps {

    private static Home homePage = Home.getInstance();
    private static Search searchPage = Search.getInstance();
    private static Product productPage = Product.getInstance();

    private static Login loginPage = Login.getInstance();

    @Step("Search for <term>")
    public void searchTerm(String term) {
        homePage.search(term);
    }

    @Step("Clicks on the #<> search result")
    public void selectProduct(Integer productNumber) {
        searchPage.clickProduct(productNumber);
    }

    @Step("Open the review tab for selected product")
    public void clickComment() {
        productPage.switchWindow();
        productPage.openComments();
    }

    @Step("Clicks yes button on first review")
    public void clickYes() {
        productPage.clickYesButton();
    }

    @Step("User should see thanks message")
    public void checkThanks() {
        productPage.assertThanks();
    }

    @Step("Click login buttom")
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickLogin();
    }
}
