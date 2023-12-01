package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static HomePage homePage;
    private static ProductPage productPage;
    private static CartPage cartPage;

    public static HomePage getHomePage(WebDriver driver) {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static ProductPage getProductPage(WebDriver driver) {
        return productPage == null ? new ProductPage(driver) : productPage;
    }

    public static CartPage getCartPage(WebDriver driver){
        return cartPage == null? new CartPage(driver):cartPage;
    }


}
