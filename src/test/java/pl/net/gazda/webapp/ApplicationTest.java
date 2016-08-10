package pl.net.gazda.webapp;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import pl.net.gazda.test.page.ApplicationPage;
import pl.net.gazda.test.rule.AllureReportScreenShooter;
import pl.net.gazda.test.rule.ChromeWebDriver;
import pl.net.gazda.test.rule.CollectionTimeout;
import pl.net.gazda.test.rule.SpringBootApplicationRunner;
import pl.net.gazda.webapp.Application;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


public class ApplicationTest {
    public static final String APPLICATION_URL = "http://localhost:8080/";
    @ClassRule public static SpringBootApplicationRunner application = new SpringBootApplicationRunner();
    @Rule public ChromeWebDriver driver = new ChromeWebDriver();
    @Rule public AllureReportScreenShooter screenShooter = new AllureReportScreenShooter();
    @Rule public CollectionTimeout collectionTimeout = new CollectionTimeout(6000);

    @Test
    public void should_select_existing_option_before_6s() {
        ApplicationPage applicationPage = openApplicationPage();
        applicationPage.userSelectOptions().shouldHave(sizeGreaterThan(0));
    }

    @Test
    public void should_select_MrB_and_show_message() {
        ApplicationPage applicationPage = openApplicationPage();
        applicationPage.userSelectOptions().shouldHave(sizeGreaterThan(0));
        applicationPage.selectUser("Mr. B").clickShowMessageButton();
        applicationPage.messageBox()
            .shouldBe(visible)
            .shouldHave(cssClass("message"), text("fail test"));
    }

    private ApplicationPage openApplicationPage() {
        return open(APPLICATION_URL, ApplicationPage.class);
    }
}
