package ru.diakina.diaryonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.diakina.diaryonline.model.Person;
import ru.diakina.diaryonline.service.account.AccountService;

import java.util.List;


@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //http:localhost:8080/accounts
    @GetMapping
    public String getAllAccounts(Model model) {
        List<Person> accounts = accountService.findAllAccounts();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @PostMapping(value = "/{account-id}/delete")
    public String deleteAccount(@PathVariable("account-id") Long accountId) {
        accountService.deleteAccount(accountId);
        return "redirect:/accounts";
    }
}
