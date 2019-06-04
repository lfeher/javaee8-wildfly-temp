package com.lfeher.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "USER_SZEREP", schema = "LFEHER")
@Data
@NoArgsConstructor
public class UserSzerep {

    @Id
    @Column(name = "U2R_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SZEREP_ID_SEQ")
    @SequenceGenerator(sequenceName = "USER_SZEREP_SEQ", allocationSize = 1, name = "USER_SZEREP_ID_SEQ")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "U2R_USER_ID", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "U2R_ROL_ID", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Szerep szerep;

    @Column(name = "U2R_USER_ID", nullable = false, updatable = false, insertable = false)
    private Long userId;

    @Column(name = "U2R_ROL_ID", nullable = false, updatable = false, insertable = false)
    private Long rolId;

}
