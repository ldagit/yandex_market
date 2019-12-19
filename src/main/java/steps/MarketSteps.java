package steps;

import pages.MainYandexPage;
import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMarketMenuItem(String menuItem){
        new MarketPage().selectMarketMenu(menuItem);
    }
}
