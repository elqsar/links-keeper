package cz.linkskeeper.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("cz.linkskeeper")
@EnableJpaRepositories("cz.linkskeeper")
@EntityScan("cz.linkskeeper")
public class LinksKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinksKeeperApplication.class, args);
	}
}
