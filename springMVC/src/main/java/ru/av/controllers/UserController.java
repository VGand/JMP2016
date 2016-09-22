package ru.av.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.av.bean.LoginBean;
import ru.av.bean.SearchBean;
import ru.av.bean.User;
import ru.av.repository.UserRepository;
import ru.av.repository.UserRepositoryImpl;

import java.util.List;

/**
 * Created by Полина on 22.09.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserRepository userRepositoryImpl;

    @RequestMapping(value = {"/", "/search"})
    public ModelAndView getUserList(@ModelAttribute("searchBean")SearchBean searchBean) {
        List<User> userList = userRepositoryImpl.getAllUsers();

        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }
}
