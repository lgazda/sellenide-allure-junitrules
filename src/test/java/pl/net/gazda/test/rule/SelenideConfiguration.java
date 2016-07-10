package pl.net.gazda.test.rule;

import com.codeborne.selenide.Configuration;
import org.junit.rules.ExternalResource;


public class SelenideConfiguration extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        Configuration.reportsFolder = "target/selenide";
    }
}
