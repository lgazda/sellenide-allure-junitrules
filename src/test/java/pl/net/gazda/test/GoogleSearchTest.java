package pl.net.gazda.test;

import org.junit.*;
import pl.net.gazda.test.page.GoogleSearchPage;
import pl.net.gazda.test.page.SearchResultsPage;
import pl.net.gazda.test.rule.AllureReportScreenShooter;
import pl.net.gazda.test.rule.ChromeWebDriver;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchTest {
    @ClassRule public static ChromeWebDriver chromeDriver = new ChromeWebDriver();
    @Rule public AllureReportScreenShooter screenShot = new AllureReportScreenShooter();

    @Test
    public void should_return_searchResults_for__selenide_search() {
        GoogleSearchPage googleSearch = open("http://google.com", GoogleSearchPage.class);
        SearchResultsPage resultPage = googleSearch.searchFor("selenide");

        resultPage.getResults().shouldHave(sizeGreaterThan(5));
        resultPage.getResult(0).shouldBe(visible, present);
        resultPage.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
