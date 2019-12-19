package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ElectronicsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@data-apiary-widget-name, 'MarketNode/NavigationTree')]")
    public WebElement electronicsMenu;

    @FindBy(xpath = "//div[contains(@data-apiary-widget-name, 'MarketNode/CatalogHeader')]//*[contains(text(), 'Электроника')]")
    public WebElement titlePage;

    public ElectronicsPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectElectronicsMenu(String menuItem){
       electronicsMenu.findElement(By.xpath(".//*[contains(text(), '"+menuItem+"')]")).click();
    }
}
