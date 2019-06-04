package com.lfeher.jpa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SZEREP", schema = "LFEHER")
@Data
@NoArgsConstructor
public class Szerep {

    @Id
    @Column(name = "ROL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SZEREP_ID_SEQ")
    @SequenceGenerator(sequenceName = "SZEREP_SEQ", allocationSize = 1, name = "SZEREP_ID_SEQ")
    private Long id;

    @Column(name = "ROL_NEV", length = 200, nullable = false)
    private String nev;

    @Column(name = "ROL_KOD", length = 20, nullable = false)
    private String kod;
}
