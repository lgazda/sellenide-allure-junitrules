package pl.net.gazda.test;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static junit.framework.Assert.fail;

@Description("Shows how step/title/description work")
@Title("Allure Metadata Test")
public class AllureMetadataTest {
    @Test
    @Title(("First test"))
    @Severity(SeverityLevel.BLOCKER)
    @Stories("Story 1")
    @Features("JIRA-1 feature, JIRA-11 and other")
    public void firstTest() {
        firstStep();
        secondStep();
        stepWithoutAnnotations();
        fail();
    }

    @Test
    @Stories("Story 1")
    @Features("JIRA-33")
    public void secondTest() {
        firstStep();
        runtimeException();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("This is a first passed test")
    public void thirdTest() {
        firstStep();
        secondStep();
    }

    @Step("First step. Step method name {method}")
    private void firstStep() {
        sum(10, 2);
        sum(2, 2);
        sum(1, 2);
    }

    @Step("Second step")
    @Description("Second step description")
    private void secondStep() {
        stepWithoutAnnotations();
    }

    @Step("Sum {0} + {1}")
    private void sum(int a, int b) {

    }

    @Step("Runtime Exception")
    @Description("Throws a runtime exception")
    private void runtimeException() {
        throw new RuntimeException("Kaboom ");
    }

    private void stepWithoutAnnotations() {

    }
}
