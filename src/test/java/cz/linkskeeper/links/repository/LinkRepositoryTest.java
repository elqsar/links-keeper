package cz.linkskeeper.links.repository;

import cz.linkskeeper.app.LinksKeeperApplication;
import cz.linkskeeper.links.domain.Link;
import cz.linkskeeper.users.domain.User;
import cz.linkskeeper.users.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {LinksKeeperApplication.class})
@Transactional
public class LinkRepositoryTest {

    @Autowired
    private LinkRepository linkRepository;

    @Test
    public void shouldReturnLinks() {
        long count = linkRepository.count();
        assertThat(count).isNotEqualTo(0);
    }
}
