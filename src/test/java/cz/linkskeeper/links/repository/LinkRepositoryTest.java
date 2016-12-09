package cz.linkskeeper.links.repository;

import cz.linkskeeper.app.LinksKeeperApplication;
import cz.linkskeeper.links.domain.Link;
import cz.linkskeeper.users.domain.User;
import cz.linkskeeper.users.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {LinksKeeperApplication.class})
public class LinkRepositoryTest {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldAddLinks() {
        Link link = new Link();
        link.setDescription("Description");
        link.setUrl("http://example.com");

        linkRepository.save(link);

        Link otherLink = linkRepository.findOne(link.getId());
        Assert.assertEquals(otherLink.getDescription(), link.getDescription());
        Assert.assertEquals(otherLink.getUrl(), link.getUrl());

        linkRepository.delete(otherLink);
    }

    @Test
    public void shouldAddLinks2User() {
        User user = new User();
        user.setFirstName("fn");
        user.setLastName("ln");
        user.setUserName("#un");
        user.setMail("ml");

        Link link1 = new Link();
        link1.setDescription("Description1");
        link1.setUrl("http://example.com1");

        Link link2 = new Link();
        link2.setDescription("Description2");
        link2.setUrl("http://example.com2");

        user.getLinks().add(link1);
        user.getLinks().add(link2);
        userRepository.save(user);

        Set<Link> set = new HashSet<>();
        set.add(link1);
        set.add(link2);

        User newUser = userRepository.findOne(user.getId());
        Assert.assertEquals(newUser.getLinks(), set);

//        linkRepository.delete(otherLink);
    }


}
