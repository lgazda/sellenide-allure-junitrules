package pl.net.gazda.test.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

/**
 * As you see, there is no PageFactory, no initElements and other garbage like that. Your Page Object only contains your logic.
 */
public class GoogleSearchPage {
    @FindBy(how = How.NAME, using = "q")
    private SelenideElement searchBox;

    @Step("searching: {searchText}")
    public SearchResultsPage searchFor(String searchText) {
        searchBox.setValue(searchText).pressEnter();
        return page(SearchResultsPage.class);
    }
}