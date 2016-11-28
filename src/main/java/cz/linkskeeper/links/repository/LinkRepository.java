package cz.linkskeeper.links.repository;

import cz.linkskeeper.links.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
