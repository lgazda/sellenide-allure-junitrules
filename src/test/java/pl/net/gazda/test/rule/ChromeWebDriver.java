package pl.net.gazda.test.rule;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static java.lang.System.setProperty;

public class ChromeWebDriver extends SelenideConfiguration {
    @Override
    protected void before() throws Throwable {
        super.before();
        setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        setWebDriver(new ChromeDriver());
    }

    @Override
    protected void after() {
        WebDriverRunner.closeWebDriver();
    }
}
