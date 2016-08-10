package pl.net.gazda.test.rule;

import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.net.gazda.webapp.Application;

public class SpringBootApplicationRunner extends ExternalResource {
    private ConfigurableApplicationContext context;

    @Override
    protected void before() throws Throwable {
        context = SpringApplication.run(Application.class, new String[]{});
    }

    @Override
    protected void after() {
        context.stop();
    }
}
