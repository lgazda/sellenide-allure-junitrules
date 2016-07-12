package pl.net.gazda.test.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * As you see, there is no PageFactory, no initElements and other garbage like that. Your Page Object only contains your logic.
 */
public class GoogleSearchPage {
    @FindBy(how = How.NAME, using = "q")
    private SelenideElement searchBox;

    @Step("searching: {0}")
    public SearchResultsPage searchFor(String searchText) {
        searchBox.setValue(searchText).pressEnter();
        return page(SearchResultsPage.class);
    }
}