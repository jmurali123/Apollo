package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    @FindBy(xpath = "//p[text()=\"Medicines\"]")
    private WebElement medicinesLink;

    @FindBy(xpath = "//div[contains(@class,'MegaMenu_megaMenuRoot__O7BEw')]")
    private WebElement navigationmenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void medicinesLinkClick(){
        wait.until(ExpectedConditions.elementToBeClickable(medicinesLink)).click();
    }
    public WebElement getNavigationmenuLink(String linkName){
      return navigationmenu.findElement(By.xpath("//a[text()='"+linkName+"']"));
    }
}



