package cz.linkskeeper.links.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Link {

    @Id @GeneratedValue
    private Long id;

    private String url;

    private String description;
}
