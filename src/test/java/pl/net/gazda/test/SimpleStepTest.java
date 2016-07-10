package pl.net.gazda.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;

@RunWith(JUnit4.class)
@Description("Ta klasa testuje cos tam")
public class SimpleStepTest {
    @Test
    public void firstTest() {
        someMethod();
        someMethod1();
        someMethod2();
        someMethod();
    }

    @Test

    public void secondTest() {
        someMethod();
        someMethod2();
    }

    @Step("someMethod")
    private void someMethod() {
        System.out.println("someMethod");
        someMethooood();
    }

    private void someMethod1() {
        System.out.println("someMethod 1");
    }

    @Step("To jest metoda 2")
    private void someMethod2() {
        System.out.println("someMethod 2");
        throw new RuntimeException("Kaboom ");
    }

    private void someMethooood() {
        System.out.println("someMethooood");
    }
}
