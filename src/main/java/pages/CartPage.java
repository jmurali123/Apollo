package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CartPage extends BasePage{
    @FindBy(css=".icon-cart_icon")
    private WebElement carticonLink;

    @FindBy(xpath="//button[contains(@class,'Remove')]")
    private List<WebElement> removeProductItemsButton;

    @FindBy(css="span.close")
    private WebElement alertPop;

    @FindBy(css="main.wrapper-container>p>span")
    private WebElement iframeclose;


    @FindBy(tagName = "iframe")
    private List<WebElement> iframes;

    private final String closeele="BDD_SmartUI('css=.close')[0]";

     @FindBy(xpath ="//p[contains(text(),'YOUR CART IS EMPTY')]")
    private WebElement cartemptylabel;
    public CartPage(WebDriver driver){ super(driver);}

    public CartPage clearCart(){
       List<WebElement>cartItems= wait.until(ExpectedConditions.visibilityOfAllElements(removeProductItemsButton));
        cartItems.stream().forEach(btn -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
        });
        return this;
    }

    public void gotoCartlink(){
        wait.until(ExpectedConditions.elementToBeClickable(carticonLink)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().frame(driver.findElement(By.cssSelector("#wiz-iframe-intent")));
      //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(generateIDLocator(this.closeele))))).click();
       // WebElement close=((JavascriptExecutor) driver).executeScript("window.frameElement.contentDocument.getElementsByClassName(\"close\")[0];");
        driver.findElement(By.cssSelector(".close")).click();
        driver.switchTo().defaultContent();
    }

    public String getemptycartMsg() {
        return wait.until(ExpectedConditions.visibilityOf(cartemptylabel)).getText();
    }
}
