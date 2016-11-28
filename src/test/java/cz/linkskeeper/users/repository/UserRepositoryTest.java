package cz.linkskeeper.users.repository;

import cz.linkskeeper.app.LinksKeeperApplication;
import cz.linkskeeper.users.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {LinksKeeperApplication.class})
@Profile("test")
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindByUserName() {
        User user = new User();
        user.setFirstName("Joht");
        user.setLastName("Smith");
        user.setUserName("smithy");

        userRepository.save(user);

        User anotherUser = userRepository.findByUserName("smithy");

        Assert.assertEquals(anotherUser.getUserName(), user.getUserName());
    }
}
