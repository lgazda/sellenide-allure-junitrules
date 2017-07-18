package pl.net.gazda.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping
    public List<User> users () throws InterruptedException {
        delay(SECONDS, 5);

        List<User> users = generateUsers(50);
        users.addAll(asList(User.of("Mr. B"), User.of("Face"), User.of("Hannibal")));

        return users;
    }

    private List<User> generateUsers(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> User.of(randomAlphabetic(5)))
            .collect(toList());
    }

    private static void delay(TimeUnit unit, long units) {
        try {
            unit.sleep(units);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
