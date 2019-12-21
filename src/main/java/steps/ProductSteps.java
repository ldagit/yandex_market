package steps;

import org.openqa.selenium.NoSuchElementException;
import pages.ProductPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ProductSteps {

    @Step("Заголовок страницы равен {0}")
    public void stepCheckPageTitle(String expectedTitle){
        String actualTitle = new ProductPage().titlePage.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("CheckBox для {0} включается")
    public void stepCheckBosProducerIn(String checkBoxName)
    {
        new ProductPage().selectTVProducer(checkBoxName);


    }

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value)
    {
        new ProductPage().fillField(field, value);

    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("выбирается колличество элементов поиска на странице")
    public void stepSelectElementCount(String value){
        ProductPage tvPage = new ProductPage();
        tvPage.selectElementCount(value);
    }

    @Step("выбраное колличество элементов на странице равно: {0}")
    public void stepCheckSelectedCount(String expectedCount) throws InterruptedException {
        ProductPage tvPage = new ProductPage();
        Thread.sleep(1000);
        String actualCount;
        try {
            actualCount = tvPage.selectedCount.getText();
    } catch ( NoSuchElementException e) {
            actualCount = ProductPage.elementCount;
    }
        String expCount = Integer.toString(tvPage.checkElementCount());
        printTextToReport("Количество найденных элементов на странице: " + expCount);
        printTextToReport("Выбранное количество для отображения: " + actualCount);
        assertTrue(String.format("Колличество равно [%s]. Ожидалось - [%s]",
                actualCount, expCount), actualCount.contains(expectedCount));
    }

    @Step("заполнение строки поиска названием первого элемента в списке")
    public void stepGetSearchElement(){

        ProductPage tvPage = new ProductPage();
        tvPage.getSearchElement();
        printTextToReport(ProductPage.searchName);
    }

    @Step("поиск первого элемента")
    public void stepSearchAndCheck(){
        new ProductPage().searchLine.click();
        printTextToReport(ProductPage.searchName);
    }

    @Step("переход на страничку найденного элемента")
    public void stepSearchElementClick(){
        ProductPage tvPage = new ProductPage();
        tvPage.searchElementClick();
        printTextToReport(ProductPage.searchName);

    }

    @Step("{0}")
    public void printTextToReport(String printText){

    }

}
