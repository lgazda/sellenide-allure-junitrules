package pl.net.gazda.app;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import pl.net.gazda.test.page.ApplicationPage;
import pl.net.gazda.test.rule.AllureReportScreenShooter;
import pl.net.gazda.test.rule.ChromeWebDriver;
import pl.net.gazda.test.rule.CollectionTimeout;
import pl.net.gazda.test.rule.SpringBootApplicationRunner;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

/**
 * Can be run as SpringBootTest but here we are starting the Spring context using class rule.
 */
public class ApplicationTest {
    private static final String APPLICATION_URL = "http://localhost:8080/";
    @ClassRule public static SpringBootApplicationRunner application = new SpringBootApplicationRunner();
    @Rule public ChromeWebDriver driver = new ChromeWebDriver();
    @Rule public AllureReportScreenShooter screenShooter = new AllureReportScreenShooter();
    @Rule public CollectionTimeout collectionTimeout = new CollectionTimeout(6000);

    @Test
    public void should_loadSelectOptions_before6s() {
        applicationPage()
            .userSelectOptions()
            .shouldHave(sizeGreaterThan(0));
    }

    @Test
    public void should_selectMrBAndShowMessage_when_() {
        applicationPage()
            .selectUser("Mr. B")
            .clickShowMessageButton()
            .messageBox()
            .shouldBe(visible)
            .shouldHave(cssClass("message"), text("fail test"));
    }

    private ApplicationPage applicationPage() {
        return open(APPLICATION_URL, ApplicationPage.class);
    }
}
