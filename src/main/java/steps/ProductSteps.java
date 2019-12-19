package steps;

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
    public void stepCheckSelectedCount(String expectedCount){
        ProductPage tvPage = new ProductPage();
        String actualCount = tvPage.selectedCount.getText();
        assertTrue(String.format("Колличество равно [%s]. Ожидалось - [%s]",
                actualCount, expectedCount), actualCount.contains(expectedCount));
    }

    @Step("заполнение строки поиска названием первого элемента в списке")
    public void stepGetSearchElement(){

        ProductPage tvPage = new ProductPage();
        tvPage.getSearchElement();
    }

    @Step("поиск первого элемента")
    public void stepSearchAndCheck(){
        new ProductPage().searchLine.click();
    }

    @Step("клик по найденному элементу")
    public void stepSearchElementClick(){
        ProductPage tvPage = new ProductPage();
        tvPage.searchElementClick();

    }

}
