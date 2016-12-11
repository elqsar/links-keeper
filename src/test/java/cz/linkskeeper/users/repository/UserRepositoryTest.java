package cz.linkskeeper.users.repository;

import cz.linkskeeper.app.LinksKeeperApplication;
import cz.linkskeeper.links.domain.Link;
import cz.linkskeeper.users.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {LinksKeeperApplication.class})
@Transactional
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

    @Test
    public void shouldFindByUserNameLike() {
        List<User> users = userRepository.findByUserNameLike("#smi%");
        Assert.assertEquals(users.get(0).getUserName(), "#smithy");
    }

    @Test
    public void shouldFindByUserNameNotLike() {
        List<User> users = userRepository.findByUserNameNotLike("sma%");
        Assert.assertEquals(users.get(0).getUserName(), "boris");
    }

    @Test
    public void shouldFindByFirstNameLikeAndLastName() {
        List<User> users = userRepository.findByFirstNameLikeAndLastName("Jo%", "Smith");
        Assert.assertEquals(users.get(0).getUserName(), "#smithy");
    }

    @Test
    public void shouldUserHaveLinks() {
        User user = userRepository.getOne(1L);
        Set<Link> links = user.getLinks();
        assertThat(links.size()).isNotEqualTo(0);
    }
}
