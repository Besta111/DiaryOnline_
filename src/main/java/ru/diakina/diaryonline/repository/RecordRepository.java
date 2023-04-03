package ru.diakina.diaryonline.repository;

import ru.diakina.diaryonline.model.Diary;
import ru.diakina.diaryonline.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByDiary(Diary diary);
}
