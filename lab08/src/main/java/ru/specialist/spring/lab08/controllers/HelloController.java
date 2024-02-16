package ru.specialist.spring.lab08.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.specialist.spring.lab08.model.UserVM;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserVM userVM;

    @RequestMapping(method = RequestMethod.GET) // /hello GET
    public String showForm(Model uiModel) {
        uiModel.addAttribute("user", userVM);
        return "hello/form";
    }

    @RequestMapping(method = RequestMethod.POST) // /hello POST
    public String showHello(UserVM userVM, BindingResult bindingResult, Model uiModel) {
        //if (bindingResult.hasErrors())
        this.userVM.setUserName(userVM.getUserName());

        uiModel.addAttribute("user", this.userVM);
        return "hello/form";
    }
}
