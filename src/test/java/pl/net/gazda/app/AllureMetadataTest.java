package pl.net.gazda.app;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static junit.framework.TestCase.fail;


@DisplayName("AllureMetadataTest Display Name")
@Features({@Feature("Meta data feature")})
public class AllureMetadataTest {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Story("Story 1")
    @Description("Shows how step/title/description works in Allure framework")
    public void firstTest() {
        firstStep();
        secondStep();
        stepWithoutAnnotations();
        fail();
    }

    @Test
    @Story("Story 2")
    @Description("Second story")
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

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story 2")
    public void secondTestToStory2() {

    }

    @Step("First step.")
    @Description("First step description")
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

    @Step("Sum {a} + {b}")
    private int sum(int a, int b) {
        return a + b;
    }

    @Step("Runtime Exception")
    @Description("Throws a runtime exception")
    private void runtimeException() {
        throw new RuntimeException("Kaboom ");
    }

    private void stepWithoutAnnotations() {

    }
}
