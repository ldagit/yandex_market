package steps;

import pages.MainYandexPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainYandexSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenuItem(String menuItem){
        new MainYandexPage().selectMainMenu(menuItem);
    }
}
