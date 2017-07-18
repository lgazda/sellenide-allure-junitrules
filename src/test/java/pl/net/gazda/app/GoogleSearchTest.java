package pl.net.gazda.app;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import pl.net.gazda.test.page.GoogleSearchPage;
import pl.net.gazda.test.page.SearchResultsPage;
import pl.net.gazda.test.rule.AllureReportScreenShooter;
import pl.net.gazda.test.rule.ChromeWebDriver;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

/**
 * Simple Selenide test.
 */
public class GoogleSearchTest {
    @ClassRule public static ChromeWebDriver chromeDriver = new ChromeWebDriver();
    @Rule public AllureReportScreenShooter screenShot = new AllureReportScreenShooter();

    @Test
    public void should_returnSearchResults_when_searchingUsingSelenide() {
        GoogleSearchPage googleSearch = open("http://google.com", GoogleSearchPage.class);
        SearchResultsPage resultPage = googleSearch.searchFor("selenide");

        resultPage.getResults()
            .shouldHave(sizeGreaterThan(5));
        resultPage.getResult(0)
            .shouldBe(visible, present)
            .shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
