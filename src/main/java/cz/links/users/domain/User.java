package cz.links.users.domain;

import cz.links.links.domain.Link;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Setter
@Getter
public class User {
    private String firstName;

    private String lastName;

    private String userName;
    
    private String mail;

    private String password;

    private Set<Link> links;
}
