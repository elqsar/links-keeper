package cz.linkskeeper;

import cz.linkskeeper.app.LinksKeeperApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
@ContextConfiguration(classes = {LinksKeeperApplication.class})
public class LinksKeeperApplicationTests {

	@Test
	public void contextLoads() {
	}

}
