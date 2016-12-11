package cz.linkskeeper.links.domain;

import cz.linkskeeper.users.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Link {

    @Id @GeneratedValue
    @Column(name = "ID_LINK")
    private Long id;

    private String url;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
}
