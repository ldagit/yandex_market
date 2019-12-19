package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//h1[@class = 'title title_size_28 title_bold_yes']")
    public WebElement titlePage;

    public SearchPage (){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkPageTitle (String expectedValue){

    }

}
