package ru.diakina.diaryonline.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_id_generator")
    @SequenceGenerator(name = "record_id_generator",
            sequenceName = "record_id_seq", allocationSize = 1)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private Record record;

    @Enumerated(EnumType.STRING)
    private ContentType type;

    @Column
    private String link;
}
