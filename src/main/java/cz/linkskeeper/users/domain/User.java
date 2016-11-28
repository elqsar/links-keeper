package cz.linkskeeper.users.domain;

import cz.linkskeeper.links.domain.Link;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Setter
@Getter
public class User {

    @Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String userName;
    
    private String mail;

    private String password;

//    private Set<Link> links;
}
