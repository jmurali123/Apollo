package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.PageFactoryManager;
import utils.ConfigLoader;

public class HomepageDefinitions {
    private final HomePage homePage;
    public HomepageDefinitions(DriverContext context) {
        homePage = PageFactoryManager.getHomePage(context.driver);
    }
    @Given("I am on the Apollo home page$")
    public void iMAUserOnTheApolloApplication() {
        homePage.load(ConfigLoader.getInstance().getBaseUrl());
    }
}
