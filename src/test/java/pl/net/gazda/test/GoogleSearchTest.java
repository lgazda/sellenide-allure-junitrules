package pl.net.gazda.test;

import com.codeborne.selenide.junit.BrowserStrategy;
import org.junit.*;
import pl.net.gazda.test.rule.AllureReportScreenShooter;
import pl.net.gazda.test.rule.ChromeWebDriver;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Ignore
public class GoogleSearchTest {
    @ClassRule public static ChromeWebDriver chromeDriver = new ChromeWebDriver();
    @Rule public AllureReportScreenShooter screenShot = new AllureReportScreenShooter();

    @Test
    public void should_return_searchResults_for_search() {
        GoogleSearchPage page = open("http://google.com", GoogleSearchPage.class);
        SearchResultsPage results = page.searchFor("selenide");
        results.getResults().shouldHave(size(10));
        results.getResult(0).shouldHave(text("pl.net.gazda.test.GoogleSearchTest: concise UI tests in Java"));
    }

    @Test
    public void should_return_searchResults_for_search2() {
        GoogleSearchPage page = open("http://google.com", GoogleSearchPage.class);
        SearchResultsPage results = page.searchFor("selenide");
        results.getResults().shouldHave(sizeNotEqual(0));
    }

    @Test
    public void onet() {
        GoogleSearchPage page = open("http://onet.pl", GoogleSearchPage.class);
        $("klkld").shouldBe(visible);
    }

}
