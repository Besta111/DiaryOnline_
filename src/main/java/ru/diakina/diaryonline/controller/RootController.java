package ru.diakina.diaryonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class RootController {

    @GetMapping
    public String getRoot() {
        return "redirect:/profile";
    }
}
