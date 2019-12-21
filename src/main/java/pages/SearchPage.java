package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import static org.junit.Assert.assertTrue;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//h1[@class = 'title title_size_28 title_bold_yes']")
    public WebElement titlePage;

    public SearchPage (){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkPageTitle (String expectedTitle){
        String actualTitle = titlePage.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

}
