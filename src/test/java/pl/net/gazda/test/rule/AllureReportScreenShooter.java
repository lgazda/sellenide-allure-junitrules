package pl.net.gazda.test.rule;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.ex.ErrorMessages;
import com.codeborne.selenide.ex.UIAssertionError;
import com.codeborne.selenide.junit.ScreenShooter;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Adds screenshot to allure report on selenide UI assertion failure.
 * Adopted {@link com.codeborne.selenide.junit.ScreenShooter} implementation.
 */
public class AllureReportScreenShooter extends TestWatcher {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    protected void starting(Description test) {
        Screenshots.startContext(test.getClassName(), test.getMethodName());
    }
    @Override
    protected void failed(Throwable e, Description description) {
        if(!(e instanceof UIAssertionError)) {
            this.log.info(ErrorMessages.screenshot());
        } else {
            addScreenshotToAllureReport();
        }
    }

    @Override
    protected void finished(Description description) {
        Screenshots.finishContext();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] addScreenshotToAllureReport() {
        try {
            File screenshot = Screenshots.getLastScreenshot();
            return Files.toByteArray(screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
