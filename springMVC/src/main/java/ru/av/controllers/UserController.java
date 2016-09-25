package ru.av.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.av.bean.AuthorizationInfo;
import ru.av.bean.Role;
import ru.av.bean.SearchBean;
import ru.av.bean.User;
import ru.av.exception.NoPermissionException;
import ru.av.repository.UserRepository;
import ru.av.utils.UserFilterUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    public String deleteUser(@PathVariable Long id, HttpServletRequest request) throws NoPermissionException {
        checkPermissionForChange(request);
        userRepositoryImpl.delete(id);

        return "redirect:/user/";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable Long id, @Valid @ModelAttribute("user")User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userRepositoryImpl.updateUser(user);

            return "forward:/user/" + user.getId();
        }
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public ModelAndView getCreateView(HttpServletRequest request) throws NoPermissionException {
        checkPermissionForChange(request);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {

            userRepositoryImpl.createUser(user);

            return "forward:/user/" + user.getId();
        }
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserInfo(@PathVariable Long id, HttpServletRequest request) throws NoPermissionException {
        checkPermissionForChange(request);

        User user = userRepositoryImpl.getUserById(id);

        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @ExceptionHandler(NoPermissionException.class)
    public ModelAndView handleNoPermissionException() {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", "User has no permission for create and edit and delete");
        return mav;
    }

    private void checkPermissionForChange(HttpServletRequest request) throws NoPermissionException {
        AuthorizationInfo authorizationInfo = (AuthorizationInfo) request.getSession().getAttribute("authorizationInfo");
        if (authorizationInfo == null || authorizationInfo.getUserAuthorizationInfo() == null
                || authorizationInfo.getUserAuthorizationInfo().getUserRole() != Role.ADMIN) {
            throw new NoPermissionException();
        }
    }
}
