package ru.diakina.diaryonline.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "diary")

public class Diary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diary_id_generator")
    @SequenceGenerator(name = "diary_id_generator",
            sequenceName = "diary_id_seq", allocationSize = 1)
    private long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany
    private List<Tag> tags;
}
