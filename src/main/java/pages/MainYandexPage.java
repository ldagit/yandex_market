package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.Set;

public class MainYandexPage extends BasePage {

    @FindBy(xpath = "//div[contains(@role, 'navigation')]")
    public WebElement mainMenu;

    public MainYandexPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath("//div[contains(@class, 'home-tabs')]//*[contains(text(),'"+menuItem +"')]")).click();

    }
}
//-//div[contains(@class, 'home-tabs')]//*[contains(text(),'Маркет')]
//- .//*[contains(@data-id,'"+ menuItem +"')]