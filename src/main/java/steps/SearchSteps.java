package steps;

import pages.ProductPage;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SearchSteps {
    @Step("Заголовок страницы равен запомненному значению")
    public void stepCheckPageTitle(String expectedTitle){
        /*String actualTitle = new SearchPage().titlePage.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));*/
        new SearchPage().checkPageTitle(expectedTitle);
        printTextToReport(ProductPage.searchName);

    }

    @Step("{0}")
    public void printTextToReport(String printText){

    }
}
