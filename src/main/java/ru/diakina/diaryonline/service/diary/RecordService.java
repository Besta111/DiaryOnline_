package ru.diakina.diaryonline.service.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diakina.diaryonline.model.Diary;
import ru.diakina.diaryonline.model.Record;
import ru.diakina.diaryonline.repository.RecordRepository;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public List<Record> getAllRecords(){return recordRepository.findAll();
    }

    public List<Record> getRecordsByDiary(Diary diary) {
        return recordRepository.findByDiary(diary);
    }
}
