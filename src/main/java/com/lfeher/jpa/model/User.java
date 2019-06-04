package com.lfeher.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS", schema = "LFEHER")
@Data
@NoArgsConstructor
@NamedQuery(name = User.FIND_ALL, query = "select u from User u left join fetch u.userszerepek")
public class User {

    public static final String FIND_ALL= "User.findAll";

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @SequenceGenerator(sequenceName = "USER_SEQ", allocationSize = 1, name = "USER_ID_SEQ")
    private Long id;

    @Column(name = "USER_EMAIL", length = 200)
    private String email;

    @Column(name = "USER_FELHASZNALONEV", length = 200, nullable = false)
    private String felhasznalonev;

    @OneToMany(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<UserSzerep> userszerepek;
}
