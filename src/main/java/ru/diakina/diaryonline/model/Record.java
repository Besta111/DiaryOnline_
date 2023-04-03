package ru.diakina.diaryonline.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_id_generator")
    @SequenceGenerator(name = "record_id_generator",
            sequenceName = "record_id_seq", allocationSize = 1)
    private long id;
    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diary_id")
    private Diary diary;

}
