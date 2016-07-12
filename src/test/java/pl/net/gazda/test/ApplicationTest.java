package pl.net.gazda.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.net.gazda.test.rule.AllureReportScreenShooter;
import pl.net.gazda.test.rule.ChromeWebDriver;
import pl.net.gazda.test.rule.CollectionTimeout;
import pl.net.gazda.webapp.Application;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {
    @Rule public ChromeWebDriver driver = new ChromeWebDriver();
    @Rule public AllureReportScreenShooter screenShooter = new AllureReportScreenShooter();
    @Rule public CollectionTimeout collectionTimeout = new CollectionTimeout(6000);

    @Test
    public void should_select_existing_option_before_6s() {
        ApplicationPage applicationPage = open("http://localhost:8080", ApplicationPage.class);
        applicationPage.userSelectOptions().shouldHave(sizeGreaterThan(0));
    }

    @Test
    public void should_select_MrB_and_show_message() {
        ApplicationPage applicationPage = open("http://localhost:8080", ApplicationPage.class);
        applicationPage.userSelectOptions().shouldHave(sizeGreaterThan(0));
        applicationPage.selectUser("Mr. B").pressShowMessageButton();
        applicationPage.messageBox()
            .shouldBe(visible)
            .shouldHave(cssClass("message"), text("fail test"));
    }

    public static class ApplicationPage {
        @FindBy(how = How.ID, using = "userSelect")
        private SelenideElement userSelect;
        @FindBy(how = How.ID, using = "showMessageButton")
        private SelenideElement showMessageButton;
        @FindBy(how = How.ID, using = "messageBox")
        private SelenideElement messageBox;

        public ApplicationPage selectUser(String name) {
            userSelect().selectOptionByValue(name);
            return this;
        }

        public ApplicationPage pressShowMessageButton() {
            showMessageButton.click();
            return this;
        }

        public SelenideElement userSelect() {
            return userSelect;
        }

        public ElementsCollection userSelectOptions() {
            return userSelect.$$("option");
        }

        public SelenideElement messageBox() {
            return messageBox;
        }
    }
}
