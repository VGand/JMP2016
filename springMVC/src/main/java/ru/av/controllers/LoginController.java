package ru.av.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.av.bean.LoginBean;

/**
 * Created by Полина on 24.02.2016.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String greeting(@ModelAttribute("loginBean")LoginBean loginBean) {

        return "login";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("loginBean")LoginBean loginBean) {

        return "login";
    }
}
