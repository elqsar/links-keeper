package cz.linkskeeper.users.repository;

import cz.linkskeeper.app.LinksKeeperApplication;
import cz.linkskeeper.users.domain.User;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {LinksKeeperApplication.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindSomeUsers() {
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isNotEqualTo(0);
    }

    @Test
    public void shouldFindUserByUsername() {
        User user = userRepository.findByUserName("boris");
        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Boris");
        assertThat(user.getLastName()).isEqualTo("Musatov");
    }
}
