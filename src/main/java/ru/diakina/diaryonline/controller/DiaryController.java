package ru.diakina.diaryonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.diakina.diaryonline.dto.DiaryCreateForm;
import ru.diakina.diaryonline.model.Diary;

import ru.diakina.diaryonline.model.Record;
import ru.diakina.diaryonline.service.diary.DiaryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/diaries")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PostMapping
    public String createDiary(@Valid DiaryCreateForm dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(dto);
            return "diaries";
        }

        //signUpService.signUp(dto);
        return "redirect:diaries";
    }

    @GetMapping
    public String getAllDiaries(Model model) {
        List<Diary> diaries = diaryService.findAllDiaries();
        model.addAttribute("diaries", diaries);
        return "diaries";
    }

    @GetMapping(value = "/{id}")
    public String getDiaryRecords(@PathVariable("id") Long id, Model model) {
        Diary diary = diaryService.getDiaryById(id);
        List<Record> records = diaryService.getDiaryRecords(diary);
        model.addAttribute("name", diary.getName());
        model.addAttribute("records", records);
        return "diary";
    }

    @PostMapping(value = "/{diary-id}/delete")
    public String deleteDiary(@PathVariable("diary-id") Long diaryId) {
        diaryService.deleteDiary(diaryId);
        return "redirect:/accounts";
    }
}
