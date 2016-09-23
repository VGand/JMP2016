package ru.av.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.av.bean.SearchBean;
import ru.av.bean.User;
import ru.av.repository.UserRepository;
import ru.av.utils.UserFilterUtils;

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

        if (searchBean != null && searchBean.getSearchString() != null) {
            userList = UserFilterUtils.filterUserBySearchString(userList, searchBean.getSearchString());
        }

        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView getUser(@PathVariable Long id) {
        User user = userRepositoryImpl.getUserById(id);

        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepositoryImpl.delete(id);

        return "redirect:/user/";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable Long id, @ModelAttribute("user")User user) {
        userRepositoryImpl.updateUser(user);

        return "forward:/user/" + user.getId();
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public ModelAndView getCreateView() {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user")User user) {
        userRepositoryImpl.createUser(user);

        return "forward:/user/" + user.getId();
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserInfo(@PathVariable Long id) {
        User user = userRepositoryImpl.getUserById(id);

        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
