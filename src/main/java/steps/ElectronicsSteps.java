package steps;

import pages.ElectronicsPage;
import pages.MainYandexPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class ElectronicsSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectElectronicsMenuItem(String menuItem){
        new ElectronicsPage().selectElectronicsMenu(menuItem);
    }

    @Step("Заголовок страницы Элекстроника равен {0}")
    public void stepCheckPageTitle(String expectedTitle){
        String actualTitle = new ElectronicsPage().titlePage.getText(); //title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

}
