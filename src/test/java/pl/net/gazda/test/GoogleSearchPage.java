package pl.net.gazda.test;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchPage {
    @Step("searching..")
    public SearchResultsPage searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();
        return page(SearchResultsPage.class);
    }
}