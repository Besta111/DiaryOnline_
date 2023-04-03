package ru.diakina.diaryonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.diakina.diaryonline.dto.SignUpForm;
import ru.diakina.diaryonline.service.auth.SignUpService;

import javax.validation.Valid;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }
    //Мы получаем страницу регистрации
    @GetMapping
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    //Отправить данные для регистрации
    @PostMapping
    public String signUp(@Valid SignUpForm dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(dto);
            return "signUp";
        }

        signUpService.signUp(dto);
        return "redirect:/signIn";
    }
}
