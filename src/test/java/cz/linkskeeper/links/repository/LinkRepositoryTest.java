package cz.linkskeeper.links.repository;

import cz.linkskeeper.app.LinksKeeperApplication;
import cz.linkskeeper.links.domain.Link;
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
public class LinkRepositoryTest {

    @Autowired
    private LinkRepository linkRepository;

    @Test
    public void shouldAddLinks() {
        Link link = new Link();
        link.setDescription("Description");
        link.setUrl("http://example.com");

        linkRepository.save(link);
    }
}
