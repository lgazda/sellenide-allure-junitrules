package pl.net.gazda.test.rule;

import com.codeborne.selenide.Configuration;
import org.junit.rules.ExternalResource;

public class CollectionTimeout extends ExternalResource {
    private final long timeout;
    private final long defaultTimeout;

    public CollectionTimeout(long timeout) {
        this.timeout = timeout;
        this.defaultTimeout = Configuration.collectionsTimeout;
    }

    @Override
    protected void before() throws Throwable {
        Configuration.collectionsTimeout = timeout;
    }

    @Override
    protected void after() {
        Configuration.collectionsTimeout = defaultTimeout;
    }
}
