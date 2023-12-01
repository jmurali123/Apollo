package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{

     @FindBy(xpath = "//span[text()='View Cart']")
     private WebElement viewCartLink;

     @FindBy(xpath = "//span[text()='Add to Cart']/..")
     private WebElement addToCart;


     public ProductPage(WebDriver driver){
       super(driver);
     }

     public void selFilter(String filter){
         String filtermenu="//h2[contains(text(),'"+filter+"')]/../span";
         By prodfil=By.xpath(filtermenu);
         WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(prodfil));
         ele.click();
     }

     public void selCategory(String catergory, String subcategory){
         String catmenu="//label[text()='"+catergory+"']//../input";
         By categorymenu=By.xpath(catmenu);
         WebElement ele1= wait.until(ExpectedConditions.presenceOfElementLocated(categorymenu));
         ele1.click();
         String subcat="//label[contains(text(),'"+subcategory+"')]//../input";
         By subcategorymenu=By.xpath(subcat);
         WebElement ele2= wait.until(ExpectedConditions.presenceOfElementLocated(subcategorymenu));
         ele2.click();

     }
    public void selProduct(String productName){
         String prod="//p[contains(text(),'"+productName+"')]";
         By prodlink= By.xpath(prod);
         WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(prodlink));

        int x=ele.getLocation().getX();
        int y=ele.getLocation().getY();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
         ((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+","+y+")");
          ele.click();

      //   ele.click();
    }

    public void selSize(String prodsize){
         String size="//span[contains(text(),'"+prodsize+"')]";
         By prodSize= By.xpath(size);
        WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(prodSize));
        int x=ele.getLocation().getX();
        int y=ele.getLocation().getY();


       ((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+","+y+")");
      //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();

    }

    public void navToCart(){
         wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

    public void addToCart(){
         wait.until(ExpectedConditions.elementToBeClickable(addToCart));
      //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        addToCart.click();
    }

}
