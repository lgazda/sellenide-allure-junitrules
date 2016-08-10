package pl.net.gazda.test.rule;

import com.codeborne.selenide.Configuration;
import org.junit.rules.ExternalResource;


public class SelenideTargetConfiguration extends ExternalResource {
    @Override
    protected void before() {
        Configuration.reportsFolder = "target/selenide";
    }
}
