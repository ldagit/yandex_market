package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MarketPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'n-w-tabs__horizontal-tabs-container')]")
    public WebElement marketMenu;

    public MarketPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMarketMenu(String menuItem){
        marketMenu.findElement(By.xpath("//*[contains(@data-bem, '"+menuItem+"')]")).click();
    }

}
