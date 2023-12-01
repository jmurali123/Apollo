package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.PageFactoryManager;
import pages.ProductPage;

public class CartstepDefinition {
 private final ProductPage productPage;
 private final HomePage homePage;
 private final CartPage cartPage;

 public CartstepDefinition(DriverContext context){
     productPage= PageFactoryManager.getProductPage(context.driver);
     homePage= PageFactoryManager.getHomePage(context.driver);
     cartPage=PageFactoryManager.getCartPage(context.driver);
 }
 @When("I add a product {string} to the cart of {string} and size {string}")
  public void addProduct(String product,String producttype,String size){
     homePage.medicinesLinkClick();
     homePage.getNavigationmenuLink(producttype).click();
     productPage.selProduct(product);
     productPage.selSize(size);
     productPage.addToCart();
     cartPage.gotoCartlink();
     cartPage.clearCart();
  }




    @And("I navigate to {string} producttype  and filter {string}")
    public void iNavigateToProducttypeAndFilter(String producttype, String filter) {
        homePage.medicinesLinkClick();
        homePage.getNavigationmenuLink(producttype).click();
        productPage.selFilter(filter);
    }

    @When("I select category {string} and {string}")
    public void iSelectCategoryAnd(String parentcategory, String subcategory) {
     productPage.selCategory(parentcategory,subcategory);
    }

    @And("I add a product {string} to the cart")
    public void iAddAProductToTheCart(String product) {
        productPage.selProduct(product);
        productPage.addToCart();
    }

    @Then("the cart should be empty")
    public void thecartisempty() {
        /* Asserting the cart empty message */
        Assert.assertEquals(" YOUR CART IS EMPTY", cartPage.getemptycartMsg());

    }

    @Given("I delete the cart items")
    public void iDeleteTheCartItems() {
        cartPage.gotoCartlink();
        cartPage.clearCart();
    }
}
