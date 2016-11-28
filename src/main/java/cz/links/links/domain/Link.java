package cz.links.links.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Link {
    private String url;

    private String description;
}
