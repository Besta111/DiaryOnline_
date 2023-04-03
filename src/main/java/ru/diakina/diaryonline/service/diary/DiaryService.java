package ru.diakina.diaryonline.service.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diakina.diaryonline.dto.DiaryCreateForm;
import ru.diakina.diaryonline.dto.DiaryUpdateForm;
import ru.diakina.diaryonline.model.Diary;
import ru.diakina.diaryonline.model.Person;
import ru.diakina.diaryonline.model.Record;
import ru.diakina.diaryonline.repository.DiaryRepository;
import ru.diakina.diaryonline.service.account.AccountService;

import java.util.List;
import java.util.Optional;


@Service
public class DiaryService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private DiaryRepository diaryRepository;

    public List<Diary> getDiary(){
        return diaryRepository.findAll();
    }

    public Diary createDiary(DiaryCreateForm diaryCreateForm) {
        Diary diary = new Diary();
        diary.setName(diaryCreateForm.getName());
        Person current = accountService.getCurrentUser();
        diary.setPerson(current);
        //TODO set tags
        diaryRepository.save(diary);
        return diary;
    }

    public Diary updateDiary(DiaryUpdateForm diaryForm) {
        Optional<Diary> diary = diaryRepository.findById(diaryForm.getId());
        if(diary.isPresent()){
            Diary d = diary.get();
            d.setName(diaryForm.getName());
            //TODO set tags
            return d;
        }
        return null;
    }

    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    public List<Diary> findAllDiaries() {
        List<Diary> diaries = diaryRepository.findAll();
        return diaries;
    }

    public List<Diary> findMyDiaries() {
        List<Diary> diaries = diaryRepository.findAll();
        return diaries;
    }

    public List<Record> getDiaryRecords(Diary diary) {
        return recordService.getRecordsByDiary(diary);
    }

    public Diary getDiaryById(Long id) {
        return diaryRepository.findById(id).get();
    }
}
