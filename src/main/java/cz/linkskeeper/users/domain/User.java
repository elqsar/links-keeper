package cz.linkskeeper.users.domain;

import cz.linkskeeper.links.domain.Link;
import cz.linkskeeper.users.validators.Username;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
public class User {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    @Username
    private String userName;
    
    private String mail;

    private String password;

    @OneToMany
    private Set<Link> links;
}
