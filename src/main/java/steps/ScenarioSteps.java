package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductPage;

public class ScenarioSteps {

    MainYandexSteps mainYandexSteps = new MainYandexSteps();
    MarketSteps marketSteps = new MarketSteps();
    ElectronicsSteps electronicsSteps = new ElectronicsSteps();
    ProductSteps tvSteps = new ProductSteps();
    SearchSteps searchSteps = new SearchSteps();


    @When("^Выбран пункт меню \"(.*)\"$")
    public void selectYandexMainMenu(String menuItem){
        mainYandexSteps.stepSelectMainMenuItem(menuItem);
    }

    @When("^Выбран пункт маркет-меню \"(.*)\"$")
    public void selectMarketMainMenu(String menuItem){
        marketSteps.stepSelectMarketMenuItem(menuItem);
    }

    @When("^Заголовок страницы Электроника - \"(.*)\"$")
    public void checkPageTitle(String expectedTitle){
        electronicsSteps.stepCheckPageTitle(expectedTitle);
    }

    @Then("^Выбран пункт электроника-меню \"(.*)\"$")
    public void selectElectronicsMainMenu(String menuItem){
        electronicsSteps.stepSelectElectronicsMenuItem(menuItem);
    }

    @When("^Заголовок страницы - \"(.*)\"$")
    public void checkTVPageTitle(String expectedTitle){
        tvSteps.stepCheckPageTitle(expectedTitle);
    }

    @Then("^Включается CheckBox для - \"(.*)\"$")
    public void selectTVProducerCheckBox(String producerName){
        tvSteps.stepCheckBosProducerIn(producerName);
    }

    @Then("^Заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> tvSteps.stepFillField(field, value));
    }

    @When("^Выбирается колличество элементов поиска на странице :\"(.*)\"$")
    public void selectElementCount(String value){
        tvSteps.stepSelectElementCount(value);

    }

    @Then("^Проверяется, что колличество элементов поиска на странице :\"(.*)\"$")
    public void checkElementCount(String value){
        tvSteps.stepCheckSelectedCount(value);
    }

    @When("Получено название первого элемента поиска на странице")
    public void getFirstName(){
        tvSteps.stepGetSearchElement();
    }

    @Then("Поиск")
    public void searchAndCheck(){
        tvSteps.stepSearchAndCheck();

    }

    @Then("Клик")
    public void firstNameClick(){
        tvSteps.stepSearchElementClick();
    }

    @Then("Проверка")
    public void check(){
        searchSteps.stepCheckPageTitle(ProductPage.searchName);

    }

}
