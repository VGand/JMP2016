package ru.av.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.av.bean.LoginBean;

/**
 * Created by Полина on 24.02.2016.
 */
@Controller
public class LoginController {

    @RequestMapping({"/", "/login"})
    public String greeting(@ModelAttribute("loginBean")LoginBean loginBean) {

        return "login";
    }
}
